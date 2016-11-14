package com.psy.history.service.impl;

import com.psy.history.biz.HistoryBiz;
import com.psy.history.service.HistoryService;

public class HistoryServiceImpl implements HistoryService {

	private HistoryBiz historyBiz;
	
	
	public void setHistoryBiz(HistoryBiz historyBiz) {
		this.historyBiz = historyBiz;
	}
	
}
