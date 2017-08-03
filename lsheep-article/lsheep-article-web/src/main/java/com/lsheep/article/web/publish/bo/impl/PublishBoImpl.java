package com.lsheep.article.web.publish.bo.impl;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.lsheep.article.web.comment.Constants;
import com.lsheep.article.web.publish.bo.PublishBo;
import com.lsheep.article.web.publish.dto.ArticleDto;
import com.lsheep.common.core.base.annotation.Business;
import com.lsheep.middleware.cache.redis.RedisCache;

@Business
public class PublishBoImpl implements PublishBo {

	private static final long WEIGHT = 24 * 60 * 60 / 200;

	@Override
	public void storeIndex(ArticleDto articleDto) {
		String articleId = articleDto.getArticleId();
		Long current = System.currentTimeMillis() / 1000;
		// 加入文章列表
		RedisCache.hset(Constants.NAMESPACE, "article", articleId, articleDto);
		List<String> tags = articleDto.getTags();
		if (!CollectionUtils.isEmpty(tags)) {
			for (String tag : tags) {
				RedisCache.sadd(Constants.NAMESPACE, "article_tag:".concat(tag), articleId);
			}
		}
		RedisCache.zadd(Constants.NAMESPACE, "article_sort:time", articleId, current);
		RedisCache.zadd(Constants.NAMESPACE, "article_sort:weight", articleId, current + WEIGHT);
	}

}
