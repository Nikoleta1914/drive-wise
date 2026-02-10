CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE SCHEMA IF NOT EXISTS drive_wise;


CREATE TABLE IF NOT EXISTS drive_wise.users
(
    id           UUID PRIMARY KEY      DEFAULT gen_random_uuid(),

    email        VARCHAR(255) UNIQUE,
    phone        VARCHAR(50) UNIQUE,

    display_name VARCHAR(255) NOT NULL,

    created_at   TIMESTAMPTZ  NOT NULL DEFAULT now(),

    status       VARCHAR(20)  NOT NULL CHECK (status IN ('ACTIVE', 'BANNED')),

    CONSTRAINT email_or_phone_required
        CHECK (email IS NOT NULL OR phone IS NOT NULL)
);

CREATE TABLE IF NOT EXISTS drive_wise.trips
(
    -- основно id
    id                UUID PRIMARY KEY     DEFAULT gen_random_uuid(),

    -- кой driver (user) притежава trip-а
    user_id           UUID        NOT NULL,

    -- статус на trip-а
    status            VARCHAR(20) NOT NULL
        CHECK (status IN ('CREATED', 'STARTED', 'ENDED', 'CANCELLED')),

    -- времена
    start_time        TIMESTAMPTZ,
    end_time          TIMESTAMPTZ,

    -- координати (double precision = число с десетична точка)
    -- Latitude-Географска ширина, Longitude-Географска дължина
    origin_lat        DOUBLE PRECISION,
    origin_lng        DOUBLE PRECISION,
    destination_lat   DOUBLE PRECISION,
    destination_lng   DOUBLE PRECISION,

    -- планиран маршрут (от routing API)
    route_distance_m  INTEGER,
    route_duration_s  INTEGER,
    route_polyline    TEXT,
    route_provider    VARCHAR(20),
    route_computed_at TIMESTAMPTZ,

    -- реално изминати (от telemetry)
    actual_distance_m INTEGER,
    actual_duration_s INTEGER,

    -- score (по подразбиране 0)
    score_total       INTEGER     NOT NULL DEFAULT 0,

    -- връзка към users таблицата
    CONSTRAINT fk_trips_user
        FOREIGN KEY (user_id)
            REFERENCES drive_wise.users (id)
            ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS drive_wise.telemetry_points
(
    -- автоматично растящо ID (не UUID, защото ще са МНОГО записи)
    id          BIGSERIAL PRIMARY KEY,

    -- към кой trip принадлежи точката
    trip_id     UUID             NOT NULL,

    -- кога е записана точката от устройството
    recorded_at TIMESTAMPTZ      NOT NULL,

    -- кога сървърът я е получил
    received_at TIMESTAMPTZ      NOT NULL DEFAULT now(),

    -- GPS координати
    lat         DOUBLE PRECISION NOT NULL,
    lng         DOUBLE PRECISION NOT NULL,

    -- допълнителни данни (може да ги няма)
    speed_mps   DOUBLE PRECISION,
    heading_deg DOUBLE PRECISION,
    accuracy_m  DOUBLE PRECISION,

    -- откъде идва точката
    source      VARCHAR(20)      NOT NULL
        CHECK (source IN ('GPS')),

    -- връзка към trips
    CONSTRAINT fk_telemetry_trip
        FOREIGN KEY (trip_id)
            REFERENCES drive_wise.trips (id)
            ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS drive_wise.driving_events
(
    id         BIGSERIAL PRIMARY KEY,

    trip_id    UUID        NOT NULL,
    user_id    UUID        NOT NULL,

    event_time TIMESTAMPTZ NOT NULL,

    event_type VARCHAR(40) NOT NULL,

    severity   SMALLINT    NOT NULL,

    value      DOUBLE PRECISION,

    lat        DOUBLE PRECISION,
    lng        DOUBLE PRECISION,

    details    JSONB,

    CONSTRAINT fk_event_trip
        FOREIGN KEY (trip_id)
            REFERENCES drive_wise.trips (id),

    CONSTRAINT fk_event_user
        FOREIGN KEY (user_id)
            REFERENCES drive_wise.users (id)
);

CREATE TABLE IF NOT EXISTS drive_wise.points_ledger
(
    id           BIGSERIAL PRIMARY KEY,

    user_id      UUID        NOT NULL,

    trip_id      UUID,

    created_at   TIMESTAMPTZ NOT NULL,

    points_delta INTEGER     NOT NULL,

    reason       VARCHAR(40) NOT NULL,

    ref_event_id BIGINT,

    metadata     JSONB,

    CONSTRAINT fk_ledger_user
        FOREIGN KEY (user_id)
            REFERENCES drive_wise.users (id),

    CONSTRAINT fk_ledger_trip
        FOREIGN KEY (trip_id)
            REFERENCES drive_wise.trips (id),

    CONSTRAINT fk_ledger_event
        FOREIGN KEY (ref_event_id)
            REFERENCES drive_wise.driving_events (id)
);

CREATE TABLE IF NOT EXISTS drive_wise.rewards
(
    id          UUID PRIMARY KEY      DEFAULT gen_random_uuid(),

    name        VARCHAR(120) NOT NULL,

    description TEXT,

    points_cost INTEGER      NOT NULL,

    active      BOOLEAN      NOT NULL,

    stock       INTEGER,

    partner     VARCHAR(120),

    created_at  TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE TABLE IF NOT EXISTS drive_wise.rewards
(
    id          uuid PRIMARY KEY      DEFAULT gen_random_uuid(),

    name        VARCHAR(120) NOT NULL,

    description TEXT,

    points_cost INTEGER      NOT NULL,

    active      BOOLEAN      NOT NULL,

    stock       INTEGER,

    partner     VARCHAR(120),

    created_at  TIMESTAMPTZ  NOT NULL DEFAULT now()

);

CREATE TABLE IF NOT EXISTS drive_wise.redemptions
(
    id           uuid PRIMARY KEY     DEFAULT gen_random_uuid(),

    user_id      uuid        NOT NULL,
    reward_id    uuid        NOT NULL,

    created_ad   TIMESTAMPTZ NOT NULL DEFAULT now(),

    status       VARCHAR(20) NOT NULL,
    CHECK ( status IN ('PENDING', 'FULFILLED', 'CANCELLED')),

    points_spent INTEGER     NOT NULL,

    external_ref VARCHAR(255),

    metadata     JSONB,

    CONSTRAINT fk_redemption_user
        FOREIGN KEY (user_id)
            REFERENCES drive_wise.users (id)
            ON DELETE RESTRICT,

    CONSTRAINT fk_redemption_reward
        FOREIGN KEY (reward_id)
            REFERENCES drive_wise.rewards (id)
            ON DELETE RESTRICT
);



