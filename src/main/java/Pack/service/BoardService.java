package Pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.dao.BoardDao;
import Pack.dto.BoardDTO;

@Service
public class BoardService {
	@Autowired
	BoardDao dao;
	
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = dao.boardList();
		return list;
	}
	
	public void newBoard(BoardDTO dto) {
		dao.newBoard(dto);
	}
	
	public BoardDTO boardDetail(int boardNo) {
		return dao.boardDetail(boardNo);
	}
	
	public void boardUpdate(BoardDTO dto) {
		dao.boardUpdate(dto);
	}
	
	public void boardDelete(int boardNo) {
		dao.boardDelete(boardNo);
	}
}
