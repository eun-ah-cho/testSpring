package org.zerock.service;

import java.util.List;

//컨트롤러가 직접 DB에 접근하지 않게 하기 위한 중간 처리 역할.
//무엇을 할수 있는지 정의한 설계도이며 각각의 메서드를 여기서 추상화로 지정하는것임.
import org.zerock.domain.BoardVO;

public interface BoardService {  // 서비스계층 인터페이스(설계서) 역할을 함. 

	public void register(BoardVO board); //게시판 등록용 메서드 
	 
	public BoardVO get(Long bno); //게시글 상세보기 get이라는 메서드명으로 bno값을 받아서 VO에 리턴
	
	public boolean modify(BoardVO board); //수정할 게시글 정보를 BoardVO에 담아 전달.
	public boolean remove(Long bno);
	public List<BoardVO> getList(); //게시글 목록 조회 기능 .실행결과를 List타입으로 리턴
	
	
	
	
}
