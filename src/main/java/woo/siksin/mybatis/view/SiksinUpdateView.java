package woo.siksin.mybatis.view;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import woo.siksin.mybatis.dto.SiksinDTO;
import woo.siksin.mybatis.service.SiksinServiceImp;

public class SiksinUpdateView {

private static final Logger logger = LoggerFactory.getLogger(SiksinUpdateView.class);

public static void main(String[] args) {
	ApplicationContext applicationContext = new GenericXmlApplicationContext(
			"file:src/main/webapp/WEB-INF/spring/root-context.xml");
	logger.info("정보", applicationContext);
	 SiksinServiceImp siksinServiceImp = (SiksinServiceImp) applicationContext.getBean("siksinServiceImp");
	logger.info("" + siksinServiceImp);
	SiksinDTO siksinDTO = new SiksinDTO();
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("------ ◆ 회원정보 수정을 선택하였습니다.◆ ------");
	System.out.println("회원정보를 수정하세요");
	System.out.println();

	
//	회원번호를 검색해서 해당하는 내용이 있는지 확인
	System.out.print("수정할 회원 번호: ");
	int memberNum = scanner.nextInt();
	siksinDTO = siksinServiceImp.siksinSelectDetail(memberNum);
	
//	입력한 회원번호에 해당하는 내용이 없으면 문자열을 띄우고, 있으면 수정할 내용 입력
	if (siksinDTO == null) {
		System.out.println("데이터가 없습니다.");
		
	}else {
		
		System.out.println();
		System.out.println("비밀번호 : " + siksinDTO.getPassword( ));
		System.out.print("수정할 비밀번호: ");
		String password = scanner.next();
		
		System.out.println("닉네임 : " + siksinDTO.getNickName());
		System.out.print("수정할 닉네임: ");
		String nickName = scanner.next();
		
		System.out.println("전화번호 : " + siksinDTO.getPhoneNum());
		System.out.print("수정할 전화번호 : ");
		String phoneNum = scanner.next();
		
		System.out.println("사는지역 : " + siksinDTO.getMemberArea());
		System.out.print("수정할 사는지역 : ");
		String memberArea = scanner.next();
		
		siksinDTO.setPassword(password);
		siksinDTO.setNickName(nickName);
		siksinDTO.setPhoneNum(phoneNum);
		siksinDTO.setMemberArea(memberArea);
		
//		수정할 내용을 서비스로 보내주면서 쿼리문이 작성하게 된다.
		siksinServiceImp.siksinUpdate(siksinDTO);		
		
//		삭제된 후 전체보기를 실행
		List<SiksinDTO> list = siksinServiceImp.siksinSelectAll();
		for (SiksinDTO siksinDTO2 : list) {
			System.out.println(siksinDTO2);
		}
		scanner.close();
	}
}
}
