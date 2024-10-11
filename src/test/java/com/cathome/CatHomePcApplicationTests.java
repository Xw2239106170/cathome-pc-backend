package com.cathome;

import com.cathome.service.CatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CatHomePcApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Autowired
	private CatService catService;
	@Test
	public void testXml(){
		System.out.println(catService.selectCat(1, 5, "小徐", "已领养"));
	}
}
