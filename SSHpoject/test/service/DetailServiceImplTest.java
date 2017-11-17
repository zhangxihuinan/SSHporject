package service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.dao.pojo.Detail;
import com.company.service.iservice.DetailService;

public class DetailServiceImplTest {
	ApplicationContext ctx;
	DetailService detailService;
	@Before
	public void setUp(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		detailService = (DetailService) ctx.getBean("detailService");
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
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		int k = 1;
		Detail detail = detailService.findById(k);
		System.out.println(detail);
	}
	@Test
	public void testUpload() {
		int uid = 5;
		String filePath = "ok";
		String msg = detailService.upload(uid, filePath);
		System.out.println(msg);
	}

}
