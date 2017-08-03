package com.lsheep.article.web.publish.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lsheep.article.client.publish.dto.request.PublishReqDto;
import com.lsheep.article.client.publish.dto.response.PublishResDto;
import com.lsheep.article.client.publish.service.PublishService;
import com.lsheep.article.web.publish.bo.PublishBo;
import com.lsheep.article.web.publish.dto.ArticleDto;
import com.lsheep.common.core.base.service.impl.BaseServiceImpl;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;

@Service
public class PublishServiceImpl extends BaseServiceImpl implements PublishService {

	@Resource
	private PublishBo publishBo;

	@Override
	public TransferResponse<PublishResDto> publish(TransferRequest<PublishReqDto> request) {
		// 基本入参校验

		// 保存文章

		// 生成文章静态页

		// 生成文章检索信息
		ArticleDto articleDto = new ArticleDto();
		publishBo.cacheIndex(articleDto);

		return null;
	}

}
