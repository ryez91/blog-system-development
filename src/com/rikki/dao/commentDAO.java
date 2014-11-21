package com.rikki.dao;

import java.util.List;

import com.rikki.domain.comment;
import com.rikki.util.Page;

public interface commentDAO{
	public void addComment(comment c);
	public int queryCommentCount(int aId);
	public List<comment> queryByPage(int aId, Page page);

}
