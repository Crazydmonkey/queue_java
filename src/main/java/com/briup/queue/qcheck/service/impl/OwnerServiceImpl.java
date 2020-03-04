package com.briup.queue.qcheck.service.impl;

import com.briup.queue.qcheck.bean.Owner;
import com.briup.queue.qcheck.bean.OwnerExample;
import com.briup.queue.qcheck.dao.OwnerMapper;
import com.briup.queue.qcheck.service.OwnerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService {
    @Resource
    private OwnerMapper ownerMapper;
    @Override
    public List<Owner> findAll() {
        OwnerExample ownerExample=new OwnerExample();
        return ownerMapper.selectByExample(ownerExample);
    }

    @Override
    public Owner findCustomerByid(Integer id) {
        return ownerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Owner baseUser) throws Exception {
        if(baseUser.getId()!=null){
            ownerMapper.updateByPrimaryKey(baseUser);
        }
        ownerMapper.insert(baseUser);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        ownerMapper.deleteByPrimaryKey(id);

    }
}
