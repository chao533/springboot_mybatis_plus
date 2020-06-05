package com.kang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.common.msg.Message;
import com.kang.model.User;
import com.kang.model.dto.UserDTO;
import com.kang.model.param.UserParam;
import com.kang.model.param.UserQueryParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chaokang
 * @since 2020-06-04
 */
public interface UserService extends IService<User> {

	Message<String> saveUser(UserParam userParam);
	
	Message<String> updateUser(UserParam userParam);
	
	Message<String> deleteUser(String ids);
	
	Message<UserDTO> getUserOne(Long id);
	
	Message<IPage<UserDTO>> getUserList(UserQueryParam param);
	
	
}
