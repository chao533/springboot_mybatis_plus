package com.kang.model.base;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageModel {

	
	private Long pageNum = 1L;
	
	private Long pageSize = 10L;
}
