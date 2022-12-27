package Pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.dao.BoardDao;
import Pack.dto.BoardDTO;
import Pack.dto.CommentDTO;

@Service
public class BoardService {
	@Autowired
	BoardDao dao;
	
	public List<BoardDTO> boardList() {
		return dao.boardList();
	}
	
	public void newBoard(BoardDTO dto) {
		dao.newBoard(dto);
	}
	
	public void boardUpdate(BoardDTO dto) {
		dao.boardUpdate(dto);
	}
	
	public void boardDelete(int boardNo) {
		dao.boardDelete(boardNo);
	}
	
	public void newComment(CommentDTO dto) {
		dao.newComment(dto);
	}
	
	public List<CommentDTO> commentList(int boardNo) {
		return dao.commentList(boardNo);
	}
	
	public void commentDelete(int commentNo) {
		dao.commentDelete(commentNo);
	}
}
