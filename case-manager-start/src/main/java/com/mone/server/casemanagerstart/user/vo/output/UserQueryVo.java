package com.mone.server.casemanagerstart.user.vo.output;

import com.google.common.collect.Sets;
import com.mone.server.casemanagerstart.user.entity.Team;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * <pre>
 * 系统用户表 查询结果对象
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserQueryVo对象")
public class UserQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String email;

    private String phone;

    private Boolean firstLogin;

    private Boolean enable;

    private Set<RoleQueryVO> roles = Sets.newHashSet();

    private Set<Team> teams = Sets.newHashSet();

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;
}
