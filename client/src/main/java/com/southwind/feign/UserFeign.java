package com.southwind.feign;

import com.southwind.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {

    /*增*/
    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    /*改*/
    @PutMapping("/user/update")
    public void update(@RequestBody User user);

    /*删*/
    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id);

    /*查*/
    @GetMapping("/user/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index")int index , @PathVariable("limit")int limit);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id")long id);

    @GetMapping("/user/count")
    public int count();

}
