package model.services;

import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentServices {
	private DepartmentDao dao =  DaoFactory.createDepartmentDao();
	
	public List<Department> findall(){		
		return dao.findAll();
		
	}

}
