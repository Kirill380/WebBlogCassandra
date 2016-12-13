INSERT INTO author(email,  user_name, password) VALUES('kreol_123@ukr.net', 'Kirill Liubun', '$2a$04$9CJJLujA5xhH13YjAcsjduU8a8t2VSeRwtl.Gs0/OKjg4Ag0wvMtS'); // pwd: send08
INSERT INTO author(email,  user_name, password) VALUES('example@test.com', 'John Doe', '$2a$04$8j1hi7rayBY9bGc4vBR.F.DBGMSybYi8DC7frgFlEClxXQmU3xWDK'); // pwd: qwerty
INSERT INTO author(email,  user_name, password) VALUES('gendalf@wizard.com', 'Gandalf the White', '$2a$04$eYYhHJAF4TP07b4nvf8bDuOpvtst/3Clq0x7rQFuaKVQtU3qojBu.'); // pwd: youshallpass
INSERT INTO author(email,  user_name, password) VALUES('anakin@dark.side', 'Darth Vader', '$2a$04$k7yT1qlCa0YHHGPouFgEaudLxQ.6OrBMgJhvflzuuExrTIKITICJu'); // pwd : deathstar





INSERT INTO post(id, title, post_body, author, tags, comments, publish_date, votes) VALUES(
 2,
 'The dark side',
 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi eaque est eveniet explicabo harum incidunt ipsam nemo quam temporibus ullam. Culpa, deserunt, provident! Aspernatur blanditiis dolores nemo repudiandae tenetur unde.',
 'anakin@dark.side',
 ['dark-side', 'cookies'],
 [{
    comment_body  : 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.',
    email : 'example@test.com',
    publish_date : '2015-01-05 12:00:00'
  },{
     comment_body  : 'Accusantium aspernatur beatae dolor dolore excepturi explicabo laborum.',
     email : 'anakin@dark.side',
     publish_date : '2015-01-05 12:06:00'
  }],
  '2015-01-05 11:00:00',
  [{
      positive : true,
      author_email : 'example@test.com'
  },{
      positive : true,
      author_email : 'kreol_123@ukr.net'
  },{
       positive : false,
       author_email : 'gendalf@wizard.com'
   }]
);



