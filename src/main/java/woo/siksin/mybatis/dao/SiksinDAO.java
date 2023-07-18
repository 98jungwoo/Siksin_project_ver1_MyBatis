package woo.siksin.mybatis.dao;

import java.util.List;
import woo.siksin.mybatis.dto.SiksinDTO;

public interface SiksinDAO {

	public List<SiksinDTO> selectAll();

	public void insert(SiksinDTO siksinDTO);

	public void update(SiksinDTO siksinDTO);

	public void delete(int memberNum);

	public SiksinDTO selectDetail(int memberNum);
	
	public SiksinDTO login(String phoneNum, String password);

}
