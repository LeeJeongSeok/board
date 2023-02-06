DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id bigint NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) DEFAULT NULL,
    password VARCHAR(255) DEFAULT NULL,
    name VARCHAR(255) DEFAULT NULL,
    phone VARCHAR(255) DEFAULT NULL,
    role VARCHAR(255) DEFAULT NULL,
    updated_at DATETIME(6) DEFAULT NULL,
    created_at DATETIME(6) DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS board;
CREATE TABLE board (
   id bigint NOT NULL AUTO_INCREMENT,
   title VARCHAR(100) DEFAULT NULL,
   content LONGTEXT DEFAULT NULL,
   username VARCHAR(255) DEFAULT NULL,
   created_at DATETIME(6) DEFAULT NULL,
   updated_at DATETIME(6) DEFAULT NULL,
   deleted_at DATETIME(6) DEFAULT NULL,
   use_yn VARCHAR(1) DEFAULT 'Y',
   PRIMARY KEY (id)
);
