-- CBT-PBO
\! cls
DROP DATABASE cbt_pbo;
CREATE DATABASE cbt_pbo;
USE cbt_pbo;

CREATE TABLE exam(
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title varchar(60) NOT NULL,
  isOpen BOOLEAN NOT NULL default false
);

CREATE TABLE questions(
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  exam_id int NOT NULL,
  FOREIGN KEY (exam_id) REFERENCES exam(id),
  question text NOT NULL,
  poin int NOT NULL
);

CREATE TABLE answers(
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  questions_id int NOT NULL,
  FOREIGN KEY (questions_id) REFERENCES questions(id),
  choice varchar(1) NOT NULL,
  answer text NOT NULL
);

CREATE TABLE user (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username varchar(60) NOT NULL,
  password varchar(12) NOT NULL,
  examAccess int,
  FOREIGN KEY(examAccess) REFERENCES exam(id),
  isAdmin BOOLEAN NOT NULL DEFAULT false
);

INSERT INTO user(username, password, isAdmin) VALUES ('admin', 'cbt-admin@1321', true);