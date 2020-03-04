package com.briup.queue.qcheck.service;

import com.briup.queue.qcheck.bean.DbUser;


import java.util.List;

public interface DbUserService {
    List<DbUser> findAll();

    DbUser findCustomerByid(Integer id);


    void saveOrUpdate(DbUser baseUser) throws Exception;

    void deleteById(Integer id) throws Exception;

}
