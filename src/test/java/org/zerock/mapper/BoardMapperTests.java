package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
@Log4j2

//BoardMapper 인터페이스 구현체를 주입받아서 진행 
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper; //setMapper() 메서드 만들어주고 Mapper자동주입 
	
	@Test
	public void testGetList() {
		
		mapper.getList().forEach( board -> log.info(board));
	//list().forEach(변수명(입력값) ->실행문(출력할 행동)  ) 람다식 함수. 변수를 그자리에서 넣고 선언.
	//board를 BoardVo로 인식하는 이유는 getList()가 List<BoardVO>에서 와서 아는것임 이것이 제네릭타입	
	}
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO(); //새 게시글 객체 생성 
		board.setTitle("새로 작성하는 글");  //제목 
		board.setContent("새로 작성하는 내용"); //내용입력 
		board.setWriter("newbie"); //작성자 입력 
		 
		mapper.insert(board); //db에 저장.
		log.info(board); 
		
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		mapper.insertSelectKey(board);
		log.info(board);
			
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
	
		log.info("삭제 숫자" + mapper.delete(3L));
	}
	
	
	@Test
	public void testUpdate() { // tsetUpdate 메서드 실행. 
		BoardVO board = new BoardVO(); //BoardVO 타입의 게시글 객체 생성. 
		
		board.setBno(5L); //수정할 게시글 번호 5번 지정.
		board.setTitle("이제목은 수정처리 하였습니다."); // 수정할 제목 설정 
		board.setContent("이 내용은 수정처리 하였습니다"); //수정할 내용 설정 
		board.setWriter("user00"); // 수정할 작성자 이름 설정 
		
		int count = mapper.update(board); 
		//위에서 셋팅한 BoardVO 객체를 mapper에 전달 해서 update()실행 
		// 내부적으로 sql 실행되어 , db에서 5번째 게시글 제목,내용,작성저 수정 
		//update() 메서드는 수정된 행 수를 int형으로 반환 

		
		log.info("수정된 갯수 : " + count);
		
	}
	
}
