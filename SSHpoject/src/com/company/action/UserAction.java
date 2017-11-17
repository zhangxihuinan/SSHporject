package com.company.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Money;
import com.company.dao.pojo.User;
import com.company.service.iservice.DetailService;
import com.company.service.iservice.MoneyService;
import com.company.service.iservice.ReportService;
import com.company.service.iservice.UserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction implements ModelDriven<User>,SessionAware,RequestAware{
	@Autowired
	private UserService userService;
	@Autowired
	private MoneyService moneyService;
	@Autowired
	private DetailService detailService;
	@Autowired
	private ReportService reportService;
	//取值
	private User userModel = new User();
	@Override
	public User getModel() {
		return userModel;
	}
	
	private Map<String, Object> sessionMap;
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0;
	}
	
	private Map<String, Object> requestMap;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}
	//处理
	public String login(){
		String msg = userService.login(userModel);
		if ("success".equals(msg)) {
			sessionMap.put("username", userModel.getUsername());
		}
		return msg;
	}
	public String loginError(){
		String str = "登录失败用户名或密码错误!";
		requestMap.put("str", str);
		return "success";
	}
	
	public String registry(){
		String msg = "error";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String birthday = simpleDateFormat.format(userModel.getBirthday());
		Detail detail = new Detail(userModel.getRealname(),userModel.getSex(),userModel.getPhone(),
				birthday,userModel.getFilePath());
		String date = simpleDateFormat.format(new Date());
		userModel.setAdddate(date);
		userModel.setPriority("0");
		String registry1 = userService.registry(userModel, detail);
		int uid = userService.findUidByUsername(userModel.getUsername());
		Money money = new Money();
		money.setUid(uid);
		String registry2 = moneyService.save(money);
		if ("success".equals(registry1) && "success".equals(registry2)) {
			msg = "success";
		}
		return msg;
	}
	
	public String userCenter(){
		String msg = "error";
		String username = (String) sessionMap.get("username");
		int uid = userService.findUidByUsername(username);
		
		User user = userService.findById(uid);
		//System.out.println(user);
		Detail detail = detailService.findById(uid);
		Money money = moneyService.findById(uid);
		//System.out.println(money);
		if (user != null && detail != null && money != null) {
			msg = "success";
			requestMap.put("user",user);
			requestMap.put("detail",detail);
			requestMap.put("money",money);
		}
		return msg;
	}
	
	public String userCenterUpdate(){
		//System.out.println(userModel.getPassword());
		//System.out.println(userModel.getRealname());
		//System.out.println(userModel.getUid());
		String msg = "error";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String birthday = simpleDateFormat.format(userModel.getBirthday());
		Detail detail = new Detail(userModel.getUid(),userModel.getRealname(),userModel.getSex(),
				userModel.getPhone(),birthday,userModel.getFilePath());
		
		String str1 = userService.update(userModel);
		String str2 = detailService.update(detail);
	
		if ("success".equals(str1) && "success".equals(str2)) {
			msg = "success";
		}
		
		return msg;		
	}
	
	public String userOut(){
		String msg = "error";
		sessionMap.clear();
		if (sessionMap.get("username") == null) {
			msg = "success";
		}
		return msg;
		
	}
	public String moneyCenter(){
		String msg = "error";
		String username = (String) sessionMap.get("username");
		int uid = userService.findUidByUsername(username);
		Money money = moneyService.findById(uid);
		Detail detail = detailService.findById(uid);
		String filePath = detail.getFilePath();
		if (money != null && detail != null) {
			requestMap.put("money",money);
			requestMap.put("filePath",filePath);
			msg = "success";
		}
					
		return msg;		
	}
	
	public void report(){
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//17年11月份男性用户购买商品类型为书籍并且单价超过20RMB的商品名称
		String report = reportService.report();
		//response.setContentType("text/html;charset=utf-8");
		//request.setCharacterEncoding("utf-8");
		try {
			ServletActionContext.getResponse().getWriter().println(report);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
