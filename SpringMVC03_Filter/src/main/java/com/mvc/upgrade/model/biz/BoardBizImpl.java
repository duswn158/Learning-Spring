package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<BoardDto> selectList() {
		return boardDao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {
		return boardDao.selectOne(myno);
	}

	@Override
	public int insert(BoardDto dto) {
		return boardDao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return boardDao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return boardDao.delete(myno);
	}

}
