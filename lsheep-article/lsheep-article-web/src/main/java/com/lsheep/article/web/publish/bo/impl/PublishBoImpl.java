package com.lsheep.article.web.publish.bo.impl;

import com.lsheep.article.web.publish.bo.PublishBo;
import com.lsheep.article.web.publish.dto.ArticleDto;
import com.lsheep.common.core.base.annotation.Business;

@Business
public class PublishBoImpl implements PublishBo {

	@Override
	public void cacheIndex(ArticleDto articleDto) {
		// 生成索引KEY值

	}

}
