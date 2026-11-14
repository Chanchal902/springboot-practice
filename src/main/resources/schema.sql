-- CREATE TABLE IF NOT EXISTS Students
-- (
--     Id
--     SERIAL
--     PRIMARY
--     KEY,
--     Name
--     VARCHAR
-- (
--     50
-- ) NOT NULL,
--     Email VARCHAR
-- (
--     50
-- ) UNIQUE,
--     Age INT
--     );

-- CREATE TABLE IF NOT EXISTS Student
-- (
--     Roll
--     INTEGER
--     PRIMARY
--     KEY,
--     Name
--     VARCHAR
-- (
--     100
-- ) NOT NULL
--     );

CREATE TABLE IF NOT EXISTS Emp(
    Id SERIAL PRIMARY KEY ,
    Name VARCHAR(100) NOT NULL ,
    Department VARCHAR(100) NOT NULL ,
    Salary DECIMAL(10,2)
);