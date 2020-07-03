# 数据库信息: cdb-4x9gogum.bj.tencentcdb.com:10247/case_manager
# username: root
# password: sJ8UPhQ_LA94tUm

# cmu_*:  系统用户相关表
drop table if exists `cmu_user_role`;
drop table if exists `cmu_user_team`;
drop table if  exists `cmu_user`;
create table cmu_user
(
    id          int(11) auto_increment not null comment '用户id',
    username    varchar(50)            not null comment '用户名',
    password    varchar(100)           not null default '5df47a07d12b35fe3743edaaa28f0d42aff6a6a5' comment '用户密码,默认值111111',
    email       varchar(25)            not null default '' comment '邮箱',
    phone       bigint(11)                null comment '手机号',
    salt        varchar(20)            not null default 'iaq2dgu1m3kfb5rm' comment '盐值',
    verify      varchar(16)            not null default '' comment 'verify为username+password字段值小写MD5摘要值，用于校验密码更改后的token',
    first_login tinyint(1)             not null default 1 comment '是否首次登录: 0:否;1:是',
    enable      tinyint(1)             not null default 1 comment '账号启用状态: 0:禁用;1:启用',
    create_time datetime(0)                     default now() comment '创建时间',
    update_time datetime(0)                     default now() comment '更新时间',

    primary key (id),
    unique key (username)
)
    engine InnoDB default charset utf8 comment '系统用户表';

drop table if exists `cmu_user_role`;
drop table if exists `cmu_role`;
create table cmu_role
(
    id int(5) auto_increment comment '主键ID',
    code varchar(10) not null comment '角色编码',
    name varchar(20) not null comment '角色名称',
    remarks varchar(100) comment '角色描述',
    create_time datetime(0) default now() comment '创建时间',
    update_time datetime(0) default now() comment '更新时间',

    primary key (id),
    unique key (code),
    unique key (name)
) engine InnoDB default charset utf8 comment '系统角色表' ;


drop table if exists `cmu_user_role`;
create table cmu_user_role
(
    id int(10) auto_increment comment '主键ID',
    user_id int(11) not null comment '用户ID',
    role_id int(5) not null comment '角色ID',
    role_name varchar(20) not null comment '角色名称',
    create_time datetime(0) default now() comment '创建时间',
    update_time datetime(0) default now() comment '更新时间',

    primary key (id),
    foreign key (user_id) references cmu_user(id) on update cascade on delete cascade,  # 同步更新和删除
    foreign key (role_name) references cmu_role(name) on update cascade on delete cascade
) engine InnoDB default charset utf8 comment '系统用户-角色表' ;

drop table if exists `cmu_user_team`;
drop table if exists `cmu_team`;

create table cmu_team
(
    id int(5) auto_increment comment '组织id',
    name varchar(100) not null comment '组织名称',
    remarks varchar(255) not null default '' comment '组织简介',
    address varchar(100) not null default '' comment '地址',
    create_time datetime(0) default now() comment '创建时间',
    update_time datetime(0) default now() comment '更新时间',

    primary key (id)
) engine InnoDB default charset utf8 comment '系统组织表' ;


drop table if exists `cmu_user_team`;
create table cmu_user_team
(
    id int(10) auto_increment comment '主键ID',
    uid int(11) not null comment '用户ID',
    tid int(5) not null comment '组织ID',
    leader tinyint(1) not null default 0 comment '是否为组织负责人: 1:是;0:否',
    create_time datetime(0) default now() comment '创建时间',
    update_time datetime(0) default now() comment '更新时间',

    primary key (id),
    foreign key (uid) references cmu_user(id),
    foreign key (tid) references cmu_team(id)
) engine InnoDB default charset utf8 comment '系统用户-组织表' ;

# cms_*:  系统信息相关表

drop table if exists `cms_login_log`;
create table cms_login_log
(
    id int auto_increment comment '主键ID',
    username varchar(50) not null default '' comment '用户名',
    ip int not null default 0 comment '登录ip',
    area varchar(50) not null default '' comment '区域',
    operator varchar(50) not null default '' comment '运营商',
    token varchar(255) not null default '' comment 'token值',
    type tinyint(2) not null default 00 comment '1:登入;2:登出;0:空值',
    success tinyint(1) not null default 1 comment '状态:1:成功;0:失败',
    code int not null default 200 comment '响应码',
    exception_message varchar(150) not null default '' comment '失败消息记录',
    browser_name varchar(50) not null default '' comment '浏览器名称',
    browser_version varchar(20) not null default '' comment '浏览器版本',
    phone tinyint(1) not null default 0 comment '是否手机登录: 0:否;1:是',
    os_name varchar(10) not null default '' comment '系统名称',
    device_model varchar(20) not null default '' comment '移动端设备型号',
    create_time datetime(0) default now() comment '创建时间',
    update_time datetime(0) default now() comment '更新时间',

    primary key (id)
) engine InnoDB default charset utf8 comment '系统登录日志表' ;
