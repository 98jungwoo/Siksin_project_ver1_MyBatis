package woo.siksin.mybatis.view;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import woo.siksin.mybatis.dto.SiksinDTO;
import woo.siksin.mybatis.service.SiksinServiceImp;

public class SiksinInsertView {

	private static final Logger logger = LoggerFactory.getLogger(SiksinInsertView.class);


	public static void main(String[] args) {
		ApplicationContext applicationContext = new GenericXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		logger.info("정보", applicationContext);
		SiksinServiceImp siksinServiceImp = (SiksinServiceImp) applicationContext.getBean("siksinServiceImp");
		logger.info("" + siksinServiceImp);
		SiksinDTO siksinDTO = new SiksinDTO();

		Scanner scanner = new Scanner(System.in);
		System.out.println("------ ◆ 회원가입을 선택하였습니다.◆ ------");
		System.out.println("회원 정보를 입력하세요.");
		System.out.println();

//	회원번호를 시퀀스를 사용하였기 때문에  입력하지 않아도 됨
//	System.out.print("회원 번호: ");
//	int memberNum = scanner.nextInt();
		System.out.print("회원 이름: ");
		String memberName = scanner.next();
		System.out.print("닉네임: ");
		String nickName = scanner.next();
		System.out.print("비밀번호: ");
		String password = scanner.next();
		System.out.print("생년월일: ");
		String memberBirth = scanner.next();
		System.out.print("성별  ex)남자 or 여자: ");
		String gender = scanner.next();
		System.out.print("핸드폰번호: ");
		String phoneNum = scanner.next();
		System.out.print("생활지역: ");
		String memberArea = scanner.next();

//	java-> 매퍼 변동 일때, set으로 저장하는게 필요한지 아닌지알려면 일단 지워보고 실행해보기
//	set으로 저장해야하는 이유는 매퍼에서 쿼리를 실행함면 바로 dto로 저장이 되는데 그건 dao에 있는 set저장되는게 필요없어지는거고
//	뷰에서 입력받은건 set이 필요함 적어주지 않으면 부적합한 열유형이 나오게됨
//	siksinDTO.setMemberNum(memberNum);
		siksinDTO.setMemberName(memberName);
		siksinDTO.setNickName(nickName);
		siksinDTO.setPassword(password);
		siksinDTO.setMemberBirth(memberBirth);
		siksinDTO.setGender(gender);
		siksinDTO.setPhoneNum(phoneNum);
		siksinDTO.setMemberArea(memberArea);

//		입력내용을 서비스로 보내주면서 쿼리문이 작성하게 된다.
		siksinServiceImp.siksinInsert(siksinDTO);

		List<SiksinDTO> list = siksinServiceImp.siksinSelectAll();
		for (SiksinDTO siksinDTO2 : list) {
			System.out.println(siksinDTO2);
		}
		scanner.close();
	}
}
