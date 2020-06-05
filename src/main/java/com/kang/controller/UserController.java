package com.kang.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kang.common.msg.Message;
import com.kang.model.dto.UserDTO;
import com.kang.model.param.UserParam;
import com.kang.model.param.UserQueryParam;
import com.kang.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chaokang
 * @since 2020-06-04
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "用户添加")
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public Message<String> saveUser(UserParam userParam){
		return userService.saveUser(userParam);
	}
	
	@ApiOperation(value = "用户修改")
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public Message<String> updateUser(@RequestBody UserParam userParam){
		return userService.updateUser(userParam);
	}
	
	@ApiOperation(value = "用户删除")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "ids", value = "ids字符串", dataType = "String")
    })
	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	public Message<String> deleteUser(String ids){
		return userService.deleteUser(ids);
	}
	
	@ApiOperation(value = "用户id查询")
	@ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "id", dataType = "Long")
    })
	@RequestMapping(value = "/getOne",method = RequestMethod.GET)
	public Message<UserDTO> getOne(Long id){
		return userService.getUserOne(id);
	}
	
	@ApiOperation(value = "用户列表")
//	@ApiImplicitParams({
//    	@ApiImplicitParam(name = "id", value = "id", dataType = "Long"),
//    	@ApiImplicitParam(name = "loginName", value = "用户名", dataType = "String"),
//    	@ApiImplicitParam(name = "pwd", value = "密码", dataType = "Long"),
//    	@ApiImplicitParam(name = "search", value = "模糊搜索", dataType = "String")
//    })
	@RequestMapping(value = "/getList",method = RequestMethod.GET)
	public Message<IPage<UserDTO>> getList(UserQueryParam param){
		return userService.getUserList(param);
	}
}

