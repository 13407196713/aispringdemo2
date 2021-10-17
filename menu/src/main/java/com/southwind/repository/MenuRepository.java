package com.southwind.repository;

import com.southwind.entity.Menu;

import java.util.List;

public interface MenuRepository {
    /*增*/
    public void save(Menu menu);

    /*删*/
    public void deleteById(long id);

    /*改*/
    public void update(Menu menu);

    /*查*/
    public List<Menu> findAll(int index , int limit);

    public Menu findById(long id);

    /*统计 计数*/
    public int count();

}
