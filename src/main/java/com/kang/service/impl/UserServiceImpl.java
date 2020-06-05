package com.kang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.common.msg.ErrorCode;
import com.kang.common.msg.Message;
import com.kang.mapper.UserMapper;
import com.kang.model.User;
import com.kang.model.dto.UserDTO;
import com.kang.model.param.UserParam;
import com.kang.model.param.UserQueryParam;
import com.kang.service.UserService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.SecureUtil;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chaokang
 * @since 2020-06-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Message<String> saveUser(UserParam userParam) {
		userParam.setPwd(SecureUtil.md5(userParam.getPwd()).toUpperCase());
		if(!save(Convert.convert(User.class, userParam))) {
			throw new RuntimeException("添加失败");
		}
		return new Message<>(ErrorCode.SUCCESS);
	}

	@Override
	public Message<String> updateUser(UserParam userParam) {
		Assert.notNull(userParam.getId(),"参数异常");
		if(!updateById(Convert.convert(User.class, userParam))) {
			throw new RuntimeException("修改失败");
		}
		return new Message<>(ErrorCode.SUCCESS);
	}

	@Override
	public Message<String> deleteUser(String ids) {
		Assert.notBlank(ids, "参数异常");
		if(!removeByIds(CollUtil.toList(ids.split(",")))) {
			throw new RuntimeException("删除失败");
		}
		return new Message<>(ErrorCode.SUCCESS);
	}

	@Override
	public Message<UserDTO> getUserOne(Long id) {
		Assert.notNull(id,"参数异常");
		return new Message<>(ErrorCode.SUCCESS,Convert.convert(UserDTO.class, getById(id)));
	}

	@Override
	public Message<IPage<UserDTO>> getUserList(UserQueryParam param) {
		IPage<UserDTO> userList = userMapper.getUserList(new Page<>(param.getPageNum(),param.getPageSize()), BeanUtil.beanToMap(param));
		return new Message<>(ErrorCode.SUCCESS,userList);
	}

}
