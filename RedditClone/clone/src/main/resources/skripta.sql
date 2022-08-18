DROP DATABASE RedditClone;
CREATE SCHEMA RedditClone;
Use RedditClone;


    Create table Communities (
    id BIGINT AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(255) NOT NULL ,
    description VARCHAR(255) NOT NULL,
    creationDate VARCHAR(255) NOT NULL ,
    isSuspended  BIT NOT NULL,
    suspendedReason VARCHAR(255) NOT NULL,
    deleted BIT NOT NULL,
    PRIMARY KEY (id)
	);


    CREATE TABLE Flairs (
    id BIGINT AUTO_INCREMENT NOT NULL,
    description VARCHAR(255) not null,
    deleted BIT NOT NULL,
    PRIMARY KEY(id)
    );


create TABLE Users (
    id BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) not null,
    avatar VARCHAR(255) NOT NULL,
    registrationDate DATE NOT NULL,
    description VARCHAR(255) NOT NULL,
    displayName VARCHAR(255) NOT NULL,
    deleted BIT NOT NULL,
    idCommunity bigint,
    PRIMARY KEY(id),
    FOREIGN KEY(idCommunity) references Communities(id)
    );
    

Create table Posts (
    id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(255) NOT NULL,
    text VARCHAR(255) NOT NULL,
    creationDate DATE NOT NULL,
    imagePath VARCHAR(255),
    deleted BIT NOT NULL,
    userId bigint,
    idCommunity bigint,
    PRIMARY KEY(id),
    FOREIGN KEY(userId) references Users(id),
    FOREIGN KEY(idCommunity) references Communities(id)
    
    );


Create table Banned (
    id BIGINT AUTO_INCREMENT NOT NULL,
    reportTimestamp DATE NOT NULL,
    deleted BIT NOT NULL,
    idCommunity bigint,
    PRIMARY KEY (id),
    FOREIGN KEY(idCommunity) references Communities(id)
    );

Create table Comments (
    id BIGINT AUTO_INCREMENT NOT NULL,
    text varchar(255) not null,
    reportTimestamp DATE NOT NULL,
    isDeleted BIT NOT NULL,
    deleted BIT NOT NULL,
    userId bigint,
    postId bigint,
    PRIMARY KEY(id),
    FOREIGN KEY(userId) references Users(id),
    FOREIGN KEY (postId) references Posts(id)
    );




Create table Reaction (
    id BIGINT AUTO_INCREMENT NOT NULL,
    typeValue INT not null,
    reporTimestamp DATE NOT NULL,
    deleted BIT NOT NULL,
    userId bigint,
    postId bigint,
    commentId bigint,
    PRIMARY KEY(id),
    FOREIGN KEY(userId) references Users(id),
    FOREIGN KEY (postId) references Posts(id),
    FOREIGN KEY (commentId) references Comments(id)
    );

Create table Report (
    id BIGINT AUTO_INCREMENT  NOT NULL,
    reason INT NOT NULL,
    reportTimestamp DATE NOT NULL,
    accepted BIT NOT NULL,
    deleted BIT NOT NULL,
    commentId bigint,
    postId bigint,
    PRIMARY KEY(id),
    FOREIGN KEY (postId) references Posts(id),
    FOREIGN KEY (commentId) references Comments(id)
	);

Create table Rule (
    id BIGINT AUTO_INCREMENT NOT NULL,
    description VARCHAR(255) NOT NULL,
    deleted BIT NOT NULL,
    idCommunity bigint,
    PRIMARY KEY(id),
    FOREIGN KEY(idCommunity) references Communities(id)
    );


