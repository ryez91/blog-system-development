package com.rikki.dao;

import java.util.Date;
import java.util.List;

import com.rikki.util.ViewAdvanced;

public interface viewDAO {
	public List queryById(int aId, String ip, Date date);
	public void addRecord(ViewAdvanced v);

}
