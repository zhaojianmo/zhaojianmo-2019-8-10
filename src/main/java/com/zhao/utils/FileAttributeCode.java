package com.zhao.utils;

/**
 * description: .
 *
 * @author 赵乔功
 * @date 2019-08-01
 */
public enum FileAttributeCode {

    JPG("FFD8FF"),
    PNG("89504E");

    private String featureCode;

    public String getFeatureCode(){
      return featureCode;
    }

    private FileAttributeCode(String featureCode){
      this.featureCode=featureCode;
    }
//  map.put("FFD8FF","jpg");
//        map.put("89504E","png");
//        map.put("474946","gif");
//        map.put("524946","webp");
//        map.put("000001","ico");
//        map.put("424D36","bmp");
//        map.put("00000A","tga");
//        map.put("49492A","tif");


}
