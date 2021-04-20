package org.leetcode.shunxu.leet500.ch400;

/**
 * <p> 371. 两整数之和
 *
 * <p> 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * <p> 示例 1:
 *
 * <p> 输入: a = 1, b = 2
 * <p> 输出: 3
 *
 * <p>  示例 2:
 *
 * <p>  输入: a = -2, b = 3
 * <p> 输出: 1
 * <p> https://leetcode-cn.com/problems/sum-of-two-integers/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch371SumOfTwoIntegers {

  /**
   * <p>这道题是 CareerCup 上的一道原题，可参见博主之前的博客 18.1 Add Two Numbers。这里让实现两数相加，但是不能用加号或者其他什么数学运算符号，
   * <p>那么只能回归计算机运算的本质，位操作 Bit Manipulation，在做加法运算的时候，每位相加之后可能会有进位 Carry 产生，然后在下一位计算时需要加
   * <p>上进位一起运算，那么能不能将两部分拆开呢，来看一个例子 759+674
   *
   * <p>1. 如果不考虑进位，可以得到 323
   *
   * <p>2. 如果只考虑进位，可以得到 1110
   *
   * <p>3. 把上面两个数字假期 323+1110=1433 就是最终结果了
   *
   * <p>然后进一步分析，如果得到上面的第一第二种情况，在二进制下来看，不考虑进位的加，0+0=0，0+1=1, 1+0=1，1+1=0，这就是异或的运算规则，如果只考虑进位的加 0+0=0, 0+1=0, 1+0=0,
   * 1+1=1，而这其实这就是'与'的运算，而第三步在将两者相加时，再递归调用这个算法，终止条件是当进位为0时，直接返回第一步的结果。一切都是如此的美好，突然有一天，博主的所有方法都无法通过 OJ 了，不知为何，原因不明。在热心网友
   * GGGGITFK 的提示下，终于知道了错误的原因：
   *
   * <p>runtime error: left shift of negative value -2147483648，对INT_MIN左移位。
   *
   * <p>就是 LeetCode 自己的编译器比较 strict，不能对负数进行左移，就是说最高位符号位必须要为0，才能左移（此处应有尼克杨问号脸？！），好吧，你赢了。
   * <p>那么在a和b相 '与' 之后，再'与'上一个最高位为0，其余位都为1的数 0x7fffffff，这样可以强制将最高位清零，然后再进行左移，终于，世界清静了，
   * <p>参见代码如下：
   */
  public int getSum(int a, int b) {
    if (b == 0) {
      return a;
    }
    int sum = a ^ b;
    int carry = (a & b & 0x7fffffff) << 1;
    return getSum(sum, carry);
  }

  public int getSum2(int a, int b) {
    return b == 0 ? a : getSum2(a ^ b, (a & b & 0x7fffffff) << 1);
  }

  public int getSum3(int a, int b) {
    while (b > 0) {
      int carry = (a & b & 0x7fffffff) << 1;
      a = a ^ b;
      b = carry;
    }
    return a;
  }
}
