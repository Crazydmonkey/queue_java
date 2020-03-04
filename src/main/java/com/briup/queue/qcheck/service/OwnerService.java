package com.briup.queue.qcheck.service;

import com.briup.queue.qcheck.bean.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> findAll();

    Owner findCustomerByid(Integer id);


    void saveOrUpdate(Owner baseUser) throws Exception;

    void deleteById(Integer id) throws Exception;
}
