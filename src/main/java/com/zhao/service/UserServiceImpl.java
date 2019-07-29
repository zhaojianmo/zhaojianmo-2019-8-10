package com.zhao.service;

import com.zhao.comons.ResultMessage;
import com.zhao.dao.UserDao;
import com.zhao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: .
 *
 * @author zhaomaomao
 * @date 2019-07-03
 * @see com.zhao.service
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;
  @Override
  public ResultMessage selAll() {
    return ResultMessage.ok(userDao.selAll());
  }
}
