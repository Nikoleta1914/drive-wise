CREATE SCHEMA IF NOT EXISTS drive_wise;

CREATE TABLE IF NOT EXISTS drive_wise.users (
    id BIGSERIAL PRIMARY KEY,

    email VARCHAR(255) UNIQUE,
    phone VARCHAR(50) UNIQUE,
    display_name VARCHAR(255) NOT NULL,

    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    status VARCHAR(20) NOT NULL CHECK (status IN ('ACTIVE', 'BANNED')),

    CONSTRAINT email_or_phone_required
        CHECK (email IS NOT NULL OR phone IS NOT NULL)
);

CREATE TABLE IF NOT EXISTS drive_wise.trips (
    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    status VARCHAR(20) NOT NULL
        CHECK (status IN ('CREATED', 'STARTED', 'ENDED', 'CANCELLED')),

    start_time TIMESTAMPTZ,
    end_time TIMESTAMPTZ,

    origin_lat DOUBLE PRECISION,
    origin_lng DOUBLE PRECISION,
    destination_lat DOUBLE PRECISION,
    destination_lng DOUBLE PRECISION,

    route_distance_m INTEGER,
    route_duration_s INTEGER,
    route_polyline TEXT,
    route_provider VARCHAR(20),
    route_computed_at TIMESTAMPTZ,

    actual_distance_m INTEGER,
    actual_duration_s INTEGER,

    score_total INTEGER NOT NULL DEFAULT 0,

    CONSTRAINT fk_trips_user
        FOREIGN KEY (user_id)
        REFERENCES drive_wise.users(id)
        ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS drive_wise.telemetry_points (
    id BIGSERIAL PRIMARY KEY,

    trip_id BIGINT NOT NULL,

    recorded_at TIMESTAMPTZ NOT NULL,
    received_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    lat DOUBLE PRECISION NOT NULL,
    lng DOUBLE PRECISION NOT NULL,

    speed_mps DOUBLE PRECISION,
    heading_deg DOUBLE PRECISION,
    accuracy_m DOUBLE PRECISION,

    source VARCHAR(20) NOT NULL CHECK (source IN ('GPS')),

    CONSTRAINT fk_telemetry_trip
        FOREIGN KEY (trip_id)
        REFERENCES drive_wise.trips(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS drive_wise.driving_events (
    id BIGSERIAL PRIMARY KEY,

    trip_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,

    event_time TIMESTAMPTZ NOT NULL,
    event_type VARCHAR(40) NOT NULL,

    severity SMALLINT NOT NULL,
    value DOUBLE PRECISION,

    lat DOUBLE PRECISION,
    lng DOUBLE PRECISION,

    details JSONB,

    CONSTRAINT fk_event_trip
        FOREIGN KEY (trip_id)
        REFERENCES drive_wise.trips(id),

    CONSTRAINT fk_event_user
        FOREIGN KEY (user_id)
        REFERENCES drive_wise.users(id)
);

CREATE TABLE IF NOT EXISTS drive_wise.points_ledger (
    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,
    trip_id BIGINT,

    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    points_delta INTEGER NOT NULL,
    reason VARCHAR(40) NOT NULL,

    ref_event_id BIGINT,

    metadata JSONB,

    CONSTRAINT fk_ledger_user
        FOREIGN KEY (user_id)
        REFERENCES drive_wise.users(id),

    CONSTRAINT fk_ledger_trip
        FOREIGN KEY (trip_id)
        REFERENCES drive_wise.trips(id),

    CONSTRAINT fk_ledger_event
        FOREIGN KEY (ref_event_id)
        REFERENCES drive_wise.driving_events(id)
);

CREATE TABLE IF NOT EXISTS drive_wise.rewards (
    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(120) NOT NULL,
    description TEXT,

    points_cost INTEGER NOT NULL,
    active BOOLEAN NOT NULL,
    stock INTEGER,

    partner VARCHAR(120),

    created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE IF NOT EXISTS drive_wise.redemptions (
    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,
    reward_id BIGINT NOT NULL,

    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    status VARCHAR(20) NOT NULL
        CHECK (status IN ('PENDING', 'FULFILLED', 'CANCELLED')),

    points_spent INTEGER NOT NULL,
    external_ref VARCHAR(255),

    metadata JSONB,

    CONSTRAINT fk_redemption_user
        FOREIGN KEY (user_id)
        REFERENCES drive_wise.users(id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_redemption_reward
        FOREIGN KEY (reward_id)
        REFERENCES drive_wise.rewards(id)
        ON DELETE RESTRICT
);