/**
 * Copyright (C), 2015-2019, 申雪供应链有限公司
 * FileName: HelloTest
 * Author:   Administrator
 * Date:     2019-03-13 13:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sto.springbootdemo;/**
 * Created by Administrator on 2019-03-13.
 */

import com.sto.springbootdemo.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//导包需要加入以下代码: 因为 print() 等方法都是 MockMvcResultHandlers 类的静态方法。
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019-03-13
 * @since 1.0.0
 */
@SpringBootTest //在类的上面添加 @SpringBootTest，系统会自动加载 Spring Boot 容器
public class HelloTest {

    @Test
    public void hello(){
        System.out.println("hello  world");
    }

    private MockMvc mockMvc;

    @Before  //@Before 注解的方法表示在测试启动的时候优先执行，一般用作资源初始化。
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=李斯")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
        //.accept(MediaType.APPLICATION_JSON_UTF8)) 这句是设置 JSON 返回编码，避免出现中文乱码的问题。
        //MockMvcRequestBuilders 可以支持 post、get 请求，使用 print() 方法会将请求和相应的过程都打印出来
    }

    @Test
    public void getHello1() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .post("/hello?name=李斯")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("李斯")));
        //MockMvcResultMatchers.content()，这段代码的意思是获取到 Web 请求执行后的结果；
        //Matchers.containsString("小明")，判断返回的结果集中是否包含“小明”这个字符串。
    }

}
