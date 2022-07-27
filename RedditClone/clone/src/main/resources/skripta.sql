CREATE SCHEMA RedditClone;
Use RedditClone

Create table Banned {
    id BIGINT AUTO_INCREMENT NOT NULL,
    reportTimestamp DATE NOT NULL,
    deleted BIT NOT NULL,
    idCommunity int,
    PRIMARY KEY (idBanned),
    FOREIGN KEY(idCommunity) references Communities(id)
    };

Create table Comments {
    id BIGINT AUTO_INCREMENT NOT NULL,
    text varchar(255) not null,
    reportTimestamp DATE NOT NULL,
    isDeleted BIT NOT NULL,
    deleted BIT NOT NULL,
    userId int,
    postId int,
    PRIMARY KEY(idComment),
    FOREIGN KEY(userId) references Users(id),
    FOREIGN KEY (postId) references Posts(id)
    };

CREATE table Communities {
    id BIGINT AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(255) NOT NULL ,
    description VARCHAR(255) NOT NULL,
    creationDate VARCHAR(255) NOT NULL ,
    isSuspended  BIT NOT NULL,
    suspendedReason VARCHAR(255) NOT NULL,
    deleted BIT NOT NULL,
    flairID int,
    PRIMARY KEY (idCommunity),
    FOREIGN KEY(flairID) REFERENCES Flairs(id)



    };

CREATE TABLE Flairs {
    id BIGINT AUTO_INCREMENT NOT NULL,
    description VARCHAR(255) not null,
    deleted BIT NOT NULL,
    postID int,
    PRIMARY KEY(idFlair),
    FOREIGN KEY (postID) references Posts(id)
    };

Create table Posts {
    id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(255) NOT NULL,
    text VARCHAR(255) NOT NULL,
    creationDate DATE NOT NULL,
    imagePath VARCHAR NOT NULL,
    deleted BIT NOT NULL,
    userId int,
    communityId int,
    PRIMARY KEY(idPost),
    FOREIGN KEY(userId) references Users(id),
    FOREIGN KEY(communityId) references Communities(id)

    };

Create table Reaction {
    id BIGINT AUTO_INCREMENT NOT NULL,
    typeValue INT not null,
    reporTimestamp DATE NOT NULL,
    deleted BIT NOT NULL,
    userId int,
    postId int,
    commentId int,
    PRIMARY KEY(idReaction),
    FOREIGN KEY(userId) references Users(id),
    FOREIGN KEY (postId) references Posts(id),
    FOREIGN KEY (commentId) references Comments(id)
    };

Create table Report {
    id BIGINT AUTO_INCREMENT  NOT NULL,
    reason INT NOT NULL,
    reportTimestamp DATE NOT NULL,
    accepted BIT NOT NULL,
    deleted BIT NOT NULL,
    commentId int,
    postId int,
    PRIMARY KEY(idReport),
    FOREIGN KEY (postId) references Posts(id),
    FOREIGN KEY (commentId) references Comments(id)
    };

Create table Rule {
    id BIGINT AUTO_INCREMENT NOT NULL,
    description VARCHAR(255) NOT NULL,
    deleted BIT NOT NULL,
    idCommunity int,
    PRIMARY KEY(idRule),
    FOREIGN KEY(idCommunity) references Communities(id)
    };

create TABLE Users {
    id BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) not null,
    avatar VARCHAR(255) NOT NULL,
    registrationDate DATE NOT NULL,
    description VARCHAR(255) NOT NULL,
    displayName VARCHAR(255) NOT NULL,
    deleted BIT NOT NULL,
    idCommunity int,
    PRIMARY KEY(idUser),
    FOREIGN KEY(idCommunity) references Communities(id)
    };
