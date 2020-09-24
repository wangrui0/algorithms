package org.example;

/**
 * @author: wangrui
 * @date: 2020/9/24
 */
public class Test2 {

  public static void main(String[] args) {
    System.setProperty("test1","true");
    System.setProperty("test2","false");
    //如果系统属性name对应的值为true则返回true。
    System.out.println(Boolean.getBoolean("test1"));
    //如果系统属性name对应的值为false则返回false。
    System.out.println(Boolean.getBoolean("test2"));
    //如果系统属性不存在name,则返回false
    System.out.println(Boolean.getBoolean("test3"));
  }

}
