
/*Data for the table `cmu_user` */
# 密码:111111
insert into cmu_user (username, email, phone) values
('test', 'test.360.cn', 15736437489),('test1', 'test1.360.cn', 17829874567), ('test2', 'test2.360.cn', 17829874567);

# /*Data for the table `cmu_role` */
insert into cmu_role(id, code, name, remarks) VALUES (1, 'admin', '管理员', '管理员,可添加tester，同时具有tester权限'),
                                                  (2,'tester', '测试人员', '测试人员，可创建和修改用例'),
                                                (3, 'visitor', '访客', '仅可查看');
# /*Data for the table `cmu_user_role` */
insert into cmu_user_role(user_id, role_id) VALUES (1, 1), (2,2), (3,3);

# /*Data for the table `cmu_team` */
insert into cmu_team(name, parent_id, remarks, address) VALUES ('奇虎360', 0, '360科技有限公司', '酒仙桥'),('城市安全部', 1, '城市安全事业部',''),('加固保', 2, '加固保', '');

# /*Data for the table `cmu_user_team` */
insert into cmu_user_team(uid, tid, leader) VALUES (1, 1, 1), (2, 2, 2), (3, 3, 1);
# /*Data for the table `cmu_user_team_role` */
# insert into cmu_user_team_role(uid, tid, rid, leader) VALUES (1, 1, 1, 1), (2, 1, 2, 0);
