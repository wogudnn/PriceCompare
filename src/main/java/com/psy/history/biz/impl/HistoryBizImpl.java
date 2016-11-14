package com.psy.history.biz.impl;

import com.psy.history.biz.HistoryBiz;
import com.psy.history.dao.HistoryDao;

public class HistoryBizImpl implements HistoryBiz {

	private HistoryDao historyDao;
	
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
}
