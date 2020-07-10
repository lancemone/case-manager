package com.mone.server.casemanagerstart.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mone.server.casemanagerstart.user.entity.UserRole;
import com.mone.server.casemanagerstart.user.param.UserRolePageParam;
import com.mone.server.casemanagerstart.user.vo.UserRoleQueryVo;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 * 系统用户-角色表 Mapper 接口
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

        /**
         * 根据ID获取查询对象
         *
         * @param id
         * @return
         */
    UserRoleQueryVo getUserRoleById(Serializable id);

        /**
         * 获取分页对象
         *
         * @param page
         * @param userRoleQueryParam
         * @return
         */
    IPage<UserRoleQueryVo> getUserRolePageList(@Param("page") Page page, @Param("param") UserRolePageParam userRolePageParam);

    }
