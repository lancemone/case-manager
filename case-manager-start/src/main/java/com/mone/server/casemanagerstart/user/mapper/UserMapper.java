package com.mone.server.casemanagerstart.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mone.server.casemanagerstart.user.entity.User;
import com.mone.server.casemanagerstart.user.param.UserPageParam;
import com.mone.server.casemanagerstart.user.vo.UserQueryVo;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 * 系统用户表 Mapper 接口
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

        /**
         * 根据ID获取查询对象
         *
         * @param id
         * @return
         */
    UserQueryVo getUserById(Serializable id);

        /**
         * 获取分页对象
         *
         * @param page
         * @param userQueryParam
         * @return
         */
    IPage<UserQueryVo> getUserPageList(@Param("page") Page page, @Param("param") UserPageParam userPageParam);

    }
