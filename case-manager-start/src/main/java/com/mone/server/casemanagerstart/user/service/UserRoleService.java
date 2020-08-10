package com.mone.server.casemanagerstart.user.service;

import com.mone.server.casemanagerframework.common.service.BaseService;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerstart.user.entity.UserRole;
import com.mone.server.casemanagerstart.user.param.UserRolePageParam;
import com.mone.server.casemanagerstart.user.vo.output.UserRoleQueryVo;

import java.io.Serializable;

/**
 * 系统用户-角色表 服务类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
public interface UserRoleService extends BaseService<UserRole> {

    /**
     * 保存
     *
     * @param userRole
     * @return
     * @throws Exception
     */
    boolean saveUserRole(UserRole userRole) throws Exception;

    /**
     * 修改
     *
     * @param userRole
     * @return
     * @throws Exception
     */
    boolean updateUserRole(UserRole userRole) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUserRole(Long id) throws Exception;

    /**
    * 根据ID获取查询对象
    *
    * @param id
    * @return
    * @throws Exception
    */
    UserRoleQueryVo getUserRoleById(Serializable id) throws Exception;

    /**
    * 获取分页对象
    *
    * @param userRoleQueryParam
    * @return
    * @throws Exception
    */
    Paging<UserRoleQueryVo> getUserRolePageList(UserRolePageParam userRolePageParam) throws Exception;

}
