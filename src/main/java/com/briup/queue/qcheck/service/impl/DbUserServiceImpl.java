package com.briup.queue.qcheck.service.impl;

import com.briup.queue.qcheck.bean.DbUser;
import com.briup.queue.qcheck.bean.DbUserExample;
import com.briup.queue.qcheck.bean.Owner;
import com.briup.queue.qcheck.dao.DbUserMapper;
import com.briup.queue.qcheck.service.DbUserService;
import com.briup.queue.qcheck.service.OwnerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DbUserServiceImpl implements DbUserService {
    @Resource
    private DbUserMapper dbUserMapper;

    @Override
    public List<DbUser> findAll() {
        DbUserExample dbUserExample=new DbUserExample();
        return dbUserMapper.selectByExample(dbUserExample);
    }

    @Override
    public DbUser findCustomerByid(Integer id) {
        return dbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(DbUser baseUser) throws Exception {
        if(baseUser.getId()!=null){
            dbUserMapper.updateByPrimaryKey(baseUser);
        }
        dbUserMapper.insert(baseUser);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        dbUserMapper.deleteByPrimaryKey(id);
    }
}
