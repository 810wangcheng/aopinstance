package com.cy.controller;

import com.cy.service.LogService;
import com.cy.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/log/")
@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("save")
    @ResponseBody
    public JsonResult doSave(){
        logService.save();
        return new JsonResult("保存无参日志成功");
    }

    @RequestMapping("save/{logId}")
    @ResponseBody
    public JsonResult doSave(@PathVariable String logId){
        try {
            logService.save(logId);
        } catch (Exception e) {
            return new JsonResult(e);
        }
        return new JsonResult("保存有参日志成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public JsonResult doUpdate(){
        logService.update();
        return new JsonResult("更新日志");
    }

    @RequestMapping("delete")
    @ResponseBody
    public JsonResult doDelete(){
        logService.delete();
        return new JsonResult("删除日志成功");
    }

    @RequestMapping("find")
    @ResponseBody
    public JsonResult doFind(){
        logService.find();
        return new JsonResult("查询日志成功");
    }
}
