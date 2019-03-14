/**
 * Copyright (C), 2015-2019, 申雪供应链有限公司
 * FileName: HiController
 * Author:   Administrator
 * Date:     2019-03-13 13:05
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

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019-03-13
 * @since 1.0.0
 */
@Controller
public class HiController {

    @RequestMapping("/hi")
    public String hi(){
        return "hello.html";
    }

}
