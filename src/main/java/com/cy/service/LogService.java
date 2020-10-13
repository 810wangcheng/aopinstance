package com.cy.service;

public interface LogService {

    void save();

    int save(String logId) throws Exception;

    void update();

    void delete();

    void find();
}
