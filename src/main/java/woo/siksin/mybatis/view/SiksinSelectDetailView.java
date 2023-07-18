package woo.siksin.mybatis.view;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import woo.siksin.mybatis.dto.SiksinDTO;
import woo.siksin.mybatis.service.SiksinServiceImp;

public class SiksinSelectDetailView {

private static final Logger logger = LoggerFactory.getLogger(SiksinSelectDetailView.class);

public static void main(String[] args) {
	ApplicationContext applicationContext = new GenericXmlApplicationContext(
			"file:src/main/webapp/WEB-INF/spring/root-context.xml");
	logger.info("정보", applicationContext);
	 SiksinServiceImp siksinServiceImp = (SiksinServiceImp) applicationContext.getBean("siksinServiceImp");
	logger.info("" + siksinServiceImp);
	SiksinDTO siksinDTO = new SiksinDTO();
	
//	상세보기 할 회원번호 확인
	Scanner scanner = new Scanner(System.in);
	System.out.println("------ ◆ 회원정보 상세보기를 선택하였습니다.◆ ------");
	System.out.print("회원 번호: ");
	int memberNum = scanner.nextInt();
		
//	입력받은 회원번호를 샐랙트디테일을 실행하고, DTO에 저장
	siksinDTO = siksinServiceImp.siksinSelectDetail(memberNum);
	logger.info("");
	
//	입력한 회원번호에 해당하는 내용이 없으면 문자열을 띄우고, 있으면 쿼리문이 동작한 결과값 보여짐
	if (siksinDTO == null) {
		System.out.println("데이터가 없습니다.");
	}else {
		System.out.println(siksinDTO);
	}
	scanner.close();
	
}
}
