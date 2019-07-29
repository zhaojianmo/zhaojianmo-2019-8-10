package com.zhao.controller;

import com.zhao.comons.ResultMessage;
import com.zhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * description: .
 *
 * @author zhaomaomao
 * @date 2019-07-02
 * @see com.zhao.controller
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/",method= RequestMethod.GET)
  public ResultMessage selAll(Model model){
    return userService.selAll();
  }
//  @RequestMapping(value = "/{id}",method= RequestMethod.POST)
//  public String addAll(){
//
//    return "success";
//  }
//  @RequestMapping(value = "/{id}",method= RequestMethod.PUT)
//  public String updateAll(){
//
//    return "success";
//  }
//  @RequestMapping(value = "/{id}",method= RequestMethod.DELETE)
//  public String del(){
//    return "success";
//  }
}
