/**
 * Copyright (C), 2015-2019, 申雪供应链有限公司
 * FileName: WebControllerTest
 * Author:   Administrator
 * Date:     2019-03-13 14:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sto.springbootdemo;/**
 * Created by Administrator on 2019-03-13.
 */

import com.sto.springbootdemo.web.HelloController;
import com.sto.springbootdemo.web.WebController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019-03-13
 * @since 1.0.0
 */
@SpringBootTest
public class WebControllerTest {
    private MockMvc mockMvc;

    @Before  //@Before 注解的方法表示在测试启动的时候优先执行，一般用作资源初始化。
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
    }

    @Test
    public void getUser() throws Exception{
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.post("/getUser"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        //“.andReturn().getResponse().getContentAsString(); ”获取请求的返回信息，并将返回信息转换为字符串，最后将请求的响应结果打印出来。
        System.out.println("result :"+contentAsString);
    }

    @Test
    public void getUsers() throws Exception{
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/getUsers"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        //“.andReturn().getResponse().getContentAsString(); ”获取请求的返回信息，并将返回信息转换为字符串，最后将请求的响应结果打印出来。
        System.out.println("result :"+contentAsString);
    }

    @Test
    public void saveUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
                .param("name", "")
                .param("age", "666")
                .param("pass", "1234"));
    }

}
