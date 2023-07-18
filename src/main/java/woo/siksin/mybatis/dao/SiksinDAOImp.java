package woo.siksin.mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import woo.siksin.mybatis.dto.SiksinDTO;

@Repository
@RequiredArgsConstructor
public class SiksinDAOImp implements SiksinDAO {

	@Autowired
	private final SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(SiksinDAOImp.class);
	
	//회원전체보기
	@Override
	public List<SiksinDTO> selectAll() {
		
		return sqlSessionTemplate.selectList("woo.siksin.mybatis.dao.selectAll");
	}

	//회원가입
	@Override
	public void insert(SiksinDTO siksinDTO) {
		sqlSessionTemplate.insert("woo.siksin.mybatis.dao.insert", siksinDTO);
	}

	//회원수정
	@Override
	public void update(SiksinDTO siksinDTO) {
		sqlSessionTemplate.update("woo.siksin.mybatis.dao.update", siksinDTO);
	}

	//회원탈퇴
	@Override
	public void delete(int memberNum) {
		sqlSessionTemplate.delete("woo.siksin.mybatis.dao.delete", memberNum);
	}

	//회원상세보기
	@Override
	public SiksinDTO selectDetail(int memberNum) {
		return sqlSessionTemplate.selectOne("woo.siksin.mybatis.dao.selectDetail", memberNum);
	}

	//로그인
	@Override
	public SiksinDTO login(String phoneNum, String password) {
		Map<String, Object> paras= new HashMap<String, Object>();
		paras.put("phoneNum", phoneNum);
		paras.put("password", password);
		logger.info("DAO 로그인 로그 찍어본거 여기는 폰번호 비번 담겨있어야함 ",paras);
		System.out.println(paras + "DAO 로그인 로그 찍어본거 여기는 폰번호 비번 담겨있어야함 ");
		
		
		return sqlSessionTemplate.selectOne("woo.siksin.mybatis.dao.login", paras);
		
	}




}
