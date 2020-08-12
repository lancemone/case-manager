package com.mone.server.casemanagerstart.user.service.impl;

import com.mone.server.casemanagerframework.common.service.BaseServiceImpl;
import com.mone.server.casemanagerstart.user.entity.Team;
import com.mone.server.casemanagerstart.user.mapper.TeamMapper;
import com.mone.server.casemanagerstart.user.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 系统组织表 服务实现类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Slf4j
@Service
public class TeamServiceImpl extends BaseServiceImpl<TeamMapper, Team> implements TeamService {

    private final TeamMapper teamMapper;

    public TeamServiceImpl(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveTeam(Team team) throws Exception {
        return super.save(team);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateTeam(Team team) throws Exception {
        return super.updateById(team);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteTeam(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Team getTeamInfoById(Serializable id) throws Exception {
        return baseMapper.getTeamInfoById(id);
    }

    // 根据父级id获取此节点的部门数据
    @Override
    public List<Team> getTeamsByParentId(Serializable parentId) throws Exception {
        List<Team> teams = baseMapper.getTeamsByParentId(parentId);
        return teams;
    }

//    @Override
//    public Paging<TeamQueryVo> getTeamPageList(TeamPageParam teamPageParam) throws Exception {
//        Page<TeamQueryVo> page = new PageInfo<>(teamPageParam, OrderItem.desc(getLambdaColumn(Team::getCreateTime)));
//        IPage<TeamQueryVo> iPage = teamMapper.getTeamPageList(page, teamPageParam);
//        return new Paging<TeamQueryVo>(iPage);
//    }

}
