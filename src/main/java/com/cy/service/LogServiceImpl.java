package com.cy.service;

import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Override
    public void save() {
        System.out.println("保存日志");
    }

    @Override
    public int save(String logId) throws Exception {
        System.out.println("保存带参数日志");
        return 1;
    }

    @Override
    public void update() {
        System.out.println("更新日志");
    }

    @Override
    public void delete() {
        System.out.println("删除日志");
    }

    @Override
    public void find() {
        System.out.println("查询日志");
    }
}
