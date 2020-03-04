package com.briup.queue.qcheck.web.controller;

import com.briup.queue.qcheck.bean.DbUser;
import com.briup.queue.qcheck.bean.Owner;
import com.briup.queue.qcheck.service.DbUserService;
import com.briup.queue.qcheck.service.OwnerService;
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

@Api(description = "个人业务相关接口")
@Validated
@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("findByOwnerUserId")
    @ApiOperation("通过个人业务用户ID查询")
    public Message findByOwnerUserId(@NotNull @RequestParam("id") Integer id){

        return MessageUtil.success("success",ownerService.findCustomerByid(id));
    }
    @GetMapping("findAll")
    @ApiOperation("查询个人人员信息")
    public Message findAll(){
        List<Owner> list = ownerService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新个人业务用户信息")
    public Message saveOrUpdate(@Valid @ModelAttribute Owner dbUser) throws Exception{
        ownerService.saveOrUpdate(dbUser);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除个人业务用户信息")
    public Message deleteById(@NotNull @RequestParam("id") Integer id) throws Exception{
        ownerService.deleteById(id);
        return MessageUtil.success("删除成功");
    }


}
