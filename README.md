# spring-boot-mysql

建表语句
```sql
create table user(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    name varchar(500) not null comment "商品名称",
    email varchar(30) not null comment "商品品牌",
    PRIMARY KEY (`id`)
)
```
