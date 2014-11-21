package com.rikki.service.impl;

import java.util.List;

import com.rikki.dao.commentDAO;
import com.rikki.domain.comment;
import com.rikki.service.commentService;
import com.rikki.util.Page;
import com.rikki.util.PageResultCollection;
import com.rikki.util.PageUtil;

public class commentServiceImpl implements commentService {
	private commentDAO commentDao;

	public commentDAO getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(commentDAO commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public void addComment(comment c) {
		commentDao.addComment(c);
		

	}

	@Override
	public PageResultCollection showCommentByPage(int aId, Page page) {
		page = PageUtil.createPage(page, commentDao.queryCommentCount(aId));
		List<comment> all = commentDao.queryByPage(aId, page);
		PageResultCollection res = new PageResultCollection();
		res.setPage(page);
		res.setList(all);
		return res;
	}



}
