package com.mone.server.casemanagerstart.user.service;

import com.mone.server.casemanagerframework.common.service.BaseService;
import com.mone.server.casemanagerstart.user.entity.Team;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 系统组织表 服务类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Component
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
    Team getTeamInfoById(Serializable id) throws Exception;

    List<Team> getTeamsByParentId(Serializable parentId) throws Exception;

    /**
    * 获取分页对象
    *
    * @param teamQueryParam
    * @return
    * @throws Exception
    */
//    Paging<TeamQueryVo> getTeamPageList(TeamPageParam teamPageParam) throws Exception;

}
