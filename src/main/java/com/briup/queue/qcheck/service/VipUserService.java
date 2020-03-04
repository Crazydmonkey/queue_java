package com.briup.queue.qcheck.service;

import com.briup.queue.qcheck.bean.VipUser;

import java.util.List;

public interface VipUserService {
    List<VipUser> findAll();

    VipUser findCustomerByid(Integer id);


    void saveOrUpdate(VipUser baseUser) throws Exception;

    void deleteById(Integer id) throws Exception;
}
