package org.company.meituan.algorithm;

/**
 * <p>剑指 Offer 65. 不用加减乘除做加法
 *
 * <p>写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * <p>示例:
 *
 * <p>输入: a = 1, b = 1
 * <p>输出: 2
 *
 *
 *
 * <p>提示：
 *
 * <p>    a, b 均可能是负数或 0
 * <p>    结果不会溢出 32 位整数
 *
 * <p>通过次数48,393
 * <p>提交次数83,618
 * <p>请问您在哪类招聘中遇到此题？
 * <p>|剑指 Offer 65. 不用加减乘除做加法|2|https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof|
 * <p>@author: wangrui
 * <p>@date: 2021/4/30
 */
public class Ch004BuYongJiaJianChengChuXuoJiaFaLcof不用加减乘除做加法 {

  /**
   * <p>本题考察对位运算的灵活使用，即使用位运算实现加法。
   * <p> 设两数字的二进制形式 a,b ，其求和 s=a+b，a(i) 代表 a 的二进制第 i 位，则分为以下四种情况：
   * <p> a(i) 	b(i) 	无进位和 n(i) 	进位 c(i+1)
   * <p> 0 	    0 	      0 	            0
   * <p> 0    	1 	      1 	            0
   * <p> 1 	    0 	      1 	            0
   * <p> 1 	    1 	      0 	            1
   *
   * <p>观察发现，无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位)
   *
   * <p>因此无进位和 n 与进位 c 的计算公式如下；
   *
   * <p>n=a⊕b非进位和：异或运算
   * <p>c=a&b<<1进位：与运算+左移一位
   *
   * <p>（和 s ）===（非进位和 n ）+（进位 c ）。即可将 s=a+b 转化为：
   *
   * <p> s=a+b⇒s=n+c
   *
   * <p> 循环求 n 和 c ，直至进位 c=0 ；此时 s=n，返回 n 即可。
   *
   * @param a
   * @param b
   * @return
   */
  public int add(int a, int b) {
    while (b != 0) { // 当进位为 0 时跳出
      int c = (a & b) << 1;  // c = 进位
      a ^= b; // a = 非进位和
      b = c; // b = 进位
    }
    return a;
  }

  public int add_2(int a, int b) {
    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    while (b != 0) {
      int c = (a & b) << 1;
      a ^= b;
      b = c;
    }
    return a;
  }


}
