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

DROP TABLE IF EXISTS measures;
CREATE TABLE measures(
  id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);


DROP TABLE IF EXISTS items2measures;
CREATE TABLE items2measures(
  item_id int(10) unsigned DEFAULT NULL,
  measure_id int(10) unsigned DEFAULT NULL,
  CONSTRAINT items2measures2items FOREIGN KEY (item_id) REFERENCES items (id) ON DELETE CASCADE,
  CONSTRAINT items2measures2measures FOREIGN KEY (measure_id) REFERENCES measures (id) ON DELETE CASCADE
);

