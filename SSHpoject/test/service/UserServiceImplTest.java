package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.dao.pojo.User;
import com.company.dao.pojo.UserOrder;
import com.company.service.iservice.ReportService;
import com.company.service.iservice.UserOrderService;
import com.company.service.iservice.UserService;

public class UserServiceImplTest {
	ApplicationContext ctx;
	UserService userService;
	UserOrderService userorderService;
	ReportService reportService;
	@Before
	public void setUp(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService) ctx.getBean("userService");
		userorderService = (UserOrderService) ctx.getBean("userorderService");
		reportService = (ReportService) ctx.getBean("reportService");
	}
	@After
	public void tearDown(){
		ctx = null;
	}
	
	
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<User> userList = userService.findAll();
		for (User user : userList) {
			System.out.println(user);
		}
 	}

	@Test
	public void testFindById() {
		int k = 1;
		User user = userService.findById(k);
		System.out.println(user);
	}

	@Test
	public void testLogin() {
		User user = new User("zhangsan","123");
		String msg = userService.login(user);
		System.out.println(msg);
	}

	@Test
	public void testRegistry() {
		fail("Not yet implemented");
	}
	@Test
	public void testfindUidByUsername(){
		int uid = userService.findUidByUsername("zhangsan");
		System.out.println(uid);
	}
	@Test
	public void testfindAllById(){
		int uid = 2;
		List<UserOrder> userorderList = userorderService.findAllById(uid);
				for (UserOrder userOrder : userorderList) {
					System.out.println(userOrder);
				}
	}
	
	
	@Test
	public void testReport() {
		String reportList = reportService.report();	
		System.out.println(reportList);
	}

}
