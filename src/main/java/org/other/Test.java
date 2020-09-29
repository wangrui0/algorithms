package org.other;


import java.util.Optional;

/**
 * @author: wangrui
 * @date: 2020/9/28
 */
public class Test
{

  public static void main(String[] args) {
    Optional<String> aa = Optional.ofNullable(null);
    if(aa.isPresent()){
      System.out.println(aa.get());

    }





  }

}
