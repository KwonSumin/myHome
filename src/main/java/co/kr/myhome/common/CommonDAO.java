package co.kr.myhome.common;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public Connection getConnection() throws Exception{
		return sqlSessionTemplate.getConnection();
	}
	public void close() throws Exception {
		sqlSessionTemplate.close();
	}
	public Object selectOne(String namespace,Object param) throws Exception{
		return sqlSessionTemplate.selectOne(namespace, param);
	}
	public Object selectOne(String namespace) throws Exception{
		return sqlSessionTemplate.selectOne(namespace);
	}
	public List selectList(String namespace,Object param) throws Exception{
		return sqlSessionTemplate.selectList(namespace, param);
	}
	public List selectList(String namespace) throws Exception{
		return sqlSessionTemplate.selectList(namespace);
	}
	public Object insert(String namespace) throws Exception{
		return sqlSessionTemplate.insert(namespace);
	}
	public Object insert(String namespace,Object param) throws Exception{
		return sqlSessionTemplate.insert(namespace,param);
	}
	public Object update(String namespace) throws Exception{
		return sqlSessionTemplate.update(namespace);
	}
	public Object update(String namespace,Object param) throws Exception{
		return sqlSessionTemplate.update(namespace,param);
	}
}
