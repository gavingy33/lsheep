package com.lsheep.article.web.publish.bo;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.lsheep.article.web.publish.dto.ArticleDto;
import com.lsheep.article.web.publish.dto.ArticleVoteDto;
import com.lsheep.test.BaseTest;

public class TestPublishBo extends BaseTest {

	@Resource
	private ArticleBo publishBo;

	@Test
	public void testStoreIndex() {
		ArticleDto articleDto = new ArticleDto();
		articleDto.setArticleId("001");
		articleDto.setTitle("测试文章发布");
		articleDto.setLink("/atrile/001.html");
		articleDto.setAuthorId("000001");
		articleDto.setPublishDate(new Date());
		articleDto.setTags(Arrays.asList(new String[] { "TAG_A", "TAG_B" }));
		publishBo.storeArticleIndex(articleDto);
	}

	@Test
	public void testVote() {
		ArticleVoteDto articleVoteDto = new ArticleVoteDto();
		articleVoteDto.setArticleId("001");
		articleVoteDto.setVoteCustomerId("000001");
		publishBo.voteArticle(articleVoteDto);
	}

}
