CREATE TABLE driving_events (
                                id BIGSERIAL PRIMARY KEY,

                                trip_id UUID NOT NULL,
                                user_id UUID NOT NULL,

                                event_time TIMESTAMPTZ NOT NULL,
                                event_type VARCHAR(40) NOT NULL,
                                severity SMALLINT NOT NULL,

                                value DOUBLE PRECISION,
                                lat DOUBLE PRECISION,
                                lng DOUBLE PRECISION,

                                details JSONB,

                                CONSTRAINT fk_driving_events_trip
                                    FOREIGN KEY (trip_id)
                                        REFERENCES trips (id)
                                        ON DELETE CASCADE,

                                CONSTRAINT fk_driving_events_user
                                    FOREIGN KEY (user_id)
                                        REFERENCES users (id)
                                        ON DELETE CASCADE
);
