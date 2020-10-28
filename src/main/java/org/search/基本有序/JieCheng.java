package org.search.基本有序;

/**
 * @author: wangrui
 * @date: 2020/10/25
 */
public class JieCheng {

  /**
   * 10!=10*9!=10*9*8!
   * <p>
   * int  function(int n) 10!=function(10)=10*function(9)=10*9*function(8)...=10*9*8*...*1
   */

  public static void main(String[] args) {
    int num = function(4);
    System.out.println(num);

  }

  static int function(int n) {
    if(n==1){
      return 1;
    }
    return n*function(n-1);
  }

}
