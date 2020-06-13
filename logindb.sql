create database logindb;
use logindb;

CREATE TABLE u_account
 (
 aid INT(11) PRIMARY KEY not NULL auto_increment,
 username VARCHAR(30),
 passwd VARCHAR(30),
 type VARCHAR(10)
);
INSERT INTO u_account VALUES(NULL,"陈先绪","123456","QQ");
INSERT INTO u_account VALUES(NULL,"王倩","123456","QQ");
INSERT INTO u_account VALUES(NULL,"齐凯文","123456","QQ");
INSERT INTO u_account VALUES(NULL,"张三","123456","QQ");

CREATE TABLE u_info (
    `uid` int(10) NOT NULL AUTO_INCREMENT,
    `info` JSON,
    PRIMARY KEY (`uid`),CONSTRAINT fk_u_account_u_info FOREIGN KEY(uid) REFERENCES u_account(aid)
);


INSERT into u_info VALUES(1,'{"name": "陈先绪","sex":"男","age":22}');
INSERT into u_info VALUES(2,'{"name": "王倩","sex":"女","age":23}');
INSERT into u_info VALUES(3,'{"name": "齐凯文","sex":"男","age":25}');
INSERT into u_info VALUES(4,'{"name": "张三","sex":"男","age":25}');
