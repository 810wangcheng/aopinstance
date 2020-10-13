package com.cy.service;

public interface UserService {

    void save();

    void save(String userId) throws Exception;

    void update();

    void delete();

    void find();
}
