CREATE TABLE `book` (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  reader varchar(50) DEFAULT NULL,
  isbn varchar(50) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  author varchar(50) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  FOREIGN KEY (reader) references reader(username)
)
