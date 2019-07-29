package com.zhao.comons;

/**
 * description: .
 *
 * @author zhaomaomao
 * @date 2019-07-03
 * @see com.zhao.comons
 * @since 1.0
 */
public class ResultMessage {
  private String title;
  private String msg;
  private String ico;
  private Object data;
  private int status;

  public static ResultMessage ok(){
    return new ResultMessage("系统消息","操作成功","info",null,200);
  }

  public static ResultMessage ok(Object data){
    return new ResultMessage("系统消息","操作成功","info",data,200);
  }

  public static ResultMessage error(){
    return new ResultMessage("系统消息","操作失败","error",null,5000);
  }

  public ResultMessage(String title, String msg, String ico, Object data, int status) {
    this.title = title;
    this.msg = msg;
    this.ico = ico;
    this.data = data;
    this.status = status;
  }

  @Override
  public String toString() {
    return "ResultMessage{" +
        "title='" + title + '\'' +
        ", msg='" + msg + '\'' +
        ", ico='" + ico + '\'' +
        ", data=" + data +
        ", status=" + status +
        '}';
  }

  public ResultMessage() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getIco() {
    return ico;
  }

  public void setIco(String ico) {
    this.ico = ico;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
