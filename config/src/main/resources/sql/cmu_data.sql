
/*Data for the table `cmu_user` */
# 密码:111111
# insert into cmu_user (username, email, phone) values
# ('test', 'test.360.cn', 15736437489),('test1', 'test1.360.cn', 17829874567);

# /*Data for the table `cmu_role` */
# insert into cmu_role(id, code, name, remarks) VALUES (1, 'admin', '管理员', '管理员,可添加tester，同时具有tester权限'),
#                                                   (2,'tester', '测试人员', '测试人员，可创建和修改用例'),
#                                                 (3, 'visitor', '访客', '仅可查看');
#
# /*Data for the table `cmu_user_role` */
# insert into cmu_user_role(user_id, role_id, role_name) VALUES (1, 1, '管理员'), (2, 2, '测试人员');
#
# /*Data for the table `cmu_team` */
# insert into cmu_team (name, remarks, address) VALUES
#     ('加固保', '360', '360大厦');
#
#
# /*Data for the table `cmu_user_team` */
# insert into cmu_user_team (uid, tid, leader) VALUES (1, 1, 1), (2,1, 0);
