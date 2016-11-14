package com.psy.history.web;

import org.springframework.stereotype.Controller;

import com.psy.history.service.HistoryService;

@Controller
public class HistoryController {

	private HistoryService historyService;
	
	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	
}
