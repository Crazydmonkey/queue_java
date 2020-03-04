package com.briup.queue.qcheck.web.controller;

import com.briup.queue.qcheck.bean.DbUser;
import com.briup.queue.qcheck.bean.VipUser;
import com.briup.queue.qcheck.service.DbUserService;
import com.briup.queue.qcheck.service.VipUserService;
import com.briup.queue.qcheck.utils.Message;
import com.briup.queue.qcheck.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(description = "VIP业务相关接口")
@Validated
@RestController
@RequestMapping("/vip")
public class VipUserController {
    @Autowired
    private VipUserService vipUserService;

    @GetMapping("findByVipUserId")
    @ApiOperation("通过Vip用户ID查询")
    public Message findByVipUserId(@NotNull @RequestParam("id") Integer id){

        return MessageUtil.success("success",vipUserService.findCustomerByid(id));
    }
    @GetMapping("findAll")
    @ApiOperation("查询Vip人员信息")
    public Message findAll(){
        List<VipUser> list = vipUserService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新Vip用户信息")
    public Message saveOrUpdate(@Valid @ModelAttribute VipUser dbUser) throws Exception{
        vipUserService.saveOrUpdate(dbUser);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除Vip信息")
    public Message deleteById(@NotNull @RequestParam("id") Integer id) throws Exception{
        vipUserService.deleteById(id);
        return MessageUtil.success("删除成功");
    }


}
