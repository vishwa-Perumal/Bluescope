package com.TestDBs1.DAO;

import java.util.List;

public interface DAOInterface1 {
    DTOfile1 get(int id);        // READ
    int insert(DTOfile1 dto);    // CREATE
    int update(DTOfile1 dto);    // UPDATE
    int delete(int id);          // DELETE
}

