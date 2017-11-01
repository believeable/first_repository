package test2.service;

import java.util.List;

import test2.bean.PersonBean;

public interface UserService {
	public List<PersonBean> queryPersons();
	public void deletePersonById(String id);
	public void addPerson(PersonBean person);

	public void updatePerson(PersonBean person);
}
