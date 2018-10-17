create table player(first_name varchar(50) not null,last_name varchar(50) not null,username varchar(50) not null,primary key(username));
create table team(team_name varchar(50),player1 varchar(50),player2 varchar(50),team_score int DEFAULT 0,primary key(team_name),FOREIGN KEY (player1) REFERENCES player(username),FOREIGN KEY (player2) REFERENCES player(username));
create table matchs(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),teamA varchar(50),teamB varchar(50),winningTeam varchar(50),CONSTRAINT primary_key PRIMARY KEY (id),FOREIGN KEY (teamA) REFERENCES team(team_name),FOREIGN KEY (teamB) REFERENCES team(team_name));;