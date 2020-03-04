package com.briup.queue.qcheck.service;

import com.briup.queue.qcheck.bean.MoneyUser;

import java.util.List;

public interface MoneyUserService {

    List<MoneyUser> findAll();

    MoneyUser findCustomerByid(Integer id);


    void saveOrUpdate(MoneyUser baseUser) throws Exception;

    void deleteById(Integer id) throws Exception;

}
