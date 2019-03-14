/**
 * Copyright (C), 2015-2019, 申雪供应链有限公司
 * FileName: User
 * Author:   Administrator
 * Date:     2019-03-13 14:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sto.springbootdemo.model;/**
 * Created by Administrator on 2019-03-13.
 */

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019-03-13
 * @since 1.0.0
 */
public class User {
    @NotEmpty(message = "姓名不为空")
    private String name;
    @Max(value = 100, message = "年龄最大100岁")
    @Min(value = 18, message = "必须年满18岁")
    private int age;
    @NotEmpty(message = "密码不为空")
    @Length(min = 6, message = "密码长度不少于6位")
    private String pass;

    public User() {
    }

    public User(String name, int age, String pass) {
        this.name = name;
        this.age = age;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pass='" + pass + '\'' +
                '}';
    }
}
