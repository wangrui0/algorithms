package org.leetcode.shunxu.leet1500.ch1400;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1389. 按既定顺序创建目标数组
 *
 * <p>给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 *
 * <p>    目标数组 target 最初为空。
 * <p>    按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 * <p>    重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 *
 * <p>请你返回目标数组。
 *
 * <p>题目保证数字插入位置总是存在。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * <p>输出：[0,4,1,3,2]
 * <p>解释：
 * <p>nums       index     target
 * <p>0            0        [0]
 * <p>1            1        [0,1]
 * <p>2            2        [0,1,2]
 * <p>3            2        [0,1,3,2]
 * <p>4            1        [0,4,1,3,2]
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * <p>输出：[0,1,2,3,4]
 * <p>解释：
 * <p>nums       index     target
 * <p>1            0        [1]
 * <p>2            1        [1,2]
 * <p>3            2        [1,2,3]
 * <p>4            3        [1,2,3,4]
 * <p>0            0        [0,1,2,3,4]
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1], index = [0]
 * <p>输出：[1]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length, index.length <= 100
 * <p>    nums.length == index.length
 * <p>    0 <= nums[i] <= 100
 * <p>    0 <= index[i] <= i
 *
 * <p>通过次数25,067
 * <p>提交次数30,200
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1389CreateTargetArrayInTheGivenOrder {

  /**
   * <p> 复杂度分析
   *
   * <p> 记数组的长度为 n。
   *
   * <p>   时间复杂度：考虑一次操作最坏情况下的时间代价和当前数组中元素的个数呈正比， 第 i 次操作时元素个数为 i−1，所以这里渐进时间复杂度为 O(∑i=1n(i−1))=O(n2)O(n^2)。
   *
   * <p>   空间复杂度：这里没有使用到辅助空间，故渐进空间复杂度为 O(1)。
   *
   * @param nums
   * @param index
   * @return
   */
  public int[] createTargetArray(int[] nums, int[] index) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; ++i) {
      list.add(index[i], nums[i]);
    }
    int[] ret = new int[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      ret[i] = list.get(i);
    }
    return ret;
  }

  /**
   * 太简单了
   *
   * @param nums
   * @param index
   * @return
   */
  public static int[] createTargetArray_self(int[] nums, int[] index) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      ans.add(index[i], nums[i]);
    }
    int[] array = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      array[i] = ans.get(i);
    }
    return array;
  }

}
