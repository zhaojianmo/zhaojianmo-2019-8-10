package com.zhao.entity;

/**
 * description: .
 *
 * @author zhaomaomao
 * @date 2019-07-20
 * @see com.zhao.entity
 * @since 1.0
 */
public class Dept {
  private String dname;

  @Override
  public String toString() {
    return "Dept{" +
        "dname='" + dname + '\'' +
        '}';
  }

  public Dept(String dname) {
    this.dname = dname;
  }

  public Dept() {
  }

  public String getDname() {
    return dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }
}
