package test2.dao;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import test2.bean.PersonBean;
import util.jdbc.TxQueryRunner;

public class UserDao {
private TxQueryRunner runner=new TxQueryRunner();


	public List<PersonBean> queryPersons() {
		List list=null;
		String sql="select * from persons";
		try {
			list = runner.query(sql, new BeanListHandler<PersonBean>(PersonBean.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}
	
	public void addperson(PersonBean person){
		
		String sql="insert into persons (name, age, gender,email) values(?,?,?,?)";
		String name=null;
		try {
			name = new String(person.getName().getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Object[] params={name,person.getAge(),person.getGender(),person.getEmail()};
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletePersonById(String id) {
		// TODO Auto-generated method stub
		String sql="delete from persons where id = ?";
		Object[] param={id};
		try {
			runner.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updatePerson(PersonBean person) {
		// TODO Auto-generated method stub
		String sql="update persons set name = ?,age = ?, gender = ?,email = ? where id = ?";
		String name=null;
		try {
			name = new String(person.getName().getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Object[] params={name,person.getAge(),person.getGender(),person.getEmail(),person.getId()};
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
