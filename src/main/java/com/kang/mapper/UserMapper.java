package com.kang.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kang.model.User;
import com.kang.model.dto.UserDTO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chaokang
 * @since 2020-06-04
 */
public interface UserMapper extends BaseMapper<User> {
	
	
	IPage<UserDTO> getUserList(IPage<?> page,@Param("p")Map<String,Object> params);

}
