CREATE TABLE exercise (
    exerciseID          INT             NOT NULL,
    exerciseName        VARCHAR(30)     NOT NULL,
    description         VARCHAR(150)            ,
    PRIMARY KEY(exerciseID),
);

CREATE TABLE user (
    userID              INT             NOT NULL,
    name                VARCHAR(30)     NOT NULL,
    birthdate           INT                     ,
    PRIMARY KEY(userID),
);