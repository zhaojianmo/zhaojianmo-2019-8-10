package com.zhao.test;


import com.zhao.comons.ResultMessage;
import com.zhao.controller.UserController;
import com.zhao.service.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * description: .
 *
 * @author zhaomaomao
 * @date 2019-07-10
 * @see com.zhao.test
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-config.xml","classpath:springMVC-config.xml"})
@WebAppConfiguration
public class Test1 {

  private MockMvc mvc;
  @Before
  public void setup(){
    mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
  }

  @org.junit.Test
  public void b() throws Exception {



  }

}
