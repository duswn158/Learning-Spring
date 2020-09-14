package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz {
	
	@Autowired
	private BoardDao dao;
	
	public List<BoardDto> selectList() {
		return dao.selectList();
	}
	
	public BoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	public int delete(int myno) {
		return dao.delete(myno);
	}

}
