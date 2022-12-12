CREATE TABLE `store` (
	`store_no`	bigint	NOT NULL,
	`seller_no`	bigint	NOT NULL,
	`introduction`	varchar(1000)	NOT NULL	COMMENT '500자 제한',
	`name`	varchar(30)	NOT NULL,
	`open_hour`	time	NOT NULL,
	`close_hour`	time	NOT NULL,
	`phone`	char(11)	NOT NULL,
	`email`	varchar(30)	NOT NULL,
	`location`	varchar(100)	NOT NULL	COMMENT '공간 데이터..?',
	`status`	varchar(20)	NOT NULL,
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL
);

CREATE TABLE `category` (
	`category_no`	bigint	NOT NULL,
	`parent_no`	bigint	NOT NULL,
	`name`	varchar(30)	NOT NULL	COMMENT '12자 제한',
	`depth`	int	NOT NULL,
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL,
	`is_deleted`	char(1)	NOT NULL
);

CREATE TABLE `product` (
	`product_num`	bigint	NOT NULL,
	`category_no`	bigint	NOT NULL,
	`store_no`	bigint	NOT NULL,
	`title`	varchar(100)	NOT NULL	COMMENT '50자 제한',
	`price`	int	NOT NULL	COMMENT 'unsigned..?',
	`delivery_fee`	int	NOT NULL,
	`brand`	varchar(100)	NOT NULL,
	`name`	varchar(100)	NOT NULL,
	`description`	longtext	NOT NULL	COMMENT 'longtext or longblob?',
	`status`	varchar(20)	NOT NULL,
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL,
	`is_deleted`	char(1)	NOT NULL
);

CREATE TABLE `tag` (
	`tag_no`	bigint	NOT NULL,
	`name`	varchar(30)	NOT NULL	COMMENT '12자 제한',
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL,
	`is_deleted`	char(1)	NOT NULL
);

CREATE TABLE `product_tag` (
	`product_tag_no`	bigint	NOT NULL,
	`product_num`	bigint	NOT NULL,
	`tag_no`	bigint	NOT NULL,
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL,
	`is_deleted`	char(1)	NOT NULL
);

CREATE TABLE `seller` (
	`seller_no`	bigint	NOT NULL,
	`email`	varchar(30)	NOT NULL	COMMENT '아이디 역할',
	`password`	varchar(20)	NOT NULL,
	`nickname`	varchar(20)	NOT NULL,
	`name`	varchar(20)	NOT NULL,
	`phone`	char(11)	NOT NULL,
	`location`	VARCHAR(255)	NOT NULL	COMMENT '주소는 어떻게..?',
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL,
	`is_deleted`	char(1)	NOT NULL
);

CREATE TABLE `admin` (
	`admin_no`	bigint	NOT NULL,
	`email`	varchar(30)	NOT NULL	COMMENT '아이디 역할',
	`password`	varchar(20)	NOT NULL,
	`name`	varchar(20)	NOT NULL,
	`phone`	char(11)	NULL,
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL,
	`is_deleted`	char(1)	NOT NULL
);

CREATE TABLE `requested_store` (
	`store_no`	bigint	NOT NULL,
	`seller_no`	bigint	NOT NULL,
	`introduction`	varchar(1000)	NOT NULL	COMMENT '500자 제한',
	`name`	varchar(30)	NOT NULL,
	`open_hour`	time	NOT NULL,
	`close_hour`	time	NOT NULL,
	`phone`	char(11)	NOT NULL,
	`email`	varchar(30)	NOT NULL,
	`location`	varchar(50)	NOT NULL	COMMENT '공간 데이터..?',
	`reject_type`	varchar(50)	NOT NULL,
	`reject_reason`	varchar(1000)	NULL	COMMENT ''기타' 유형에 대해 사유 적어주기. 500자',
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL
);

ALTER TABLE `store` ADD CONSTRAINT `PK_STORE` PRIMARY KEY (
	`store_no`
);

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`category_no`
);

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`product_num`
);

ALTER TABLE `tag` ADD CONSTRAINT `PK_TAG` PRIMARY KEY (
	`tag_no`
);

ALTER TABLE `product_tag` ADD CONSTRAINT `PK_PRODUCT_TAG` PRIMARY KEY (
	`product_tag_no`
);

ALTER TABLE `seller` ADD CONSTRAINT `PK_SELLER` PRIMARY KEY (
	`seller_no`
);

ALTER TABLE `admin` ADD CONSTRAINT `PK_ADMIN` PRIMARY KEY (
	`admin_no`
);

ALTER TABLE `requested_store` ADD CONSTRAINT `PK_REQUESTED_STORE` PRIMARY KEY (
	`store_no`
);

