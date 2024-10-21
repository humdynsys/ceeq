CREATE TYPE subscription_level_enum AS ENUM ('FREE', 'STARTER', 'RESEARCH', 'ENTERPRISE');

CREATE TABLE Actor (
uid UUID PRIMARY KEY DEFAULT gen_random_uuid(),
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
email VARCHAR(255) NOT NULL,
phone VARCHAR(20) NOT NULL,
subscription_level subscription_level_enum
);

CREATE TABLE Node (
uid UUID PRIMARY KEY DEFAULT gen_random_uuid(),
name VARCHAR(255) NOT NULL,
payload JSONB NOT NULL,
ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
actor_uuid UUID
);