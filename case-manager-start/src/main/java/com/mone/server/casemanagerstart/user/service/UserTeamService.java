package com.mone.server.casemanagerstart.user.service;

import com.mone.server.casemanagerframework.common.service.BaseService;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerstart.user.param.UserTeamPageParam;
import com.mone.server.casemanagerstart.user.vo.UserTeamQueryVo;

import java.io.Serializable;

/**
 * 系统用户-组织表 服务类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
public interface UserTeamService extends BaseService<UserTeam> {

    /**
     * 保存
     *
     * @param userTeam
     * @return
     * @throws Exception
     */
    boolean saveUserTeam(UserTeam userTeam) throws Exception;

    /**
     * 修改
     *
     * @param userTeam
     * @return
     * @throws Exception
     */
    boolean updateUserTeam(UserTeam userTeam) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUserTeam(Long id) throws Exception;

    /**
    * 根据ID获取查询对象
    *
    * @param id
    * @return
    * @throws Exception
    */
    UserTeamQueryVo getUserTeamById(Serializable id) throws Exception;

    /**
    * 获取分页对象
    *
    * @param userTeamQueryParam
    * @return
    * @throws Exception
    */
    Paging<UserTeamQueryVo> getUserTeamPageList(UserTeamPageParam userTeamPageParam) throws Exception;

}
