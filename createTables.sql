CREATE TABLE exercise (
       exerciseID          INT             NOT NULL,
       exerciseName        VARCHAR(30)     NOT NULL,
       description         VARCHAR(150)            ,
       PRIMARY KEY(exerciseID)
);

CREATE TABLE exerciseTemplate(
       templateID 		INT 			NOT NULL,
       templateName       	VARCHAR(100) 		NOT NULL,
       PRIMARY KEY (templateID) 
);
CREATE TABLE templateExerciseRelation(
       templateID INT not null,
       exerciseID INT not null,
       FOREIGN KEY (templateID) REFERENCES exerciseTemplate(templateID)
       	       on delete cascade on update cascade,
       FOREIGN key (exerciseID) REFERENCES exercise(exerciseID)
	       on delete cascade on update cascade
);

CREATE TABLE user (
    userID              INT             NOT NULL,
    name                VARCHAR(30)     NOT NULL,
    birthdate           DATE                    ,
    PRIMARY KEY(userID)
);

CREATE TABLE session( 
       sessionID 		INT NOT NULL,
       shape                 	INT                 CHECK ( shape >=1 AND shape <= 10 ),
       note                     VARCHAR(140),
       performance          	INT                 CHECK ( shape >=1 AND shape <= 10 ),
       start                 	DATETIME            NOT NULL,
       end                  	DATETIME            NOT NULL,
       userID 			INT 		    NOT NULL
       PRIMARY KEY(sessionID),
       FOREIGN KEY(userID) REFERENCES user(userID)
       	       ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE sessionOutdoors(
       temperature 		FLOAT,
       weather 			VARCHAR(140),
       sessionID  		INT 			NOT NULL,
       FOREIGN KEY (sessionID) REFERENCES  session(sessionID)
       	       ON DELETE CASCADE ON UPDATE CASCADE       	       
);

CREATE TABLE sessionIndoors(
       spectators 		INT ,
       airQuality        	VARCHAR(140),
       sessionID   		INT 			NOT NULL,
       FOREIGN KEY (sessionID) REFERENCES  session(sessionID)
       	       ON DELETE CASCADE ON UPDATE CASCADE       	       
);

CREATE TABLE exerciseSessionRelation(
       sessionID 		INT 			NOT NULL,
       exerciseID  		INT  			NOT NULL,
       FOREIGN KEY (sessionID ) REFERENCES session(sessionID)
       	       ON DELETE CASCADE ON UPDATE CASCADE,
       FOREIGN KEY (exerciseID) REFERENCES exercise(exerciseID)
       	       ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE exerciseGroup (
        groupID                                INT                         NOT NULL,
        groupName                              VARCHAR(45)                NOT NULL,
        parentGroupID                 	       INT                                                ,
        PRIMARY KEY(groupID),
        FOREIGN KEY(parentGroupID) REFERENCES exerciseGroup(groupID)
);

CREATE TABLE exerciseBelongsToGroup (
        exerciseID                        INT                                NOT NULL,
        groupID                           INT                                NOT NULL,
        PRIMARY KEY(exerciseID, groupID),
        FOREIGN KEY(exerciseID) REFERENCES exercise(exerciseID),
        FOREIGN KEY(groupID) REFERENCES exerciseGroup(groupID)
);

CREATE TABLE exerciseReplacement (
        exercise1ID                        INT                                NOT NULL,
        exercise2ID                 	   INT                                NOT NULL,
        PRIMARY KEY(exercise1ID, exercise2ID),
        FOREIGN KEY(exercise1ID) REFERENCES exercise(exerciseID),
        FOREIGN KEY(exercise2ID) REFERENCES exercise(exerciseID)
);

CREATE TABLE personalBest (
    encumbrance         INT 		NOT NULL,
    setdate             DATE            NOT NULL,
    reps                INT,
    userID              INT             NOT NULL,
    exerciseID          INT             NOT NULL,
    PRIMARY KEY(userID, exerciseID, setdate),
    FOREIGN KEY(exerciseID) REFERENCES exercise(exerciseID),
    FOREIGN KEY(userID) REFERENCES user(userID)
);

CREATE TABLE goal (
    userID              INT             NOT NULL,
    exerciseID          INT             NOT NULL,
    setdate             DATE            NOT NULL,
    encumbrance         INT                     ,
    reps                INT                     ,
    PRIMARY KEY(userID, exerciseID, setdate),
    FOREIGN KEY(exerciseID) REFERENCES exercise(exerciseID),
    FOREIGN KEY(userID) REFERENCES user(userID)
);


drop table  exercise                , exerciseBelongsToGroup  , exerciseGroup           , exerciseReplacement     , exerciseSessionRelation , goal                    , personalBest            , session                 , sessionIndoors          , sessionOutdoors         , user  , exerciseTemplate  ,templateExerciseRelation                ;
