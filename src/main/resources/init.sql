CREATE TABLE phoneManager(
    id               BIGSERIAL        PRIMARY KEY,
    namePhone        TEXT             NOT NULL,
    versionPhone     TEXT,
    created          timestamp        DEFAULT now()
)