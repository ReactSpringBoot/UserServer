package Pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Pack.dto.BoardDTO;
import Pack.service.BoardService;

@RestController
public class BoardController {
	@Autowired
	BoardService service;
	
	@GetMapping("/boardList")
	public Object boardList() {
		List<BoardDTO> list = service.boardList();
		return list;
	}
	
	@PostMapping("newBoard")
	public String newBoardPost(@RequestBody BoardDTO dto) {
		System.out.println(dto.getTitle());
		System.out.println(dto.getUserNo());
		System.out.println(dto.getContents());
		service.newBoard(dto);
		return "aa";
	}
	@PostMapping("deleteBoard/{boardNo}")
	public String deleteBoard(@PathVariable int boardNo) {
		System.out.println(boardNo);
		service.boardDelete(boardNo);
		return "aa";
	}
	
	@PostMapping("updateBoard")
	public String updateBoardPost(@RequestBody BoardDTO dto) {
		service.boardUpdate(dto);
		return "aa";
	}
	
	
}
