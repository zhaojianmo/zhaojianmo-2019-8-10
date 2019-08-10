package com.zhao.test;

import junit.framework.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * description: .
 *
 * @author 赵乔功
 * @date 2019-08-01
 */
public class Test2 {
  static Map<String,String> map = null;
  static {
    map =new HashMap<>();
    map.put("FFD8FF","jpg");
    map.put("89504E","png");
    map.put("474946","gif");
    map.put("524946","webp");
    map.put("000001","ico");
    map.put("424D36","bmp");
    map.put("00000A","tga");
    map.put("49492A","tif");
  }

  private  static String bytesToHexString(byte[] src) {
    StringBuilder stringBuilder = new StringBuilder();
    if (src == null || src.length <= 0) {
      return null;
    }
    for (int i = 0; i < src.length; i++) {
      int v = src[i] & 0xFF;
      String hv = Integer.toHexString(v);
      if (hv.length() < 2) {
        stringBuilder.append(0);
      }
      stringBuilder.append(hv);
    }
    return stringBuilder.toString();
  }

  private  static  String checkType(String code){
    return map.get(code);
  }
  /**
   * 获得文件状态码
   */
  public static String getType( MultipartFile multipartFile){
    String code ="";
    InputStream inputStream =null;
    try {
      inputStream = multipartFile.getInputStream();
      byte[] b = new byte[3];
      inputStream.read(b, 0, b.length);
      code = bytesToHexString(b);
      code = code.toUpperCase();
    }catch (Exception e){
    }finally {
      if(inputStream!=null){
        try {
          inputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return code;
  }



}