CREATE USER appprobe WITH PASSWORD 'appprobe';

DROP DATABASE IF EXISTS probes;

CREATE DATABASE probes;

GRANT ALL PRIVILEGES ON DATABASE probes TO appprobe;
