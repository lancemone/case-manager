package com.mone.server.casemanagerstart.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mone.server.casemanagerstart.user.entity.Role;
import com.mone.server.casemanagerstart.user.param.CommonPageParam;
import com.mone.server.casemanagerstart.user.param.TeamPageParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RoleMapper extends BaseMapper<Role> {

    Role getRoleById(@Param("id") Serializable id);

    IPage<Role> getRolePageList(@Param("page") Page page, @Param("param") CommonPageParam commonPageParam);
}
