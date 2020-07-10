package com.mone.server.casemanagerstart.user.service.impl;

import com.mone.server.casemanagerstart.user.entity.UserTeam;
import com.mone.server.casemanagerstart.user.mapper.UserTeamMapper;
import com.mone.server.casemanagerstart.user.service.UserTeamService;
import com.mone.server.casemanagerstart.user.param.UserTeamPageParam;
import com.mone.server.casemanagerstart.user.vo.UserTeamQueryVo;
import com.mone.server.casemanagerframework.common.service.BaseServiceImpl;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerframework.corn.pagination.PageInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 系统用户-组织表 服务实现类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */
@Slf4j
@Service
public class UserTeamServiceImpl extends BaseServiceImpl<UserTeamMapper, UserTeam> implements UserTeamService {

    @Autowired
    private UserTeamMapper userTeamMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveUserTeam(UserTeam userTeam) throws Exception {
        return super.save(userTeam);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUserTeam(UserTeam userTeam) throws Exception {
        return super.updateById(userTeam);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteUserTeam(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public UserTeamQueryVo getUserTeamById(Serializable id) throws Exception {
        return userTeamMapper.getUserTeamById(id);
    }

    @Override
    public Paging<UserTeamQueryVo> getUserTeamPageList(UserTeamPageParam userTeamPageParam) throws Exception {
        Page<UserTeamQueryVo> page = new PageInfo<>(userTeamPageParam, OrderItem.desc(getLambdaColumn(UserTeam::getCreateTime)));
        IPage<UserTeamQueryVo> iPage = userTeamMapper.getUserTeamPageList(page, userTeamPageParam);
        return new Paging<UserTeamQueryVo>(iPage);
    }

}
