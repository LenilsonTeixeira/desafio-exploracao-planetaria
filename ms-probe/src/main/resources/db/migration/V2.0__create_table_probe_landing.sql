CREATE TABLE probe_landing(
    id SERIAL PRIMARY KEY,
    external_id VARCHAR(100) UNIQUE NOT NULL,
    probe_id INTEGER NOT NULL,
    planet VARCHAR(100) NOT NULL,
    location_x INTEGER NOT NULL,
    location_y INTEGER NOT NULL,
    created_date TIMESTAMPTZ NOT NULL,
    last_modified_date TIMESTAMPTZ NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_external_id ON probe_landing(external_id);