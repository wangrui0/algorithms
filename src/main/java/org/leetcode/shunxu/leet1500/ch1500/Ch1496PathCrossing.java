package org.leetcode.shunxu.leet1500.ch1500;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>1496. 判断路径是否相交
 *
 * <p>给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 *
 * <p>机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 *
 * <p>如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：path = "NES"
 * <p>输出：false
 * <p>解释：该路径没有在任何位置相交。
 *
 * <p>示例 2：
 *
 * <p>输入：path = "NESWW"
 * <p>输出：true
 * <p>解释：该路径经过原点两次。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= path.length <= 10^4
 * <p>    path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
 *
 * <p>通过次数9,046
 * <p>提交次数16,652
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/path-crossing/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1496PathCrossing {

  /**
   * <p> 复杂度
   *
   * <p> 假设 path 的长度为 n。
   *
   * <p>    时间复杂度：O(n)。最坏情况下，对于 n 个元素，每个元素做一次 O(1) 的哈希表查询和一次O(1) 的哈希表插入。
   *
   * <p>   空间复杂度：O(n)。这里使用了哈希表作为辅助空间，故空间代价是 O(n)。
   *
   * @param path
   * @return
   */
  public boolean isPathCrossing(String path) {
    Set<Integer> vis = new HashSet<Integer>();

    int x = 0, y = 0;
    vis.add(getHash(x, y));

    int length = path.length();
    for (int i = 0; i < length; i++) {
      char dir = path.charAt(i);
      switch (dir) {
        case 'N':
          --x;
          break;
        case 'S':
          ++x;
          break;
        case 'W':
          --y;
          break;
        case 'E':
          ++y;
          break;
      }
      int hashValue = getHash(x, y);
      if (!vis.add(hashValue)) {
        return true;
      }
    }

    return false;
  }

  public int getHash(int x, int y) {
    return x * 20001 + y;
  }
}
