/**
 * Copyright (C), 2015-2019, 申雪供应链有限公司
 * FileName: WebController
 * Author:   Administrator
 * Date:     2019-03-13 14:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sto.springbootdemo.web;/**
 * Created by Administrator on 2019-03-13.
 */

import com.sto.springbootdemo.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019-03-13
 * @since 1.0.0
 */
@RestController //@RestController 注解相当于 @ResponseBody ＋ @Controller 合在一起的作用
public class WebController {

    @RequestMapping(name = "/getUser", method = RequestMethod.POST)
    public User getUser(){
        User user = new User("小米", 12, "123456");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        List<User> users=new ArrayList<User>();
        User user = new User("小米", 12, "123456");
        User user1 = new User("黄金圣斗士", 212, "vvvs");
        User user2 = new User("哈佛", 89, "水电费规划局");
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }

    // @RequestMapping(name = "/user", method = RequestMethod.POST)
    // public User getUserByUser(User user){
    //     System.out.println("user :"+user);
    //     User user1 = new User("小米", 12, "123456");
    //     return user1;
    // }

      @RequestMapping(value = "get/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name){//使用 URL 进行传参
        System.out.println("name :"+name);
        User user1 = new User("小米", 12, "123456");
        return user1;
    }

    @RequestMapping("/saveUser")
    //BindingResult 参数校验的结果会存储在此对象中，可以根据属性判断是否校验通过，校验不通过可以将错误信息打印出来。
    public void saveUser(@Valid User user, BindingResult result){ //@Valid 参数前面添加 @Valid 注解，代表此对象使用了参数校验
        System.out.println("user :"+user);
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error.getCode()+ " - " +error.getDefaultMessage());
            }
        }

    }

}
