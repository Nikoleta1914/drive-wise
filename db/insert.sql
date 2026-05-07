-- USERS
INSERT INTO drive_wise.users (email, phone, display_name, status)
VALUES
    ('john@example.com', '+359888111111', 'John Doe', 'ACTIVE'),
    ('anna@example.com', '+359888222222', 'Anna Smith', 'ACTIVE');


-- TRIPS
INSERT INTO drive_wise.trips (
    user_id, status, start_time, end_time,
    origin_lat, origin_lng, destination_lat, destination_lng,
    route_distance_m, route_duration_s,
    actual_distance_m, actual_duration_s,
    score_total
)
VALUES
    (1, 'ENDED', now() - interval '1 hour', now(),
     42.6977, 23.3219, 42.1354, 24.7453,
     150000, 5400,
     152000, 5500,
     85),

    (2, 'STARTED', now() - interval '30 minutes', NULL,
     42.6977, 23.3219, 43.2141, 27.9147,
     500000, 18000,
     NULL, NULL,
     0);


-- TELEMETRY POINTS
INSERT INTO drive_wise.telemetry_points (
    trip_id, recorded_at, lat, lng, speed_mps, source
)
VALUES
    (1, now() - interval '55 minutes', 42.70, 23.32, 15.5, 'GPS'),
    (1, now() - interval '50 minutes', 42.75, 23.40, 20.0, 'GPS'),
    (2, now() - interval '20 minutes', 42.70, 23.32, 10.0, 'GPS');


-- DRIVING EVENTS (FIXED ENUM VALUES)
INSERT INTO drive_wise.driving_events (
    trip_id, user_id, event_time, event_type, severity, value, lat, lng
)
VALUES
    (1, 1, now() - interval '45 minutes', 'HARSH_BRAKE', 3, 5.2, 42.73, 23.35),
    (1, 1, now() - interval '40 minutes', 'HARSH_ACCEL', 2, 4.8, 42.74, 23.36),
    (2, 2, now() - interval '10 minutes', 'SPEEDING', 4, 120.5, 42.80, 23.50);


-- POINTS LEDGER
INSERT INTO drive_wise.points_ledger (
    user_id, trip_id, points_delta, reason
)
VALUES
    (1, 1, 50, 'TRIP_COMPLETED'),
    (1, 1, -10, 'HARSH_BRAKE'),
    (2, 2, 20, 'SAFE_DRIVING');


-- REWARDS
INSERT INTO drive_wise.rewards (
    name, description, points_cost, active, stock, partner
)
VALUES
    ('Free Coffee', 'Get a free coffee at partner cafes', 100, true, 50, 'StarCafe'),
    ('Fuel Discount', '5% discount on fuel', 200, true, 100, 'FuelCo');


-- REDEMPTIONS
INSERT INTO drive_wise.redemptions (
    user_id, reward_id, status, points_spent
)
VALUES
    (1, 1, 'FULFILLED', 100),
    (2, 2, 'PENDING', 200);