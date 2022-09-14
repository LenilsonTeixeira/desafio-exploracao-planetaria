CREATE TABLE probe(
    id SERIAL PRIMARY KEY,
    external_id VARCHAR(100) UNIQUE NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL,
    created_date TIMESTAMPTZ NOT NULL,
    last_modified_date TIMESTAMPTZ NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_external_id ON probe(external_id);

CREATE INDEX IF NOT EXISTS idx_name ON probe(name);