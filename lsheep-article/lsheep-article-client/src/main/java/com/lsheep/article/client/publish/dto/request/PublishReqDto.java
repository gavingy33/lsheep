package com.lsheep.article.client.publish.dto.request;

import java.sql.Date;
import java.util.List;

public class PublishReqDto {

	private String title;
	private String authorId;
	private String context;
	private Date publishDate;
	private String coverImageId;
	private List<String> tags;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getCoverImageId() {
		return coverImageId;
	}

	public void setCoverImageId(String coverImageId) {
		this.coverImageId = coverImageId;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
