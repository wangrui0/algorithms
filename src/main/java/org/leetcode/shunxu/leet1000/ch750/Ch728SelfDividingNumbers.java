package org.leetcode.shunxu.leet1000.ch750;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>728. 自除数
 *
 * <p>自除数 是指可以被它包含的每一位数除尽的数。
 *
 * <p>例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * <p>还有，自除数不允许包含 0 。
 *
 * <p>给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * <p>示例 1：
 *
 * <p>输入：
 * <p>上边界left = 1, 下边界right = 22
 * <p>输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 * <p>注意：
 *
 * <p>    每个输入参数的边界满足 1 <= left <= right <= 10000。
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 * <p>通过次数29,851
 * <p>提交次数39,587
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch728SelfDividingNumbers {

  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> ans = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      if (selfDividing(i)) {
        ans.add(i);
      }
    }
    return ans;
  }

  public boolean selfDividing(int n) {
    String s = Integer.toString(n);
    for (Character c : s.toCharArray()) {
      if (c == '0' || n % (c - '0') != 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(D)。D 是在区间 [L,R] 里的整数数。
   * <p> 空间复杂度：O(D)，使用了一个数组来存放结果
   *
   * @param left
   * @param right
   * @return
   */
  public List<Integer> selfDividingNumbers2(int left, int right) {
    List<Integer> ans = new ArrayList();
    for (int n = left; n <= right; ++n) {
      if (selfDividing2(n)) {
        ans.add(n);
      }
    }
    return ans;
  }

  public boolean selfDividing2(int n) {
    for (char c : String.valueOf(n).toCharArray()) {
      if (c == '0' || (n % (c - '0') > 0)) {
        return false;
      }
    }
    return true;
  }

}
