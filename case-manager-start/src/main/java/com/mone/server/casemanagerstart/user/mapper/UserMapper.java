package com.mone.server.casemanagerstart.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mone.server.casemanagerstart.user.entity.User;
import com.mone.server.casemanagerstart.user.param.UserPageParam;
import com.mone.server.casemanagerstart.user.vo.output.UserQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 系统用户表 Mapper 接口
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

        /**
         * 根据ID获取查询对象
         *
         * @param id
         * @return
         */
    User getUserInfoById(Serializable id);

        /**
         * 获取分页对象
         *
         * @param page
         * @param
         * @return
         */
    IPage<UserQueryVo> getUserPageList(@Param("page") Page page, @Param("param") UserPageParam userPageParam);

    }
