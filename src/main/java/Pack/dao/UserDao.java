package Pack.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Pack.dao.util.Delegate;
import Pack.dao.util.JdbcTemplate;
import Pack.dto.UserDTO;

@Repository
public class UserDao {
	public boolean signUp(UserDTO dto) {
		Object result = JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.insert("signUp", dto);
			}
		});
		
		return (result != null) ? true : false;		
	}
	
	public UserDTO login(UserDTO dto) {
		UserDTO user = (UserDTO)JdbcTemplate.getInstance().proxy(new Delegate() {
			
			@Override
			public Object delegate(SqlSession session) {
				return session.selectOne("login", dto.getId());
			}
		});
		
		return user;
	}
}
