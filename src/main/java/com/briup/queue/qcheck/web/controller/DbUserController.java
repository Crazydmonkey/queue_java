package com.briup.queue.qcheck.web.controller;

import com.briup.queue.qcheck.bean.DbUser;
import com.briup.queue.qcheck.service.DbUserService;
import com.briup.queue.qcheck.utils.Message;
import com.briup.queue.qcheck.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(description = "对公业务相关接口")
@Validated
@RestController
@RequestMapping("/db")
public class DbUserController {
    @Autowired
    private DbUserService dbUserService;

    @GetMapping("findByDbUserId")
    @ApiOperation("通过对公用户ID查询")
    public Message findByDbUserId(@NotNull @RequestParam("id") Integer id){

        return MessageUtil.success("success",dbUserService.findCustomerByid(id));
    }
    @GetMapping("findAll")
    @ApiOperation("查询对公人员信息")
    public Message findAll(){
        List<DbUser> list = dbUserService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新对公用户信息")
    public Message saveOrUpdate(@Valid @ModelAttribute DbUser dbUser) throws Exception{
        dbUserService.saveOrUpdate(dbUser);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除对公信息")
    public Message deleteById(@NotNull @RequestParam("id") Integer id) throws Exception{
        dbUserService.deleteById(id);
        return MessageUtil.success("删除成功");
    }


}
