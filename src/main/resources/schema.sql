CREATE TABLE IF NOT EXISTS Students
(
    Id
    SERIAL
    PRIMARY
    KEY,
    Name
    VARCHAR
(
    50
) NOT NULL,
    Email VARCHAR
(
    50
) UNIQUE,
    Age INT
    );