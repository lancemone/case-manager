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
    create_time datetime(0) default now() comment '创建时间',
    update_time datetime(0) default now() comment '更新时间',

    primary key (id),
    foreign key (user_id) references cmu_user(id) on update cascade on delete cascade,  # 同步更新和删除
    foreign key (role_id) references cmu_role(id) on update cascade on delete cascade
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

create table if not exists ip_address
(
    id bigint auto_increment
        primary key,
    ip_start varchar(15) not null,
    ip_end varchar(15) not null,
    area varchar(45) null comment '区域',
    operator varchar(6) null comment '运营商',
    ip_start_num bigint(10) not null,
    ip_end_num bigint(10) not null
)
    engine InnoDB default charset utf8 comment 'IP地址';

create index ip_address_ip_end_num_index
    on ip_address (ip_end_num);

create index ip_address_ip_start_num_index
    on ip_address (ip_start_num);

drop table if exists `cms_login_log`;
create table cms_login_log
(
    id int auto_increment comment '主键ID',
    request_id varchar(32) null comment '请求ID',
    username varchar(50) not null default '' comment '用户名',
    ip varchar(15) null comment 'IP',
    area varchar(50) not null default '' comment '区域',
    operator varchar(50) not null default '' comment '运营商',
    token varchar(255) not null default '' comment 'token值',
    type tinyint(2) not null default 00 comment '1:登入;2:登出;0:空值',
    success tinyint(1) not null default 1 comment '状态:1:成功;0:失败',
    code int not null default 1 comment '响应码',
    exception_message varchar(150) not null default '' comment '失败消息记录',
    browser_name varchar(50) not null default '' comment '浏览器名称',
    browser_version varchar(20) not null default '' comment '浏览器版本',
    phone tinyint(1) not null default 0 comment '是否手机登录: 0:否;1:是',
    os_name varchar(10) not null default '' comment '系统名称',
    device_model varchar(20) not null default '' comment '移动端设备型号',
    remark varchar(200) null comment '备注',
    create_time datetime(0) default now() comment '创建时间',
    update_time datetime(0) default now() comment '更新时间',

    primary key (id)
) engine InnoDB default charset utf8 comment '系统登录日志表' ;

drop table if exists `cms_login_log`;
create table cms_operation_log
(
    id bigint(18) auto_increment comment '主键'
        primary key,
    request_id varchar(32) null comment '请求ID',
    user_id bigint(18) null comment '用户ID',
    user_name varchar(32) null comment '用户名称',
    name varchar(200) null comment '日志名称',
    ip varchar(15) null comment 'IP',
    area varchar(45) null comment '区域',
    operator varchar(6) null comment '运营商',
    path varchar(500) null comment '全路径',
    module varchar(100) null comment '模块名称',
    class_name varchar(100) null comment '类名',
    method_name varchar(100) null comment '方法名称',
    request_method varchar(10) null comment '请求方式，GET/POST',
    content_type varchar(100) null comment '内容类型',
    request_body tinyint(1) null comment '是否是JSON请求映射参数',
    param text null comment '请求参数',
    token varchar(32) null comment 'tokenMd5值',
    type int null comment '0:其它,1:新增,2:修改,3:删除,4:详情查询,5:所有列表,6:分页列表,7:其它查询,8:上传文件',
    success tinyint(1) null comment '0:失败,1:成功',
    code int null comment '响应结果状态码',
    message varchar(100) null comment '响应结果消息',
    exception_name varchar(200) null comment '异常类名称',
    exception_message varchar(300) null comment '异常信息',
    browser_name varchar(100) null comment '浏览器名称',
    browser_version varchar(100) null comment '浏览器版本',
    engine_name varchar(100) null comment '浏览器引擎名称',
    engine_version varchar(100) null comment '浏览器引擎版本',
    os_name varchar(100) null comment '系统名称',
    platform_name varchar(100) null comment '平台名称',
    mobile tinyint(1) null comment '是否是手机,0:否,1:是',
    device_name varchar(100) null comment '移动端设备名称',
    device_model varchar(100) null comment '移动端设备型号',
    remark varchar(200) null comment '备注',
    create_time datetime(0) default now() comment '创建时间',
    update_time datetime(0) default now() comment '更新时间'
)
    engine InnoDB default charset utf8 comment '系统操作日志';
