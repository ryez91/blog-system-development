package com.rikki.service;

import com.rikki.domain.comment;
import com.rikki.util.Page;
import com.rikki.util.PageResultCollection;

public interface commentService {
	public void addComment(comment c);
	public PageResultCollection showCommentByPage(int aId, Page page);
	
	

}
