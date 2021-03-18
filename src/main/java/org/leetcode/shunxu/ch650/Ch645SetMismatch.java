package org.leetcode.shunxu.ch650;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>645. 错误的集合
 *
 * <p>集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * <p>给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * <p>请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,2,2,4]
 * <p>输出：[2,3]
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,1]
 * <p>输出：[1,2]
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= nums.length <= 104
 * <p>    1 <= nums[i] <= 104
 * <p>https://leetcode-cn.com/problems/set-mismatch/
 * <p>通过次数32,237
 * <p>提交次数76,086
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/18
 */
public class Ch645SetMismatch {

  public int[] findErrorNums1(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int minNum = 0;
    int maxNum = 0;
    for (int i = 1; i <= nums.length; i++) {
      if (map.containsKey(i)) {
        if (2 == map.get(i)) {
          minNum = i;
        }
      } else {
        maxNum = i;
      }
    }
    return new int[]{minNum, maxNum};
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(n)。在 nums 上完成了两次遍历。
   *
   * <p>   空间复杂度：O(1)。使用恒定的额外空间。
   *
   * <p> 作者：LeetCode
   * <p> 链接：https://leetcode-cn.com/problems/set-mismatch/solution/cuo-wu-de-ji-he-by-leetcode/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int[] findErrorNums1_1(int[] nums) {
    int dup = -1, missing = 1;
    for (int n : nums) {
      if (nums[Math.abs(n) - 1] < 0) {
        dup = Math.abs(n);
      } else {
        nums[Math.abs(n) - 1] *= -1;
      }
    }
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0) {
        missing = i + 1;
      }
    }
    return new int[]{dup, missing};
  }

  /**
   * <p>复杂度分析
   * <p>
   * <p>时间复杂度：O(n)。遍历 n 个元素 5 次。
   * <p>
   * <p>空间复杂度：O(1)。使用恒定的额外空间。
   * <p>
   * <p>作者：LeetCode 链接：https://leetcode-cn.com/problems/set-mismatch/solution/cuo-wu-de-ji-he-by-leetcode/
   * 来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int[] findErrorNums2_2(int[] nums) {
    int xor = 0, xor0 = 0, xor1 = 0;
    for (int n : nums) {
      xor ^= n;
    }
    for (int i = 1; i <= nums.length; i++) {
      xor ^= i;
    }
    int rightmostbit = xor & ~(xor - 1);
    for (int n : nums) {
      if ((n & rightmostbit) != 0) {
        xor1 ^= n;
      } else {
        xor0 ^= n;
      }
    }
    for (int i = 1; i <= nums.length; i++) {
      if ((i & rightmostbit) != 0) {
        xor1 ^= i;
      } else {
        xor0 ^= i;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == xor0) {
        return new int[]{xor0, xor1};
      }
    }
    return new int[]{xor1, xor0};
  }
}
