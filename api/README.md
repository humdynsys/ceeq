# API - providing crrud functions for any type of configured representation nodes for the API


# Movements

1. CREATE - provision a new representation with a unique id

2. READ ALL - generate a set or list of representations with a page of data with a limit specified in configuration

3. READ ONE - retrieve the full details of a given representation based on its unique id

4. DELETE - remove a representation from visibility, which may be restored by an administrator

5. UPDATE - update the state of a representation using versioning




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