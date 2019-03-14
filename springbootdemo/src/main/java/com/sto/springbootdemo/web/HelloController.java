/**
 * Copyright (C), 2015-2019, 申雪供应链有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2019-03-13 13:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sto.springbootdemo.web;/**
 * Created by Administrator on 2019-03-13.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019-03-13
 * @since 1.0.0
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        return "<h3 >hello world  ,"+name +"</h3>";
    }


}
