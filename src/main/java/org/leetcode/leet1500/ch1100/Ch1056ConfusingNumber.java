package org.leetcode.leet1500.ch1100;

import java.util.HashMap;

/**
 * <p>易混淆数字
 * <p>1. 题目
 * <p>给定一个数字 N，当它满足以下条件的时候返回 true：
 *
 * <p>原数字旋转 180° 以后可以得到新的数字。
 *
 * <p>如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
 *
 * <p>2, 3, 4, 5, 7 旋转 180° 后，得到的不是数字。
 *
 * <p>易混淆数 (confusing number) 在旋转180°以后，可以得到和原来不同的数，且新数字的每一位都是有效的。
 *
 *
 *
 * <p>示例 1：
 * <p>输入：6
 * <p>输出：true
 * <p>解释：
 * <p>把 6 旋转 180° 以后得到 9，9 是有效数字且 9!=6 。
 *
 * <p>示例 2：
 * <p>输入：89
 * <p>输出：true
 * <p>解释:
 * <p>把 89 旋转 180° 以后得到 68，86 是有效数字且 86!=89 。
 *
 * <p>示例 3：
 * <p>输入：11
 * <p>输出：false
 * <p>解释：
 * <p>把 11 旋转 180° 以后得到 11，11 是有效数字但是值保持不变，所以 11 不是易混淆数字。
 *
 * <p>示例 4：
 * <p>输入：25
 * <p>输出：false
 * <p>解释：
 * <p>把 25 旋转 180° 以后得到的不是数字。
 *
 * <p>提示：
 * <p>0 <= N <= 10^9
 * <p>可以忽略掉旋转后得到的前导零
 * <p>	例如，如果我们旋转后得到 0008 那么该数字就是 8 。
 * <p>https://leetcode-cn.com/problems/confusing-number/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1056ConfusingNumber {

  public boolean confusingNumber(int N) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    hm.put(0, 0);
    hm.put(1, 1);
    hm.put(6, 9);
    hm.put(9, 6);
    hm.put(8, 8);
    int cur = 0;
    int temp = N;

    while (N > 0) {
      int d = N % 10;
      if (!hm.containsKey(d)) {
        return false;

      }

      cur = cur * 10 + hm.get(d);
      N /= 10;

    }
    return cur != temp;
  }
}
