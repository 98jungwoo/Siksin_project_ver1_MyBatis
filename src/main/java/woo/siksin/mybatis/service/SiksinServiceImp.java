package woo.siksin.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import woo.siksin.mybatis.dao.SiksinDAO;
import woo.siksin.mybatis.dto.SiksinDTO;

@Service
public class SiksinServiceImp implements SiksinService {
	
	private final SiksinDAO siksinDAO;
	
	@Autowired
	public SiksinServiceImp(SiksinDAO siksinDAO) {
		this.siksinDAO = siksinDAO;
	}

	//회원 전체보기
	@Override
	public List<SiksinDTO> siksinSelectAll() {
		return siksinDAO.selectAll();
	}

	//회원 가입
	@Override
	public void siksinInsert(SiksinDTO siksinDTO) {
		siksinDAO.insert(siksinDTO);
	}

	//회원 수정
	@Override
	public void siksinUpdate(SiksinDTO siksinDTO) {
		siksinDAO.update(siksinDTO);
	}

	//회원 탈퇴
	@Override
	public void siksinDelete(int memberNum) {
		siksinDAO.delete(memberNum);
	}

	//회원 상세보기
	@Override
	public SiksinDTO siksinSelectDetail(int memberNum) {
		return siksinDAO.selectDetail(memberNum);
	}

	//로그인
	@Override
	public SiksinDTO siksinlogin(String phoneNum, String password) {
		return siksinDAO.login(phoneNum, password);
	}



}
