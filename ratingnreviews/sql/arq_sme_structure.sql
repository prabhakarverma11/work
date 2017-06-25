-- Database : arq_sme
drop database IF EXISTS `arq_sme`;
create database arq_sme;
use arq_sme;
set foreign_key_checks=0;
DROP TABLE IF EXISTS `campaign`;
CREATE TABLE `campaign` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`api_id` bigint(20),
`name` varchar(200),
`status` varchar(50),
`bidding_strategy_id` int(11),
`advertising_channel_type` varchar(50),
`locationInclude` varchar(4000),
`locationInclude_Criteria` int(11),
`locationExclude` varchar(4000),
`locationExclude_Criteria` int(11),
`budget_amount` double, 
`budget_id` bigint(15) ,
`isBudgetChanged` int(1) DEFAULT 0,
`isLocationChanged` int(1) DEFAULT 0,
`start_date` date DEFAULT NULL,
`end_date` date DEFAULT NULL,
`user_id` int(11) unsigned NOT NULL,
`created_by` varchar(50) NOT NULL DEFAULT 'Admin',
`created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_by` varchar(50),
`updated_on` timestamp NULL DEFAULT NULL,
PRIMARY KEY(`id`),
CONSTRAINT `campaign_fkey_uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `adgroup` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`api_id` bigint(20),
`name` varchar(200),
`campaign_id` int(11) unsigned NOT NULL,
`status` varchar(50),
`category_name` varchar(500),
`product_name` varchar(500),
`threshold_keyword_avgCPC` double,
`created_by` varchar(50) NOT NULL DEFAULT 'Admin',
`created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_by` varchar(50),
`updated_on` timestamp NULL DEFAULT NULL,
PRIMARY KEY(`id`),
CONSTRAINT `adgroup_fkey_cmpid` FOREIGN KEY (`campaign_id`) REFERENCES `campaign` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`api_id` bigint(20),
`adgroup_id` int(11) unsigned NOT NULL, 
`adgroup_api_id` bigint(20),
`status` varchar(50),
`business_name` varchar(500),
`phone_number` varchar(100),
`description_line1` varchar(4000),
`description_line2` varchar(4000),
`display_url` varchar(500),
`verification_url` varchar(500),
`created_by` varchar(50) NOT NULL DEFAULT 'Admin',
`created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_by` varchar(50),
`updated_on` timestamp NULL DEFAULT NULL,
PRIMARY KEY(`id`),
CONSTRAINT `ad_fkey_adgroupid` FOREIGN KEY (`adgroup_id`) REFERENCES `adgroup` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200),
  `email` varchar(100), 
  `phoneno` varchar(100), 
  `password` varchar(100),
  `is_verified` tinyint(1),
  `unique_id` varchar(255),
  `created_by` varchar(50) NOT NULL DEFAULT 'Admin',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50),
  `updated_on` timestamp NULL DEFAULT NULL,
  PRIMARY KEY(`id`)
);


DROP TABLE IF EXISTS `CAMPAIGN_PERFORMANCE_REPORT`;
CREATE TABLE CAMPAIGN_PERFORMANCE_REPORT(
	`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	`campaign_id` varchar(100) NOT NULL,
	`campaign_name` varchar(100),
	`budget_id` bigint(15),
	`budget_amount` double,
	`status` varchar(50),
`Clicks` bigint(15),
`impressions` bigint(15),
`cost` bigint(15),
`date` date,
`startDate` date,
`endDate` date,
PRIMARY KEY(`id`)
);


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `user_role_map`;
CREATE TABLE `user_role_map` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `user_role_id` int(11) unsigned NOT NULL,
  PRIMARY KEY(`id`),
  CONSTRAINT `user_id_fkey_uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_id_fkey_urole` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `keyword`;
CREATE TABLE `keyword` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `api_id` bigint(20),
  `text` varchar(200),
  `status` varchar(50),
  `categoryName` varchar(1000),
  `bid` double,
  `avg_monthly_search` bigint(20),
  `competition` double,
  `avg_CPC` double,
  `match_type` varchar(20),
  `adgroup_id` int(11) unsigned NOT NULL, 
  `adgroup_api_id` bigint(20),
  `created_by` varchar(50) NOT NULL DEFAULT 'Admin',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50),
  `updated_on` timestamp NULL DEFAULT NULL,
  PRIMARY KEY(`id`),
  CONSTRAINT `keyword_fkey_adgroupid` FOREIGN KEY (`adgroup_id`) REFERENCES `adgroup` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- DROP TABLE IF EXISTS `productcategory`;
-- CREATE TABLE `productcategory` (
--   `id` int(11) unsigned NOT NULL,
--   `category` varchar(1000),
--   PRIMARY KEY(`id`)
-- );


insert into user(name,email,phoneno,password,created_on,is_verified) values('Manu Mishra','manu.mishra@hindustantimes.com',9910000000,'manu',now(),1);
insert into user(name,email,phoneno,password,created_on,is_verified) values('Admin','admin@arq.co.in',9910000000,'Admin',now(),1);
insert into user_role(role) values('ROLE_ADMIN');
insert into user_role(role) values('ROLE_USER');
insert into user_role(role) values('ROLE_REPORT');
insert into user_role_map(user_id,user_role_id) values(1,1);
insert into user_role_map(user_id,user_role_id) values(2,1);


