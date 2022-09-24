CREATE TABLE probe_command(
    id SERIAL PRIMARY KEY,
    external_id VARCHAR(100) UNIQUE NOT NULL,
    probe_id INTEGER NOT NULL,
    direction VARCHAR(30) NOT NULL,
    command VARCHAR NOT NULL,
    location_x INTEGER NOT NULL,
    location_y INTEGER NOT NULL,
    created_date TIMESTAMPTZ NOT NULL,
    last_modified_date TIMESTAMPTZ NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_external_id ON probe_command(external_id);