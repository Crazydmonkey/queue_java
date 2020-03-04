package com.briup.queue.qcheck.service.impl;

import com.briup.queue.qcheck.bean.Owner;
import com.briup.queue.qcheck.bean.VipUser;
import com.briup.queue.qcheck.bean.VipUserExample;
import com.briup.queue.qcheck.dao.VipUserMapper;
import com.briup.queue.qcheck.service.OwnerService;
import com.briup.queue.qcheck.service.VipUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VipUserServiceImpl implements VipUserService {
    @Resource
    private VipUserMapper vipUserMapper;

    @Override
    public List<VipUser> findAll() {
        VipUserExample vipUserExample=new VipUserExample();
        return vipUserMapper.selectByExample(vipUserExample);
    }

    @Override
    public VipUser findCustomerByid(Integer id) {
        return vipUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(VipUser baseUser) throws Exception {
        if(baseUser.getId()!=null){
            vipUserMapper.updateByPrimaryKey(baseUser);
        }
        vipUserMapper.insert(baseUser);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        vipUserMapper.deleteByPrimaryKey(id);
    }
}
