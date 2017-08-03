package com.lsheep.middleware.cache.redis.hash;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.lsheep.middleware.cache.redis.RedisCache;
import com.lsheep.test.BaseTest;

public class TestRedisHash extends BaseTest {

	@Test
	public void testHset() throws Exception {
		Article article = new Article();
		article.setTitle("测试文章发布");
		article.setLink("/atrile/001.html");
		article.setAuthorId("000001");
		article.setPublishDate(new Date());
		RedisCache.hset("ARTICLE", "article_index", "article_001", article);
	}

	@Test
	public void testHget() {
		Article article = RedisCache.hget("ARTICLE", "article_index", "article_001", Article.class);
		System.out.println(JSON.toJSONString(article));
	}

	@Test
	public void testHgetall() {
		Map<String, Article> articles = RedisCache.hgetall("ARTICLE", "article_index", Article.class);
		for (Map.Entry<String, Article> entry : articles.entrySet()) {
			System.out.println(String.format("key:%-15s value:%s", entry.getKey(), JSON.toJSONString(entry.getValue())));
		}
	}

}

class Article {
	private String title;
	private String link;
	private String authorId;
	private Integer votes;
	private Date publishDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}