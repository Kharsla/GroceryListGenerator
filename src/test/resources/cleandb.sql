delete from users;
delete from recipes;
delete from ingredients;
delete from role;
INSERT INTO users VALUES (1, 'student', 'student'), (2, 'test', 'test'), (3, 'Kaitlyn', 'Harsla');
INSERT INTO recipes VALUES (1,1, 'grilled cheese', 'lunch'), (2,2, 'chicken noodle soup', 'lunch'), (3,2, 'tacos', 'dinner'), (4,2, 'lasagna', 'dinner');
INSERT INTO ingredients VALUES (1, 'cheese', 1, 'cup', 1), (2, 'chicken', 2, 'each', 2);
INSERT INTO role VALUES (1, 'admin', 'student', 1), (2, 'admin', 'test', 2);