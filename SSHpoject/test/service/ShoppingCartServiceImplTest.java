package service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.dao.pojo.ShoppingCart;
import com.company.service.iservice.ShoppingCartService;

public class ShoppingCartServiceImplTest {
	ApplicationContext ctx;
	ShoppingCartService shoppingCartService;
	@Before
	public void setUp(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		shoppingCartService = (ShoppingCartService) ctx.getBean("shoppingCartService");
	}
	@After
	public void tearDown(){
		ctx = null;
	}
	
	@Test
	public void testSave() {
		ShoppingCart s = new ShoppingCart(1,5,new Date());
		String msg = shoppingCartService.save(s);
		System.out.println(msg);
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
		List<ShoppingCart> s = shoppingCartService.findAll();
		for (ShoppingCart shoppingCart : s) {
			System.out.println(shoppingCart);
		}
	}
	@Test
	public void testFindAllByUser() {
		int uid = 1;
		List<ShoppingCart> s = shoppingCartService.findShoppingCartAllByUser(uid);
		for (ShoppingCart shoppingCart : s) {
			System.out.println(shoppingCart);
		}
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}
	@Test
	public void testUpdateCheckBox() {
		String str = shoppingCartService.updateCheckBox(9, 1);
		System.out.println(str);
	}

}
