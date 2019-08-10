package com.zhao.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhao.service.UserService;
import com.zhao.utils.FileAttributeCode;
import com.zhao.utils.FileTypeVerify;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * description: .
 *
 * @author zhaomaomao
 * @date 2019-07-02
 * @see com.zhao.controller
 * @since 1.0
 */
@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/test")
  public String selAll() {
    return "test";
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
//    return "fsuccess";
//  }
  @RequestMapping("/upload")
  @ResponseBody
  public Map<String, String> upload(MultipartFile filename) throws Exception {
    String featureCode = FileTypeVerify.getFeatureCode(filename);
    System.out.println(featureCode);
    File file = new File("C:\\Users\\赵毛毛\\Desktop\\" + filename.getOriginalFilename());
    Path path = Paths.get(filename.getOriginalFilename());
    String s = Files.probeContentType(path);
    filename.transferTo(file);
    Map<String, String> map = new HashMap<>();
    map.put("msg", "ok");
    System.out.println();
    return map;
  }


  @RequestMapping("/download")
  public void dowload(String path, HttpServletRequest request, HttpServletResponse response) throws IOException {
    System.out.println(path);
    InputStream is = request.getServletContext().getResourceAsStream(path);
    System.out.println(is);
    OutputStream os = null;
    try {
      os = response.getOutputStream();
      byte[] bytes = new byte[2048];
      int r;
      while ((r = is.read(bytes)) != -1) {
        os.write(bytes, 0, r);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (os != null) {
        try {
          os.flush();
          os.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }


  @RequestMapping("/download1")
  public void dowload1(String path, HttpServletRequest request, HttpServletResponse response) throws IOException {
    InputStream is = request.getServletContext().getResourceAsStream(path);
    String fileName = path.substring(path.lastIndexOf("/") + 1);
    OutputStream os = null;
    try {
      response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
      response.setHeader("Connection", "close");
      response.setHeader("Content-Type", "application/octet-stream");
      os = response.getOutputStream();
      byte[] bytes = new byte[2048];
      int r;
      while ((r = is.read(bytes)) != -1) {
        os.write(bytes, 0, r);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (os != null) {
        try {
          os.flush();
          os.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }


  @RequestMapping("/down")
  @ResponseBody
  public ResponseEntity<byte[]> download(HttpServletRequest request, String filename) throws Exception {
    String path = request.getServletContext().getRealPath("C:\\Users\\赵毛毛\\Desktop\\" + filename);
    //创建文件对象
    File file = new File(filename);
    //设置编码格式
    filename = this.getFilename(request, filename);
    //设置响应头
    HttpHeaders httpHeaders = new HttpHeaders();
    //浏览器以下载的方式打开文件
    httpHeaders.setContentDispositionFormData("attachment", filename);
    //以流的方式下载数据
    httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

    return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.OK);
  }

  /*
   * 根据浏览器不同进行编码格式设置
   * */
  private String getFilename(HttpServletRequest request, String filename) throws Exception {
    String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
    String header = request.getHeader("User-Agent");
    for (String ieBrowserKeyWord : IEBrowserKeyWords) {
      if (header.contains(ieBrowserKeyWord))
        return URLEncoder.encode(filename, "UTF-8");
    }
    return new String(filename.getBytes("UTF-8"), "iso-8859-1");
  }

  private static String bytesToHexString(byte[] src) {
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


//  private void SendText(String namecode, HttpServletRequest request) {
//    StringBuffer sb = new StringBuffer();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    String title = "消息头";
//    String newDate = sdf.format(new Date());
//    sb.append(newDate + "\n");
//    sb.append("消息内容" + "\n");
//    JSONObject baseobj = new JSONObject();
//    //推送人的code
//    baseobj.put("touser", namecode);
//    //自带参数
//    baseobj.put("msgtype", "news");
//    JSONObject article = new JSONObject();
//    //应用id
//    baseobj.put("agentid", "这里写你应用的id");
//    String loginsign = "dianmianlr";
//    String linkurl = "点击推送的文本跳转的路径";
//    article.put("url", linkurl);
//    JSONObject newsobj = new JSONObject();
//    JSONArray articles = new JSONArray();
//
//    article.put("title", title);
//    article.put("description", sb.toString());
//    articles.add(article);
//    newsobj.put("articles", articles);
//    baseobj.put("news", newsobj);
//    System.out.println(baseobj.toString());
//    //获取你自己access_Token
//    JSONObject result = MessageAPI.sendMessage(AccessTokenHelper.access_Token, baseobj.toString());
//    if (result != null)
//      System.out.println(result);
//  }

}
