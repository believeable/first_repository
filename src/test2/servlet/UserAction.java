package test2.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import test2.bean.PersonBean;
import test2.service.UserService;
import test2.service.UserServiceImpl;
import util.commons.CommonUtils;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private UserService service=new UserServiceImpl();
	public String queryPersons(){//查询所有人
		List<PersonBean> persons = service.queryPersons();			
		ServletActionContext.getRequest().setAttribute("persons", persons);
		System.out.println(".................");
		return SUCCESS;
	}
	public String deletePersonById(){//删除
		String id = ServletActionContext.getRequest().getParameter("id");
		service.deletePersonById(id);
		return SUCCESS;
	}
	
	public String addPerson(){//增加
		
		Map<String, String[]> map = ServletActionContext.getRequest().getParameterMap();
		PersonBean person = CommonUtils.toBean(map, PersonBean.class);
		service.addPerson(person);
		return SUCCESS;
		
	}
	public String updatePerson(){
		Map<String, String[]> map = ServletActionContext.getRequest().getParameterMap();
		PersonBean person = CommonUtils.toBean(map, PersonBean.class);
		PersonBean person1 = (PersonBean) ServletActionContext.getRequest().getSession().getAttribute("person");
		person.setId(person1.getId());
		service.updatePerson(person);
		return queryPersons();
	}
	public String updatePrepared(){
		Map<String, String[]> map = ServletActionContext.getRequest().getParameterMap();
		PersonBean person = CommonUtils.toBean(map, PersonBean.class);
		System.out.println(person.getId()+person.getName());
		ServletActionContext.getRequest().getSession().setAttribute("person", person);
		return SUCCESS;
		
		
	}
	
	
	
	
	
	
	
	
}
