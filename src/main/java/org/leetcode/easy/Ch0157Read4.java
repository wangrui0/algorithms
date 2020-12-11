package org.leetcode.easy;

/**
 * https://www.cnblogs.com/grandyang/p/5174322.html
 * <p>这道题给了我们一个 Read4 函数，每次可以从一个文件中最多读出4个字符，
 * <p> 如果文件中的字符不足4个字符时，返回准确的当前剩余的字符数。现在让实现一个最多能读取n个字符的函数。
 * <p> 这题有迭代和递归的两种解法，先来看迭代的方法，思路是每4个读一次，然后把读出的结果判断一下，如果为0的话，
 * <p> 说明此时的 buf 已经被读完，跳出循环，直接返回 res 和n之中的较小值。否则一直读入，直到读完n个字符，循环结束，最后再返回 res 和n之中的较小值，
 * <p> 参见代码如下：
 *
 * @author: wangrui
 * @date: 2020/12/10
 */
public class Ch0157Read4 {

//  https://segmentfault.com/a/1190000003794420

}
