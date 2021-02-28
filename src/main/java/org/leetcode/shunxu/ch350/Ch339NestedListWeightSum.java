package org.leetcode.shunxu.ch350;

import java.util.List;

/**
 * <p> 嵌套链表权重和
 * <p>题目描述：
 * <p>给定一个嵌套的整数列表，请返回该列表按深度加权后所有整数的总和。
 * <p>每个元素要么是整数，要么是列表。同时，列表中元素同样也可以是整数或者是另一个列表。
 *
 * <p> 示例 1:
 * <p> 输入: [[1,1],2,[1,1]]
 * <p>输出: 10
 * <p>解释: 因为列表中有四个深度为 2 的 1 ，和一个深度为 1 的 2。
 *
 * <p> 示例 2:
 * <p> 输入: [1,[4,[6]]]
 * <p>输出: 27
 * <p>解释: 一个深度为 1 的 1，一个深度为 2 的 4，一个深度为 3 的 6。所以，1 + 42 + 63 = 27。
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch339NestedListWeightSum {

  public int depthSum(List<NestedInteger> nestedList) {
    int res = 0;

    // iterate list
    for (int i = 0; i < nestedList.size(); i++) {
      res += getSum(nestedList.get(i), 1);
    }

    return res;
  }

  public int getSum(NestedInteger ele, int depth) {
    int sum = 0;

    // if ele is integer, return its value * depth;
    if (ele.isInteger()) {
      return depth * ele.getInteger();
    }

    // if ele is a list, iterate list recursively call function;
    for (int i = 0; i < ele.getList().size(); i++) {
      sum += getSum(ele.getList().get(i), depth + 1);
    }

    return sum;
  }
}

interface NestedInteger {
  // @return true if this NestedInteger holds a single integer, rather than a nested list.


  boolean isInteger();
  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list


  Integer getInteger();
  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer


  List<NestedInteger> getList();
}
