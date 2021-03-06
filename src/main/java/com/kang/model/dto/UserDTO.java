package com.kang.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chaokang
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserDTO", description="User对象")
public class UserDTO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "登录名")
    private String loginName;

//    @ApiModelProperty(value = "密码")
//    private String pwd;

    @ApiModelProperty(value = "真实姓名")
    private String userName;

    @ApiModelProperty(value = "联系方式")
    private String tel;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "性别（0：男  1：女）")
    private Boolean gender;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "地址")
    private String addr;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "删除标识（0：正常  1：删除）")
    private Boolean isDel;

    @ApiModelProperty(value = "角色id")
    private Long roleId;


}
