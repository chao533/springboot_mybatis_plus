package com.kang.model.param;

import com.kang.model.base.PageModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(value="用户列表入参", description="")
public class UserQueryParam extends PageModel{

	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "用户名")
	private String loginName;
	
	@ApiModelProperty(value = "密码")
	private String pwd;
	
	@ApiModelProperty(value = "模糊搜索")
	private String search;
}
