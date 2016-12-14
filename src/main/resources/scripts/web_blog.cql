DROP KEYSPACE IF EXISTS web_blog2;
CREATE KEYSPACE web_blog2 WITH replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };


CREATE TYPE web_blog2.comment (
  comment_body text,
  publish_date timestamp,
  email varchar
);

CREATE TYPE web_blog2.vote (
  positive boolean,
  author_email varchar
);


CREATE TABLE web_blog2.post (
  id uuid PRIMARY KEY,
  title varchar,
  post_body varchar,
  author varchar,
  tags list<text>,
  comments list<frozen<comment>>,
  publish_date timestamp,
  votes list<frozen<vote>>
);


CREATE TABLE web_blog2.author (
  email varchar PRIMARY KEY,
  user_name varchar,
  password varchar,
);
