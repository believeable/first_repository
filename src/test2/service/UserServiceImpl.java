package test2.service;

import java.util.List;

import test2.bean.PersonBean;
import test2.dao.UserDao;

public class UserServiceImpl implements UserService{
	private UserDao dao=new UserDao();
	public List<PersonBean> queryPersons() {
		return dao.queryPersons();
		// TODO Auto-generated method stub
	}
	public void deletePersonById(String id) {
		// TODO Auto-generated method stub
		dao.deletePersonById(id);
	}
	public void addPerson(PersonBean person) {
		// TODO Auto-generated method stub
		dao.addperson(person);
	}
	public void updatePerson(PersonBean person) {
		// TODO Auto-generated method stub
		dao.updatePerson(person);
	}

}
