CREATE database spring_hiberhate_maven;
use spring_hiberhate_maven;
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(30) NOT NULL,
  lastname VARCHAR(30) NOT NULL,
  email VARCHAR(50),
  userName VARCHAR(50),
  password VARCHAR(50)
);

DROP TABLE IF EXISTS groups;
CREATE TABLE groups (
  id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS items;
CREATE TABLE items (
  id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  group_id int(10) unsigned DEFAULT NULL,
  measure_id int(10) unsigned DEFAULT NULL,
  CONSTRAINT items2groups FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE,
  CONSTRAINT items2measures FOREIGN KEY (measure_id) REFERENCES measures (id) ON DELETE CASCADE
);


CREATE TABLE measures(
  id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);