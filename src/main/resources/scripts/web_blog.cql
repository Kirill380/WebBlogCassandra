DROP KEYSPACE IF EXISTS web_blog;
CREATE KEYSPACE web_blog WITH replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };


CREATE TYPE web_blog.comment (
  name varchar,
  comment_body text,
  email varchar
);

CREATE TYPE web_blog.vote (
  positive boolean,
  author varchar
);


CREATE TABLE web_blog.post (
  id bigint PRIMARY KEY,
  title varchar,
  postBody varchar,
  author varchar,
  tags list<text>,
  comments list<frozen<comment>>,
  votes list<frozen<vote>>
);


CREATE TABLE web_blog.author (
  email varchar PRIMARY KEY,
  user_name varchar,
  password varchar,
);
