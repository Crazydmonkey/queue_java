package com.briup.queue.qcheck.service.impl;

import com.briup.queue.qcheck.bean.MoneyUser;
import com.briup.queue.qcheck.bean.MoneyUserExample;
import com.briup.queue.qcheck.bean.Owner;
import com.briup.queue.qcheck.dao.MoneyUserMapper;
import com.briup.queue.qcheck.service.MoneyUserService;
import com.briup.queue.qcheck.service.OwnerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MoneyUserServiceImpl implements MoneyUserService {
    @Resource
    private MoneyUserMapper moneyUserMapper;
    @Override
    public List<MoneyUser> findAll() {
        MoneyUserExample moneyUserExample=new MoneyUserExample();

        return moneyUserMapper.selectByExample(moneyUserExample);
    }

    @Override
    public MoneyUser findCustomerByid(Integer id) {
        return moneyUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(MoneyUser baseUser) throws Exception {
        if(baseUser.getId()!=null){
            moneyUserMapper.updateByPrimaryKey(baseUser);
        }
        moneyUserMapper.insert(baseUser);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        moneyUserMapper.deleteByPrimaryKey(id);
    }
}
