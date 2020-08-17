package com.mone.server.casemanagerstart.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mone.server.casemanagerstart.user.entity.Team;
import com.mone.server.casemanagerstart.user.param.TeamPageParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * 系统组织表 Mapper 接口
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Repository
public interface TeamMapper extends BaseMapper<Team> {

        /**
         * 根据ID获取查询对象
         *
         * @param id
         * @return
         */
    Team getTeamInfoById(Serializable id);

    List<Team> getTeamsByParentId(Serializable parentId);

        /**
         * 获取分页对象
         *
         * @param page
         * @param
         * @return
         */
//    IPage<TeamQueryVo> getTeamPageList(@Param("page") Page page, @Param("param") TeamPageParam teamPageParam);

    }
