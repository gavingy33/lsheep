package com.lsheep.article.web.publish.dto;

public class ArticleVoteDto {
	private String articleId;
	private String voteCustomerId;

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getVoteCustomerId() {
		return voteCustomerId;
	}

	public void setVoteCustomerId(String voteCustomerId) {
		this.voteCustomerId = voteCustomerId;
	}

}
