package com.mone.server.casemanagerstart.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mone.server.casemanagerstart.user.entity.Role;
import com.mone.server.casemanagerstart.user.entity.User;
import com.mone.server.casemanagerstart.user.entity.UserRole;
import com.mone.server.casemanagerstart.user.param.UserRolePageParam;
import com.mone.server.casemanagerstart.user.vo.output.UserRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * 系统用户-角色表 Mapper 接口
 *
 * @author : MoTao
 * @Description :
 * @Classname : ${className}
 * @create 2020-07-11
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据userId获取查询
     *
     * @param userId
     * @return
     */
    List<Role> getUserRoleByUserId(Serializable userId);

    /**
     * 根据roleId获取用户信息列表
     *
     * @param roleId
     * @return
     */
    List<User> getUserRoleByRoleId(Serializable roleId);

    /**
     * 获取分页对象
     *
     * @param page
     * @param
     * @return
     */
    IPage<UserRoleQueryVo> getUserRolePageList(@Param("page") Page page, @Param("param") UserRolePageParam userRolePageParam);

    UserRoleQueryVo getUserRoleById(Serializable id);
}
