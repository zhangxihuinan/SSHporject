package com.company.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.dao.pojo.Goods;
import com.company.dao.pojo.Money;
import com.company.dao.pojo.ShoppingCart;
import com.company.service.iservice.GoodsService;
import com.company.service.iservice.MoneyService;
import com.company.service.iservice.ShoppingCartService;
import com.company.service.iservice.UserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("goodsAction")
@Scope("prototype")
public class GoodsAction implements ModelDriven<Goods>, RequestAware, SessionAware {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserService userService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private MoneyService moneyService;
	// 1.取值
	private int pageBegin = 1;
	private int pageSize = 3;
	
	private int ssid;//checked专用
	private int check; //checked专用
	private String balanceError;//显示余额不足的标示
	
	public String getBalanceError() {
		return balanceError;
	}

	public void setBalanceError(String balanceError) {
		this.balanceError = balanceError;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public int getSsid() {
		return ssid;
	}

	public void setSsid(int ssid) {
		this.ssid = ssid;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	private Goods goodsModel = new Goods();

	@Override
	public Goods getModel() {
		return goodsModel;
	}

	private Map<String, Object> requestMap;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;

	}

	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0;
	}

	// 2.处理
	public String findAllPage() {
		String msg = "error";
		List<Goods> findAllList = goodsService.findAll();
		// 总商品数量
		int all = findAllList.size();
		// 总页数
		int page = 0;
		List<Goods> goodsList = goodsService.findAllPage(pageBegin, pageSize);
		if (goodsList != null && goodsList.size() > 0 && findAllList != null && all > 0) {
			if (all % pageSize == 0) {
				page = all / pageSize;
			} else {
				page = (all / pageSize) + 1;
			}
			requestMap.put("goodsList", goodsList);
			requestMap.put("pageBegin", pageBegin);
			requestMap.put("all", all);
			requestMap.put("page", page);
			requestMap.put("urlprev", "findallpage.action?pageBegin="+(pageBegin-1));
			requestMap.put("urlnext", "findallpage.action?pageBegin="+(pageBegin+1));
			requestMap.put("fristurl", "findallpage.action?pageBegin=1");
			requestMap.put("urllast", "findallpage.action?pageBegin="+page);
			requestMap.put("nowtype", "综合");
			msg = "success";
		}

		return msg;
	}
	public String findByNmaePage() {
		
		String gname = goodsModel.getGname();
		String msg = "success";
		List<Goods> findByNameList = goodsService.findByName(gname);
		// 总商品数量
		int all = findByNameList.size();
		// 总页数
		int page = 0;
		List<Goods> goodsList = goodsService.findByNamePage(pageBegin, pageSize,gname);
		if (goodsList != null && goodsList.size() > 0 && findByNameList != null && all > 0) {
			if (all % pageSize == 0) {
				page = all / pageSize;
			} else {
				page = (all / pageSize) + 1;
			}
			requestMap.put("goodsList", goodsList);
			requestMap.put("pageBegin", pageBegin);
			requestMap.put("all", all);
			requestMap.put("page", page);
			requestMap.put("urlprev", "findbynamepage.action?pageBegin="+(pageBegin-1)+"&gname="+gname);
			requestMap.put("urlnext", "findbynamepage.action?pageBegin="+(pageBegin+1)+"&gname="+gname);
			requestMap.put("fristurl", "findbynamepage.action?pageBegin=1"+"&gname="+gname);
			requestMap.put("urllast", "findbynamepage.action?pageBegin="+page+"&gname="+gname);
			requestMap.put("nowtype", "综合");
			msg = "success";
		}

		return msg;

	}
	public String findByGtypePage() {
		String gtype = goodsModel.getGtype();
		String msg = "error";
		String nowtype = "";
		List<Goods> findByGtypeList = goodsService.findByGtype(gtype);
		if (gtype.equals("book")) {
			nowtype = "书籍";
		}else if (gtype.equals("game")) {
			nowtype = "游戏";
		}
		// 总商品数量
		int all = findByGtypeList.size();
		// 总页数
		int page = 0;
		List<Goods> goodsList = goodsService.findByGtypePage(pageBegin, pageSize,gtype);
		if (goodsList != null && goodsList.size() > 0 && findByGtypeList != null && all > 0) {
			if (all % pageSize == 0) {
				page = all / pageSize;
			} else {
				page = (all / pageSize) + 1;
			}
			requestMap.put("goodsList", goodsList);
			requestMap.put("pageBegin", pageBegin);
			requestMap.put("all", all);
			requestMap.put("page", page);
			requestMap.put("urlprev", "findbygtypepage.action?pageBegin="+(pageBegin-1)+"&gtype="+gtype);
			requestMap.put("urlnext", "findbygtypepage.action?pageBegin="+(pageBegin+1)+"&gtype="+gtype);
			requestMap.put("fristurl", "findbygtypepage.action?pageBegin=1"+"&gtype="+gtype);
			requestMap.put("urllast", "findbygtypepage.action?pageBegin="+page+"&gtype="+gtype);
			requestMap.put("nowtype", nowtype);
			msg = "success";
		}

		return msg;
	}
	public String addShoppingcart() {
		String msg = "error";
		String username = (String) sessionMap.get("username");
		int uid = 0;
		int gid = 0;
		if (username != null) {
			uid = userService.findUidByUsername(username);
			gid = goodsModel.getGid();
			ShoppingCart shoppingCart = new ShoppingCart(uid,gid,new Date());
			shoppingCart.setCheckbox(1);
			shoppingCartService.save(shoppingCart);
			requestMap.put("pageBegin", pageBegin);
			msg = "success";
		}
		return msg;
	}
	
	public String findAllShoppingcart(){
		String msg = "error";
		String username = (String) sessionMap.get("username");
		if (username != null) {
			//获取用户ID
			int uid = userService.findUidByUsername(username);
			List<ShoppingCart> shoppingCarList = shoppingCartService.findShoppingCartAllByUser(uid);
			List<Goods> goodsList = new ArrayList<Goods>();
			Money money = moneyService.findById(uid);
			//获取商品类
			for (ShoppingCart s : shoppingCarList) {
				Goods goods = goodsService.findById(s.getGid());
				goods.setSid(s.getSid());
				if (s.getCheckbox() == 1) {
					goods.setCheckbox("checked");
				}else {
					goods.setCheckbox("");
				}
				goodsList.add(goods);
			}
			msg = "success";
			requestMap.put("goodsList",goodsList);
			requestMap.put("money",money);
			requestMap.put("balanceError",balanceError);
		}
		return msg;
		
	}
	
	public void addChecked(){
		//System.out.println(ssid);
		//System.out.println(check);
		shoppingCartService.updateCheckBox(ssid, check);
	}
	
	public String deleteGoodsShoppingcart(){
		String msg = "error";
		int sid = goodsModel.getSid();
		ShoppingCart shoppingCart = shoppingCartService.findById(sid);
		if (shoppingCart != null) {
			msg = shoppingCartService.delete(shoppingCart);	
		}
		return msg;
	}
}
