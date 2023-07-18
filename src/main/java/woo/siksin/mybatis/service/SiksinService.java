package woo.siksin.mybatis.service;

import java.util.List;

import woo.siksin.mybatis.dto.SiksinDTO;

public interface SiksinService {
	
	List<SiksinDTO> siksinSelectAll();

	void siksinInsert(SiksinDTO siksinDTO);

	void siksinUpdate(SiksinDTO siksinDTO);

	void siksinDelete(int memberNum);

	SiksinDTO siksinSelectDetail(int memberNum);
	
	SiksinDTO siksinlogin(String phoneNum, String password);

}
