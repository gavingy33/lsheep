package com.lsheep.article.web.publish.bo.impl;

import static com.lsheep.article.web.comment.Constants.NAMESPACE;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.lsheep.article.web.publish.bo.ArticleBo;
import com.lsheep.article.web.publish.dto.ArticleDto;
import com.lsheep.article.web.publish.dto.ArticleVoteDto;
import com.lsheep.common.core.base.annotation.Business;
import com.lsheep.common.core.base.bo.impl.BaseBoImpl;
import com.lsheep.middleware.cache.redis.RedisCache;

@Business
public class ArticleBoImpl extends BaseBoImpl implements ArticleBo {

	private static final long SORT_WEIGHT = 24 * 60 * 60 / 200;
	private static final String KEY__ARTICLE = "ARTICLE";
	private static final String KEY__ARTICLE_TAG_PREFIX = "ARTICLE_TAG:";
	private static final String KEY__SORT_TIME = "ARTICLE_SORT:TIME";
	private static final String KEY__SORT_WEIGHT = "ARTICLE_SORT:WEIGHT";
	private static final String KEY__ARTICLE_VOTE_PREFIX = "ARTICLE_VOTE:";

	@Override
	public void storeArticleIndex(ArticleDto articleDto) {
		String articleId = articleDto.getArticleId();
		// 加入文章列表
		RedisCache.hset(NAMESPACE, KEY__ARTICLE, articleId, articleDto);
		List<String> tags = articleDto.getTags();
		if (!CollectionUtils.isEmpty(tags)) {
			for (String tag : tags) {
				RedisCache.sadd(NAMESPACE, KEY__ARTICLE_TAG_PREFIX.concat(tag), articleId);
			}
		}
		Long current = System.currentTimeMillis() / 1000;
		// 按文章发布时间
		RedisCache.zadd(NAMESPACE, KEY__SORT_TIME, articleId, current);
		// 按文章发布时间及投票数
		RedisCache.zadd(NAMESPACE, KEY__SORT_WEIGHT, articleId, current);
	}

	@Override
	public void voteArticle(ArticleVoteDto articleVoteDto) {
		String articleId = articleVoteDto.getArticleId();
		String voteCustomerId = articleVoteDto.getVoteCustomerId();
		String voteArticle = KEY__ARTICLE_VOTE_PREFIX.concat(articleId);
		long numbers = RedisCache.sadd(NAMESPACE, voteArticle, voteCustomerId);
		if (numbers <= 0) {
			logger.warn("key:[{}] in set:[{}] has being exists, vote fail", voteCustomerId, voteArticle);
			return;
		}
		long incrWeight = 1 * SORT_WEIGHT;
		RedisCache.zincrby(NAMESPACE, KEY__SORT_WEIGHT, articleId, incrWeight);
	}

}
