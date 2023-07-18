package woo.siksin.mybatis.login;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import woo.siksin.mybatis.service.SiksinServiceImp;

public class SiksinLoginView {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new GenericXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		logger.info("정보", applicationContext);
		SiksinServiceImp siksinServiceImp = (SiksinServiceImp) applicationContext.getBean("siksinServiceImp");
		logger.info("" + siksinServiceImp);

		Scanner scanner = new Scanner(System.in);
		System.out.println("------ ◆ 로그인을 선택하였습니다.◆ ------");
		System.out.print("핸드폰번호: ");
		String phoneNum = scanner.next();
		System.out.print("비밀번호: ");
		String password = scanner.next();

//		SiksinDTO siksinDTO = new SiksinDTO();
//		siksinServiceImp.siksinlogin(phoneNum, password);
//		siksinDTO.setPhoneNum(phoneNum);
//		siksinDTO.setPassword(password);

//		원래는 이렇게 비교했는데 그냥 서비스로 동작자체를 해버리면 위에 코드 4줄이 다 사라져도 되는거임 매퍼에서 자동으로 DTO로 저장되기 때문에 여기서 set을 해주지 않아도 되는거다.
//		if (siksinDTO.getPhoneNum().equals(phoneNum) && siksinDTO.getPassword().equals(password)) {

		if (siksinServiceImp.siksinlogin(phoneNum, password) == null) {
			System.out.println("로그인에 실패하였습니다.");

		} else {
			System.out.println("로그인이 완료되었습니다.");
		}
		scanner.close();
	}
}
