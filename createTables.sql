CREATE TABLE exercise (
    exerciseID          INT             NOT NULL,
    exerciseName        VARCHAR(30)     NOT NULL,
    description         VARCHAR(150)            ,
    PRIMARY KEY(exerciseID),
);

CREATE TABLE user (
    userID              INT             NOT NULL,
    name                VARCHAR(30)     NOT NULL,
    birthdate           DATE                    ,
    PRIMARY KEY(userID),
);

CREATE TABLE exerciseGroup (
	groupID				INT 			NOT NULL,
	groupName			VARCHAR(45)		NOT NULL,
	parentGroupID		INT						,
	PRIMARY KEY(groupID),
	FOREIGN KEY(parentGroupID) REFERENCES exerciseGroup(groupID),
);

CREATE TABLE exerciseBelongsToGroup (
	exerciseID			INT				NOT NULL,
	groupID 			INT				NOT NULL,
	PRIMARY KEY(exerciseID, groupID),
	FOREIGN KEY(exerciseID) REFERENCES exercise(exerciseID),
	FOREIGN KEY(groupID) REFERENCES exerciseGroup(groupID)
);

CREATE TABLE exerciseReplacement (
	exercise1ID			INT				NOT NULL,
	exercise2ID 		INT				NOT NULL,
	PRIMARY KEY(exercise1ID, exercise2ID),
	FOREIGN KEY(exercise1ID) REFERENCES exercise(exerciseID),
	FOREIGN KEY(exercise2ID) REFERENCES exercise(exerciseID),
);

CREATE TABLE personalBest (
    userID              INT             NOT NULL,
    exerciseID          INT			    NOT NULL,
    setdate             DATE            NOT NULL,
    load				INT						,
    reps				INT						,
    PRIMARY KEY(userID, exerciseID, setdate),
    FOREIGN KEY(exerciseID) REFERENCES exercise(exerciseID),
    FOREIGN KEY(userID) REFERENCES user(userID),
);

CREATE TABLE goal (
    userID              INT             NOT NULL,
    exerciseID          INT			    NOT NULL,
    setdate             DATE            NOT NULL,
    load				INT						,
    reps				INT						,
    PRIMARY KEY(userID, exerciseID, setdate),
    FOREIGN KEY(exerciseID) REFERENCES exercise(exerciseID),
    FOREIGN KEY(userID) REFERENCES user(userID),
);


