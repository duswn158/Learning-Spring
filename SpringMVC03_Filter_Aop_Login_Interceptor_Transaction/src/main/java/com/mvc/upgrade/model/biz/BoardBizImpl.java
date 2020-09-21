package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

		BoardDto dto = boardDao.selectOne(myno);
		
		
		// BoardDto dto = null 일떄 아래 구문 가능
		// BoardDto dto = new BoardDto(); 일때는 객체가 생성되어 null이 무조건 아니기때문에 아래 구문 불가
		// 객체 필드안에 값이 없어서 null인거지 객체가 생성되어 있기때문에 null이 될 수 없음
		if (dto != null) {
			// 해당 myno 번호에 해당하는 row가 존재한다면.
		}
		
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
	
	// 트랜젝션으로 묵었을때 하나라도 에러나 나면 모두 될수 없는데 즉 ALL or Notthing 인데.
	// insert는 되고 아래 test.length는 에러나는 현상 발생중
	// 따라서 트랜젝션으로 묶어주려고 함
	@Transactional
	@Override
	public String transactionTest() {
		
		boardDao.insert(new BoardDto(0, "transaction", "test", "insert", null));
		
		// return null 이기 때문에. 아래서 에러발생
		String test = boardDao.test();
		
		// NullPointerException Error 발생!
		test.length();
		
		return null;
	}

}
