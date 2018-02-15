package co.kr.myhome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.myhome.common.CommonDAO;
import co.kr.utils.mybatis.vo.TestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/**/*-context.xml",
		"file:src/main/webapp/WEB-INF/**/mysql.xml",
		"file:src/main/resources/mybatis/*.xml"
})
public class TestSpring {

	@Autowired
	CommonDAO commonDAO;
	
	@Test
	public void test() throws Exception{
		System.out.println("test");
		TestVO vo =  new TestVO();
		vo.setName("sumin");
		vo.setNotNullFields();
		System.out.println(vo.getNames());
		System.out.println(vo.getValues());
		System.out.println("°á°ú°ª : " + commonDAO.selectList("co.kr.myhome.common.selectList",vo));
	}
}
