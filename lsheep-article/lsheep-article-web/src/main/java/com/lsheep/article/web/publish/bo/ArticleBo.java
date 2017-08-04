package com.lsheep.article.web.publish.bo;

import com.lsheep.article.web.publish.dto.ArticleDto;
import com.lsheep.article.web.publish.dto.ArticleVoteDto;

public interface ArticleBo {

	void storeArticleIndex(ArticleDto articleDto);

	void voteArticle(ArticleVoteDto articleVoteDto);

}
