package com.TestDBs1.Services;

import com.TestDBs1.DAO.DTOfile1;

public interface StudentService {

    DTOfile1 getStudentById(int id);

    void createStudent(DTOfile1 student);

    void updateStudent(DTOfile1 student);

    void deleteStudent(int id);
}

