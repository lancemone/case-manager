package com.mone.server.casemanagerstart.user.service;

import com.mone.server.casemanagerstart.user.entity.Team;
import com.mone.server.casemanagerstart.user.param.TeamPageParam;
import com.mone.server.casemanagerframework.common.service.BaseService;
import com.mone.server.casemanagerstart.user.vo.TeamQueryVo;
import com.mone.server.casemanagerframework.corn.pagination.Paging;

/**
 * 系统组织表 服务类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */
public interface TeamService extends BaseService<Team> {

    /**
     * 保存
     *
     * @param team
     * @return
     * @throws Exception
     */
    boolean saveTeam(Team team) throws Exception;

    /**
     * 修改
     *
     * @param team
     * @return
     * @throws Exception
     */
    boolean updateTeam(Team team) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteTeam(Long id) throws Exception;

    /**
    * 根据ID获取查询对象
    *
    * @param id
    * @return
    * @throws Exception
    */
    TeamQueryVo getTeamById(Serializable id) throws Exception;

    /**
    * 获取分页对象
    *
    * @param teamQueryParam
    * @return
    * @throws Exception
    */
    Paging<TeamQueryVo> getTeamPageList(TeamPageParam teamPageParam) throws Exception;

}
