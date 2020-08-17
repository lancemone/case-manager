package com.mone.server.casemanagerstart.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mone.server.casemanagerframework.common.exception.ParamErrorException;
import com.mone.server.casemanagerframework.common.service.BaseServiceImpl;
import com.mone.server.casemanagerframework.corn.pagination.PageInfo;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerstart.user.entity.User;
import com.mone.server.casemanagerstart.user.mapper.UserMapper;
import com.mone.server.casemanagerstart.user.param.UserPageParam;
import com.mone.server.casemanagerstart.user.service.UserService;
import com.mone.server.casemanagerstart.user.vo.input.UserParamVo;
import com.mone.server.casemanagerstart.user.vo.output.UserQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * 系统用户表 服务实现类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveUser(UserParamVo userParamVo) throws Exception {
        User user = new User();
        if (userParamVo != null) {
            if (userParamVo.getUsername() == null) {
                throw new ParamErrorException("用户名不能为空");
            }
            if (userParamVo.getEnable() == null) {
                throw new ParamErrorException("密码不能为空");
            }
            if (userParamVo.getRoleId() == null) {
                throw new ParamErrorException("用户角色不能为空");
            }
            if (userParamVo.getTeamId() == null) {
                throw new ParamErrorException("部门不能为空");
            }
            String passwd = "111111";
            user.setUsername(userParamVo.getUsername());

        }
        return super.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUser(User user) throws Exception {
        return super.updateById(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteUser(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public UserQueryVo getUserById(Serializable id) throws Exception {
        return baseMapper.getUserInfoById(id);
    }

    @Override
    public Paging<UserQueryVo> getUserPageList(UserPageParam userPageParam) throws Exception {
        Page<UserQueryVo> page = new PageInfo<>(userPageParam, OrderItem.desc(getLambdaColumn(User::getCreateTime)));
        IPage<UserQueryVo> iPage = userMapper.getUserPageList(page, userPageParam);
        return new Paging<UserQueryVo>(iPage);
    }

}
