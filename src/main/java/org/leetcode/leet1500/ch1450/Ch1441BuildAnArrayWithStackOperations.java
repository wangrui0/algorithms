package org.leetcode.leet1500.ch1450;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>1441. 用栈操作构建数组
 *
 * <p>给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 *
 * <p>请使用下述操作来构建目标数组 target ：
 *
 * <p>    Push：从 list 中读取一个新元素， 并将其推入数组中。
 * <p>    Pop：删除数组中的最后一个元素。
 * <p>    如果目标数组构建完成，就停止读取更多元素。
 *
 * <p>题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 *
 * <p>请返回构建目标数组所用的操作序列。
 *
 * <p>题目数据保证答案是唯一的。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：target = [1,3], n = 3
 * <p>输出：["Push","Push","Pop","Push"]
 * <p>解释：
 * <p>读取 1 并自动推入数组 -> [1]
 * <p>读取 2 并自动推入数组，然后删除它 -> [1]
 * <p>读取 3 并自动推入数组 -> [1,3]
 *
 * <p>示例 2：
 *
 * <p>输入：target = [1,2,3], n = 3
 * <p>输出：["Push","Push","Push"]
 *
 * <p>示例 3：
 *
 * <p>输入：target = [1,2], n = 4
 * <p>输出：["Push","Push"]
 * <p>解释：只需要读取前 2 个数字就可以停止。
 *
 * <p>示例 4：
 *
 * <p>输入：target = [2,3,4], n = 4
 * <p>输出：["Push","Pop","Push","Push","Push"]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= target.length <= 100
 * <p>    1 <= target[i] <= 100
 * <p>    1 <= n <= 100
 * <p>    target 是严格递增的
 * <p>@author: wangrui
 * <p>@date: 2021/4/20
 */
public class Ch1441BuildAnArrayWithStackOperations {

  /**
   * <p>方法一：栈
   * <p>时间复杂度：O(n)
   * <p>空间复杂度：O(1)
   *
   * @param target
   * @param n
   * @return
   */
  public List<String> buildArray(int[] target, int n) {

    List<String> list = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    int flag = 0;

    for (int i = 1; i <= n; i++) {

      if (flag < target.length) {

        list.add("Push");
        stack.push(i);
      }
      if (flag < target.length && stack.peek() != target[flag]) {

        list.add("Pop");
        stack.pop();
        flag--;
      }
      flag++;
    }
    return list;
  }

  /**
   * <p>方法一：非栈
   * <p>时间复杂度：O(n)
   * <p>空间复杂度：O(1)
   *
   * @param target
   * @param n
   * @return
   */
  public List<String> buildArray_2(int[] target, int n) {

    List<String> list = new ArrayList<>();
    int flag = 0;

    for (int i = 1; i <= n; i++) {

      if (flag >= target.length) {
        break;
      }
      if (i == target[flag] && flag < target.length) {

        list.add("Push");
      }
      if (i != target[flag] && flag < target.length) {

        list.add("Push");
        list.add("Pop");
        flag--;
      }
      flag++;
    }
    return list;
  }

  public static List<String> buildArray_self(int[] target, int n) {
    List<String> ans = new ArrayList<>();
    int index = 1;
    for (int i = 0; i < target.length; i++) {
      int num = target[i];
      while (index <= num) {
        ans.add("Push");
        if (index != num) {
          ans.add("Pop");
        }
        index++;
      }
    }
    return ans;
  }

  public static List<String> buildArray_3(int[] target, int n) {
    List<String> ans = new ArrayList<>();
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (count >= target.length) {
        break;
      }
      if (count < target.length) {
        ans.add("Push");
      }
      if (target[count] != i) {
        ans.add("Pop");
        count--;
      }
      count++;
    }
    return ans;
  }

}
