CREATE TYPE subscription_level_enum AS ENUM ('FREE', 'STARTER', 'RESEARCH', 'ENTERPRISE');

CREATE TABLE Actor (
    uid UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email_primary VARCHAR(255) NOT NULL,
    email_secondary VARCHAR(255),
    phone VARCHAR(20) NOT NULL,
    subscription_level subscription_level_enum DEFAULT 'FREE',
    node_name VARCHAR(255),
    node_payload JSONB,
    node_ts TIMESTAMP,
    node_uid UUID
);