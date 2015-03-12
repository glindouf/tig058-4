.m column
.h on
pragma foreign_keys = on;

drop table if exists team;
drop table if exists member;
drop table if exists team_members;
drop table if exists parent;
drop table if exists coach;
drop table if exists child;

create table team (name text primary key);

create table member (id text primary key,
       	     	    givenname text,
		    surname text,
		    email text,
		    gender integer,
		    birthdate integer,
		    joindate integer,
		    active integer);

create table team_members (team text primary key,
       	     		  memberid text,
			  FOREIGN KEY (memberid) REFERENCES member(id) on delete cascade);

create table parent (id text,
       	     	    childid text,
		    FOREIGN KEY (id) REFERENCES member(id) on delete cascade,
		    FOREIGN KEY (childid) REFERENCES member(id) on delete cascade);

create table coach (id text,
		   FOREIGN KEY (id) REFERENCES member(id) on delete cascade)
		   
create table child (id text, 
       	     	   parentid text,
		   FOREIGN KEY (id) REFERENCES member(id) on delete cascade,
		   FOREIGN KEY (parentid) REFERENCES member(id) on delete cascade);

insert into team values('P00');
insert into team values('H');


insert into member values ('660123-6123', 'Mikael', 'Karlsson', 'Mikael.Swag@swag.se',0,0,0,1);
insert into member values ('880912-2132', 'Olle', 'Karlsson', 'Olle.swag@swag.se',0,0,0,1);
insert into member values ('000101-9213', 'Kalle', 'Karlsson', 'kalle.cool@myclub.se',0,0,0,1);


insert into team_members values('H', '660123-6123');
insert into team_members values('P00', '000101-9213');
insert into team_members values('H', '880912-2132');

insert into coach values ('660123-6123');
insert into parent values ('660123-6123', '880912-2132');
insert into parent values ('880912-2132','000101-9213');
insert into child values ('000101-9213', '880912-2132');

