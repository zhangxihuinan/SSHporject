package service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.dao.pojo.Order;
import com.company.service.iservice.OrderService;

public class OrderServiceImplTest {
	ApplicationContext ctx;
	OrderService orderService;
	@Before
	public void setUp(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		orderService = (OrderService) ctx.getBean("orderService");
	}
	@After
	public void tearDown(){
		ctx = null;
	}

	@Test
	public void testSave() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String ok = simpleDateFormat.format(date);
		Order order = new Order(ok,1,3,3,294,"大连东软");
		orderService.save(order);
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
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

}
