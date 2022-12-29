package Pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Pack.dto.BoardDTO;
import Pack.dto.CommentDTO;
import Pack.service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	@Autowired
	BoardService service;
	
	@GetMapping("/boardList")
	public Object boardList() {
		return service.boardList();
	}
	
	@PostMapping("/newBoard")
	public void newBoard(@RequestBody BoardDTO dto) {
		service.newBoard(dto);
	}
	
	@GetMapping("/boardDetail/{boardNo}")
	public Object boardDetail(@PathVariable int boardNo) {
		return service.boardDetail(boardNo);
	}
	
	@PostMapping("/deleteBoard/{boardNo}")
	public void deleteBoard(@PathVariable int boardNo) {
		service.boardDelete(boardNo);
	}
	
	@PostMapping("/updateBoard")
	public void updateBoardPost(@RequestBody BoardDTO dto) {
		service.boardUpdate(dto);		
	}
	
	@PostMapping("/newComment")
	public void newComment(@RequestBody CommentDTO dto) {
		service.newComment(dto);
	}
	
	@GetMapping("/commentList/{boardNo}")
	public Object commentList(@PathVariable int boardNo) {
		System.out.println("test" + boardNo);
		return service.commentList(boardNo);
	}
	
	@PostMapping("/commentDelete/{commentNo}")
	public void commentDelete(@PathVariable int commentNo) {
		System.out.println("제발 되라 "+commentNo);
		service.commentDelete(commentNo);
	}
	
}
