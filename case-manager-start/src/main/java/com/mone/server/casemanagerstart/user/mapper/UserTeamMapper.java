package com.mone.server.casemanagerstart.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mone.server.casemanagerstart.user.entity.UserTeam;
import com.mone.server.casemanagerstart.user.param.UserTeamPageParam;
import com.mone.server.casemanagerstart.user.vo.UserTeamQueryVo;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 * 系统用户-组织表 Mapper 接口
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */
@Repository
public interface UserTeamMapper extends BaseMapper<UserTeam> {

        /**
         * 根据ID获取查询对象
         *
         * @param id
         * @return
         */
    UserTeamQueryVo getUserTeamById(Serializable id);

        /**
         * 获取分页对象
         *
         * @param page
         * @param userTeamQueryParam
         * @return
         */
    IPage<UserTeamQueryVo> getUserTeamPageList(@Param("page") Page page, @Param("param") UserTeamPageParam userTeamPageParam);

    }
