package com.mone.server.casemanagerstart.user.service;

import com.mone.server.casemanagerstart.user.entity.User;
import com.mone.server.casemanagerstart.user.param.UserPageParam;
import com.mone.server.casemanagerframework.common.service.BaseService;
import com.mone.server.casemanagerstart.user.vo.UserQueryVo;
import com.mone.server.casemanagerframework.corn.pagination.Paging;

import java.io.Serializable;

/**
 * 系统用户表 服务类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */
public interface UserService extends BaseService<User> {

    /**
     * 保存
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean saveUser(User user) throws Exception;

    /**
     * 修改
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean updateUser(User user) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUser(Long id) throws Exception;

    /**
    * 根据ID获取查询对象
    *
    * @param id
    * @return
    * @throws Exception
    */
    UserQueryVo getUserById(Serializable id) throws Exception;

    /**
    * 获取分页对象
    *
    * @param userQueryParam
    * @return
    * @throws Exception
    */
    Paging<UserQueryVo> getUserPageList(UserPageParam userPageParam) throws Exception;

}
