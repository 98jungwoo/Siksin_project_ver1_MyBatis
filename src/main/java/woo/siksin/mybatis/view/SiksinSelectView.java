package woo.siksin.mybatis.view;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import woo.siksin.mybatis.dto.SiksinDTO;
import woo.siksin.mybatis.service.SiksinServiceImp;

public class SiksinSelectView {

private static final Logger logger = LoggerFactory.getLogger(SiksinSelectView.class);

public static void main(String[] args) {
	ApplicationContext applicationContext = new GenericXmlApplicationContext(
			"file:src/main/webapp/WEB-INF/spring/root-context.xml");
	logger.info("정보", applicationContext);
	 SiksinServiceImp siksinServiceImp = (SiksinServiceImp) applicationContext.getBean("siksinServiceImp");
	logger.info("" + siksinServiceImp);
	List<SiksinDTO> list = siksinServiceImp.siksinSelectAll();
	
	System.out.println("------ ◆ 회원조회를 선택하였습니다.◆ ------");
	
	if (list.isEmpty()) {
		System.out.println("데이터가 없습니다.");
	}else {
		for (SiksinDTO siksinDTO : list) {
			System.out.println(siksinDTO);
		}
	}
}
}
