package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller //이건 컨트롤러다~알려주는 어노테이션
@Log4j2  //sysout같은것 로그찍기 
@RequestMapping("/board/*")  // /board/로 시작하는 모든 요청을 처리하겠다 
@AllArgsConstructor
public class BoardController {

	private BoardService service; //BoardControllersms BoardService에 대해 의존적이므로 @AllArgsConstructor를 이용해서 생성자을 만들고 자동주입 
	
	
				@GetMapping("/list")  //@RequestMapping(value="/list", method=RequestMethod.GET) 의 축약형
				public void list(Model model) {
					log.info("list");
					
					model.addAttribute("list", service.getList()); //model : 데이터를 담는 바구니, addAttribute("jsp에서 꺼낼때 쓸이름" , 값.실제넣을데이터) 
					///서비스에서 게시판목록을 가져와서 jsp에 있는 list라는 이름으로 데이터 model에 저장함 
					//컨트롤러에서 리턴타입이 void이면 경로와 같은 jsp를 찾는다.
				}
				
				@GetMapping("/register")
				public String register() {
					// jsp페이지 전달용 
					return "/board/register";
						}
				
				
				@PostMapping("/register") //사용자가 글쓰기폼에 글작성후 등록버튼 눌렀을때 여기로옴 
				public String register(BoardVO board, RedirectAttributes rttr) {
					
					log.info("register:" + board);
					service.register(board); //게시글을 db에 등록함 db에 insert됨 
					
					rttr.addAttribute("result", board.getBno()); // /board/list?result=102
					//등록된 글번호를 result로 담아서 다음 화면에 알람 표시 
					return "redirect:/board/list";//성공시 다음 페이지
					
					
				}
				
				

				@GetMapping({"/get","/modify"})  //http://192.168.111.104:80/board/get?bno=5 (모든경로) 
				public void get(@RequestParam("bno") Long bno, Model model) {
					//url을 통해서 넘어온 bno=5문자열을 long 타입으로 받는다. /model 객체에 넣는다.
					
					//void 리턴타입에 url이 2개인경우 다 반응한다. 
					//get -> get.jsp
					//modify-> modify.jsp
					
					log.info("BoardController.get 메서드 실행....");
					
					model.addAttribute("board", service.get(bno));
					//서비스에서 매퍼를 다녀와 객체를 가져온 것을 모델객체에 넣는다.
					//프론트에서는 ${board.bno} ${board.title} ${board.content} 출력이가능하다.
					
				}
				@PostMapping("/modify") //http://192.168.111.104:80/board/modify
				public String modify(BoardVO board, RedirectAttributes rttr) {
					log.info("BoardController.get 메서드실행..");
					if(service.modify(board)) {
						rttr.addAttribute("result", "success");
						//성공시 프론트에 result라는 이름으로 success값을 1회용으로 전송한다.
					}
					return "redirect:/board/list";
				}
				

				@PostMapping("/remove")
				public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
					log.info("BoardController.remove 메서드 실행...");
					
					if(service.remove(bno)) {
						//서비스에 다녀온 결과가 true면 아래 실행문을 실행
						rttr.addFlashAttribute("result", "success");
						
					}
					return "redirect:/board/list";
				}
	
}
