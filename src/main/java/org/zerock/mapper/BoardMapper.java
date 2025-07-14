package org.zerock.mapper;
//component-scan을 통해 자동으로 인식되게 하려면 경로 servlet-context.xml또는 root에 등록해야함.

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

//인터페이스로 sql테이블에서 게시글 목록을 가져오는 역할 
public interface BoardMapper {

	//@Select("select * from tbl_board1 where bno > 0")  BoardMapper.xml에서 쿼리 추가하고 이건은 주석처리. 두번정의되서 하나는 지워야함
	
	//@select는 마이바티스 어노테이션으로 직접 sql문장을 작성해서 메서드에 연결
	//xml없이 인터페이스에서 sql을 바로 작성하는 방식. 
	
	public List<BoardVO> getList(); //메서드임 인터페이스 안이라서 설계만 하고 선언. 
	//getList는 실제 객체를 생성해서 사용하는 코드 
	//실행결과를 List로 타입으로 리턴. 즉 게글 목록 
	
	public void insert(BoardVO board); //데이터 베이스에 저장할거야. 
	
	public void insertSelectKey(BoardVO board); //게시글을 insert하면서 동시에 자동번호(bno)를 미리 가져오기 위해 사용하는 메서드 
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	

}
