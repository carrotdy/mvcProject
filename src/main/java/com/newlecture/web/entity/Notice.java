package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
	private int no;
	private String title;
	private String writerId;
	private Date regDate;
	private String content;
	private int hit;
	private String files;
	
	public void print(){
		System.out.printf("%d %s %s %s %d %s\n",
				this.no,
				this.title,
				this.writerId,
				this.content,
				this.hit,
				this.files);
	}
	
	public Notice() {}

	public Notice(int no, String title, String writerId, Date regDate, String content, int hit, String files) {
		this.no = no;
		this.title = title;
		this.writerId = writerId;
		this.regDate = regDate;
		this.content = content;
		this.hit = hit;
		this.files = files;
	}

	public int getno() {
		return no;
	}

	public void setId(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
}


