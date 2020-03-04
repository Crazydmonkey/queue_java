package com.briup.queue.qcheck.web.controller;

import com.briup.queue.qcheck.bean.DbUser;
import com.briup.queue.qcheck.bean.MoneyUser;
import com.briup.queue.qcheck.service.DbUserService;
import com.briup.queue.qcheck.service.MoneyUserService;
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

@Api(description = "理财业务相关接口")
@Validated
@RestController
@RequestMapping("/money")
public class MoneyUserController {
    @Autowired
    private MoneyUserService moneyUserService;

    @GetMapping("findByMoneyUserId")
    @ApiOperation("通过理财用户ID查询")
    public Message findByMoneyUserId(@NotNull @RequestParam("id") Integer id){

        return MessageUtil.success("success",moneyUserService.findCustomerByid(id));
    }
    @GetMapping("findAll")
    @ApiOperation("查询理财人员信息")
    public Message findAll(){
        List<MoneyUser> list = moneyUserService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新理财用户信息")
    public Message saveOrUpdate(@Valid @ModelAttribute MoneyUser dbUser) throws Exception{
        moneyUserService.saveOrUpdate(dbUser);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除理财用户信息")
    public Message deleteById(@NotNull @RequestParam("id") Integer id) throws Exception{
        moneyUserService.deleteById(id);
        return MessageUtil.success("删除成功");
    }


}
