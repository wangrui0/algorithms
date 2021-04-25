package org.leetcode.lcp;

/**
 * <p>LCP 02. 分式化简
 *
 * <p>有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 *
 * <p>连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 *
 *
 *
 * <p>输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：cont = [3, 2, 0, 2]
 * <p>输出：[13, 4]
 * <p>解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 *
 * <p>示例 2：
 *
 * <p>输入：cont = [0, 0, 3]
 * <p>输出：[3, 1]
 * <p>解释：如果答案是整数，令分母为1即可。
 *
 *
 *
 * <p>限制：
 *
 * <p>    cont[i] >= 0
 * <p>    1 <= cont的长度 <= 10
 * <p>    cont最后一个元素不等于0
 * <p>    答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 *
 * <p>通过次数11,269
 * <p>提交次数16,701
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/31
 */
public class LCP002DeepDarkFraction {

/*
  <p> 解题思路
  <p> 把分式看成N个 a+c/b的形式 初始化c=1;
  <p> 每次子计算后结果b/ab+c 于是新的a为a[n-1] 新的b为 ab+c 新的c为b
  <p> 我们发现当a=a0时，也满足上述表达式，不需要特殊考虑。
  <p> 代码
  */
  public int[] jiaohuan(int a, int b, int c) {
    int[] temp = new int[2];
    temp[0] = a * b + c;
    temp[1] = b;
    return temp;
  }

  public int[] Nojiaohuan(int a, int b, int c) {
    int[] temp = new int[2];
    temp[0] = b;
    temp[1] = a * b + c;
    return temp;
  }

  public int[] fraction(int[] cont) {
    int L = cont.length;
    if (L == 0) {
      return null;
    }
    int[] res = new int[2];
    res[0] = cont[L - 1];
    res[1] = 1;//初始化c
    for (int i = L - 1; i > 0; i--) {
      res = jiaohuan(cont[i - 1], res[0], res[1]);
    }
    return res;
  }
}
