package org.leetcode.shunxu.leet1500.ch1350;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1313. 解压缩编码列表
 *
 * <p>给你一个以行程长度编码压缩的整数列表 nums 。
 *
 * <p>考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val
 * 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 *
 * <p>请你返回解压后的列表。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,2,3,4]
 * <p>输出：[2,4,4,4]
 * <p>解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 * <p>第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 * <p>最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,1,2,3]
 * <p>输出：[1,3,3]
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= nums.length <= 100
 * <p>    nums.length % 2 == 0
 * <p>    1 <= nums[i] <= 100
 *
 * <p>通过次数31,519
 * <p>提交次数37,991
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1313DecompressRunLengthEncodedList {

  public int[] decompressRLElist(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i += 2) {
      int frequency = nums[i];
      int num = nums[i + 1];
      for (int j = 0; j < frequency; j++) {
        ans.add(num);
      }
    }
    int[] array = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      array[i] = ans.get(i);
    }
    // return list.stream().mapToInt(Integer::intValue).toArray();
    return array;
  }
}
