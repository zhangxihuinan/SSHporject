package com.company.action;

import java.text.SimpleDateFormat;
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
import com.company.dao.pojo.Order;
import com.company.dao.pojo.ShoppingCart;
import com.company.dao.pojo.UserOrder;
import com.company.service.iservice.GoodsService;
import com.company.service.iservice.MoneyService;
import com.company.service.iservice.OrderService;
import com.company.service.iservice.ShoppingCartService;
import com.company.service.iservice.UserOrderService;
import com.company.service.iservice.UserService;

@Controller("orderAction")
@Scope("prototype")
public class OrderAction implements SessionAware,RequestAware{
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private MoneyService moneyService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserOrderService userorderService;

	private List<String> quantity;//单个数量集合
	private List<String> orderquantity;//单个数量集合
	private double allcount;//订单总价
	private double orderallcount;//订单总价
	private String receive;//收货地址
	private List<String> nowcount;//单品总价
	private String date;//订单编号  时间
	private String orderdate;//订单编号 查看订单作用
	
	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public double getOrderallcount() {
		return orderallcount;
	}

	public void setOrderallcount(double orderallcount) {
		this.orderallcount = orderallcount;
	}

	public List<String> getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(List<String> orderquantity) {
		this.orderquantity = orderquantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getNowcount() {
		return nowcount;
	}

	public void setNowcount(List<String> nowcount) {
		this.nowcount = nowcount;
	}

	public double getAllcount() {
		return allcount;
	}

	public void setAllcount(double allcount) {
		this.allcount = allcount;
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	public List<String> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<String> quantity) {
		this.quantity = quantity;
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
	
	public String listOrder(){
		String msg = "error";
		String username = (String) sessionMap.get("username");
		Date newdate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		//订单编号（下单时间）
		String date = simpleDateFormat.format(newdate);
		List<Goods> goodsList = new ArrayList<Goods>();
		System.out.println(allcount);
		
		if (username != null) {
			int uid = userService.findUidByUsername(username);
			Money money = moneyService.findById(uid);
			List<ShoppingCart> shoppingCartList = shoppingCartService.findShoppingCartAllByUser(uid);
			for (int i = 0; i < shoppingCartList.size(); i++) {
				if (shoppingCartList.get(i).getCheckbox() == 1) {
					Goods goods = goodsService.findById(shoppingCartList.get(i).getGid());
					goods.setQuantity(Integer.parseInt(quantity.get(i)));
					goods.setNowcount(nowcount.get(i));
					goodsList.add(goods);
				}	
			}
			requestMap.put("goodsList", goodsList);
			requestMap.put("allcount", allcount);
			requestMap.put("money", money);
			requestMap.put("date", date);
			msg = "success";
		}
		return msg;
	}
	
	public String addOrder() {
		String msg = "error";
		ShoppingCart shoppingCart = new ShoppingCart();
		String username = (String) sessionMap.get("username");
		if (username != null) {
			int uid = userService.findUidByUsername(username);
			//获取当前用户的Money信息（余额等）
			Money money = moneyService.findById(uid);
			//当前用户余额
			double balance = money.getBalance();
			if (balance >= orderallcount) {
				//用户扣完钱剩余的余额
				double upbalance =  balance-orderallcount;
				money.setBalance(upbalance);
				moneyService.update(money);
				List<ShoppingCart> List = shoppingCartService.findShoppingCartAllByUser(uid);
				List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
				for (int i = 0; i < List.size(); i++){
					if (List.get(i).getCheckbox() == 1) {
						shoppingCartList.add(List.get(i));
					}
					
				}
				for (int i = 0; i < shoppingCartList.size(); i++) {
					
					if (shoppingCartList.get(i).getCheckbox() == 1) {
						Order order = new Order(date,uid,shoppingCartList.get(i).getGid(),Integer.parseInt(orderquantity.get(i)),orderallcount,receive);
						//生成订单信息存在数据库
						orderService.save(order);
						shoppingCart.setSid(shoppingCartList.get(i).getSid());
						//删除购买完成的物品
						shoppingCartService.delete(shoppingCart);
					}	
				}
				UserOrder userorder = new UserOrder(uid,date,receive);
				userorderService.save(userorder);
				msg = "success";
			}else {
				msg = "error";
			}
		}
		return msg;
		
	}
	
	public String userOrderCenter(){
		String username = (String) sessionMap.get("username");
		int uid = userService.findUidByUsername(username);
		List<UserOrder> userOrderList = userorderService.findAllById(uid);
		requestMap.put("userOrderList", userOrderList);
		return "success";
	}
	public String userOrderfindByOrderDate(){
		String username = (String) sessionMap.get("username");
		int uid = userService.findUidByUsername(username);
		List<Order> orderList = userorderService.findUidByOrderDate(uid,orderdate);
		List<Goods> goodsList = new ArrayList<Goods>();
		double allcount = 0;
		for (Order order : orderList) {
			allcount = order.getAllcount();
			int gid = order.getGid();
			Goods goods = goodsService.findById(gid);
			goodsList.add(goods);
		}
		requestMap.put("orderList", orderList);
		requestMap.put("goodsList", goodsList);
		requestMap.put("receive", receive);
		requestMap.put("orderdate", orderdate);
		requestMap.put("allcount", allcount);
		return "success";
	}
	
	
}
