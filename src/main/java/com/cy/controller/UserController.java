package com.cy.controller;

import com.cy.service.UserService;
import com.cy.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user/")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("save")
    @ResponseBody
    public JsonResult doSave(){
        userService.save();
        return new JsonResult("保存成功");
    }

    @RequestMapping("save/{userId}")
    @ResponseBody
    public JsonResult doSave(@PathVariable String userId){
        try {
            userService.save(userId);
        } catch (Exception e) {
            return new JsonResult(e);
        }
        return new JsonResult("带参用户保存成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public JsonResult doUpdate(){
        userService.update();
        return new JsonResult("更新用户成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public JsonResult doDelete(){
        userService.delete();
        return new JsonResult("删除用户成功");
    }

    @RequestMapping("find")
    public JsonResult doFind(){
        userService.find();
        return new JsonResult("查询用户成功");
    }

}
