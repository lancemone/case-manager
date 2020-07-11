package com.mone.server.casemanagerstart.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mone.server.casemanagerframework.common.service.BaseServiceImpl;
import com.mone.server.casemanagerframework.corn.pagination.PageInfo;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerstart.user.mapper.UserRoleMapper;
import com.mone.server.casemanagerstart.user.param.UserRolePageParam;
import com.mone.server.casemanagerstart.user.service.UserRoleService;
import com.mone.server.casemanagerstart.user.vo.UserRoleQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * 系统用户-角色表 服务实现类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Slf4j
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveUserRole(UserRole userRole) throws Exception {
        return super.save(userRole);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUserRole(UserRole userRole) throws Exception {
        return super.updateById(userRole);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteUserRole(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public UserRoleQueryVo getUserRoleById(Serializable id) throws Exception {
        return userRoleMapper.getUserRoleById(id);
    }

    @Override
    public Paging<UserRoleQueryVo> getUserRolePageList(UserRolePageParam userRolePageParam) throws Exception {
        Page<UserRoleQueryVo> page = new PageInfo<>(userRolePageParam, OrderItem.desc(getLambdaColumn(UserRole::getCreateTime)));
        IPage<UserRoleQueryVo> iPage = userRoleMapper.getUserRolePageList(page, userRolePageParam);
        return new Paging<UserRoleQueryVo>(iPage);
    }

}
