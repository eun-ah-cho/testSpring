package org.zerock.service;

import java.util.List;

import org.zerock.service.BoardService;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	//조원이 실행문을 생성하는 용도로 활용 필수 : implements BoardService(구현클래스)	
	
	
	
	private BoardMapper mapper; //db 쿼리용 객체 (CRUD)

	
	@Override
	public void register(BoardVO board) {
		//객체가 넘어오면 메퍼를 이용하여 데이터베이스에 등록함. 
		log.info("BoardServiceImpl.register메서드 실행....");
		
		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력테스트....");
		mapper.getList();
		
	}

	@Override
	public BoardVO get(Long bno) {
		//  게시물의 번호가 들어오면 메퍼의 select문이 
		log.info("BoardServiceImpl.get메서드 실행...");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// 프론트에서 객체가 넘어오면 매퍼를 통해서 update
		log.info("BoardServiceImpl.modify 메서드");
		return mapper.update(board) ==1;
	}

	@Override
	public boolean remove(Long bno) {
		// 프론트에서 번호가 넘어오면 매퍼를 통해서 delete 쿼리가 실행됨. 
		log.info("BoardServiceImpl.remove메서드 실행....");
		return mapper.delete(bno) ==1;
	}

	@Override
	public List<BoardVO> getList() {
		//getList() 메서드가 호출되면 매퍼에 getList2()를 호출한다.
		log.info("BoardServiceImp.gerList 메서드 실행...");
		
		return mapper.getList();
	}
 
}
