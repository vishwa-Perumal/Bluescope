package com.TestDBs1.Services;

import com.TestDBs1.DAO.DAOInterface1;
import com.TestDBs1.DAO.DAOInterface1Imp;
import com.TestDBs1.DAO.DTOfile1;

public class StudentServiceImpl implements StudentService {

    private DAOInterface1 dao = new DAOInterface1Imp();

    @Override
    public DTOfile1 getStudentById(int id) {
        return dao.get(id);
    }
    @Override
    public void createStudent(DTOfile1 student) {
    	dao.insert(student);
    }
    @Override
    public void updateStudent(DTOfile1 student) {
    	dao.update(student);
    }
    @Override
    public void deleteStudent(int id) {
    	dao.delete(id);
    }
}

