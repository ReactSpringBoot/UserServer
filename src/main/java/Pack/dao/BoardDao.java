package Pack.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Pack.dao.util.Delegate;
import Pack.dao.util.JdbcTemplate;
import Pack.dto.BoardDTO;
import Pack.dto.CommentDTO;


@Repository
public class BoardDao {
	
	public List<BoardDTO> boardList() {
		@SuppressWarnings("unchecked")
		List<BoardDTO> list = (List<BoardDTO>)JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.selectList("boardList");
			}
		});
		
		return list;
	}
	
	public void newBoard(BoardDTO dto) {
		JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.insert("newBoard", dto);
			}
		});
	}
	
	public BoardDTO boardDetail(int boardNo) {
		BoardDTO board = (BoardDTO)JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.selectOne("boardDetail", boardNo);
			}
		});
		
		return board;
	}
	
	public void boardDelete(int boardNo) {
		JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.insert("boardDelete", boardNo);
			}
		});
	}
	
	public void boardUpdate(BoardDTO dto) {
		JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.insert("boardUpdate", dto);
			}
		});
	}
	
	public void newComment(CommentDTO dto) {
		JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.insert("newComment", dto);
			}
		});
	}
	
	public List<CommentDTO> commentList(int boardNo) {
		@SuppressWarnings("unchecked")
		List<CommentDTO> list = (List<CommentDTO>)JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.selectList("commentList", boardNo);
			}
		});
		
		return list;
	}
	
	public void commentDelete(int commentNo) {
JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.delete("commentDelete", commentNo);
			}
		});
	}
}
