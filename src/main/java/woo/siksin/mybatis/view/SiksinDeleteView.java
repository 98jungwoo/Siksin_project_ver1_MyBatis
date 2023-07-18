package woo.siksin.mybatis.view;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import woo.siksin.mybatis.dto.SiksinDTO;
import woo.siksin.mybatis.service.SiksinServiceImp;

public class SiksinDeleteView {

	private static final Logger logger = LoggerFactory.getLogger(SiksinDeleteView.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = new GenericXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		logger.info("정보", applicationContext);
		SiksinServiceImp siksinServiceImp = (SiksinServiceImp) applicationContext.getBean("siksinServiceImp");
		logger.info("" + siksinServiceImp);
		SiksinDTO siksinDTO = new SiksinDTO();

//		삭제할 회원번호 확인
		Scanner scanner = new Scanner(System.in);
		System.out.println("------ ◆ 회원정보 삭제을 선택하였습니다.◆ ------");
		System.out.print("삭제할 회원 번호: ");
		int memberNum = scanner.nextInt();
		
//		입력받은 회원번호를 샐랙트디테일을 실행하고, DTO에 저장
		siksinDTO = siksinServiceImp.siksinSelectDetail(memberNum);

		if (siksinDTO == null) {
			System.out.println("데이터가 없습니다.");
			
		} else {
			siksinServiceImp.siksinDelete(memberNum);
			
//			삭제된 후 전체보기를 실행
			List<SiksinDTO> list = siksinServiceImp.siksinSelectAll();
			for (SiksinDTO siksinDTO2 : list) {
				System.out.println(siksinDTO2);
			}
			scanner.close();
		}
	}
}
