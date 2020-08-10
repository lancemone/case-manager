package com.mone.server.casemanagerstart.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mone.server.casemanagerframework.common.service.BaseServiceImpl;
import com.mone.server.casemanagerframework.corn.pagination.PageInfo;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerstart.user.entity.Team;
import com.mone.server.casemanagerstart.user.mapper.TeamMapper;
import com.mone.server.casemanagerstart.user.param.TeamPageParam;
import com.mone.server.casemanagerstart.user.service.TeamService;
import com.mone.server.casemanagerstart.user.vo.output.TeamQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

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

    @Autowired
    private TeamMapper teamMapper;

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
    public TeamQueryVo getTeamById(Serializable id) throws Exception {
        return teamMapper.getTeamById(id);
    }

    @Override
    public Paging<TeamQueryVo> getTeamPageList(TeamPageParam teamPageParam) throws Exception {
        Page<TeamQueryVo> page = new PageInfo<>(teamPageParam, OrderItem.desc(getLambdaColumn(Team::getCreateTime)));
        IPage<TeamQueryVo> iPage = teamMapper.getTeamPageList(page, teamPageParam);
        return new Paging<TeamQueryVo>(iPage);
    }

}
