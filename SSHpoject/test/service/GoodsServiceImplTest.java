package service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.dao.pojo.Goods;
import com.company.service.iservice.GoodsService;

public class GoodsServiceImplTest {
	ApplicationContext ctx;
	GoodsService goodsService;
	@Before
	public void setUp(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		goodsService = (GoodsService) ctx.getBean("goodsService");
	}
	@After
	public void tearDown(){
		ctx = null;
	}
	
	@Test
	public void testFindAll() {
		List<Goods> goodsList = goodsService.findAll();
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}
	@Test
	public void testSave() {
		Goods goods = new Goods("魔兽世界1x","BL",45,"game");
		goodsService.save(goods);
	}

	@Test
	public void testUpdate() {
		Goods goods = goodsService.findById(3);
		goods.setGname("守望先锋");
		goods.setMaker("Blizzard");
		goodsService.update(goods);
		testFindAll();
	}

	@Test
	public void testDelete() {
		Goods goods = goodsService.findById(2);
		goodsService.delete(goods);
		testFindAll();
	}
	
	@Test
	public void testFindById() {
		Goods goods = goodsService.findById(1);
		System.out.println(goods);
	}

	@Test
	public void testFindByName() {
		String gname = "世";
		List<Goods> goodsList = goodsService.findByName(gname);
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}
	@Test
	public void testFindAllPage() {
		int pageBegin = 2;
		int pageSize = 4;
		List<Goods> goodsList = goodsService.findAllPage(pageBegin, pageSize);
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}
	@Test
	public void testDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
		Date date = new Date();
		String ok = null;
		ok = simpleDateFormat.format(date);
		System.out.println(ok);
	}

}
