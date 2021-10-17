package com.southwind.repository;

import com.southwind.entity.User;

import java.util.List;

public interface UserRepository {

    /*增*/
    public void save(User user);
    /*删*/
    public void deleteById(long id);
    /*查*/
    public List<User>findAll(int index ,int limit);
    public User findById(long id);
    /*改*/
    public void update(User user);
    /*计数*/
    public int count();


}
