package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.ReportDao;
import com.company.service.iservice.ReportService;
import com.google.gson.Gson;
@Service("reportService")
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao reportDao;
	@Transactional
	@Override
	public String report() {
		List<String> reportList = new ArrayList<String>();
		String report = "";
		try {
			reportList = reportDao.report();
			Gson gson = new Gson();
			report = gson.toJson(reportList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}

}
