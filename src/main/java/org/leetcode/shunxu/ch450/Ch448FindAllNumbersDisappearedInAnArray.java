package org.leetcode.shunxu.ch450;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>448. 找到所有数组中消失的数字
 *
 * <p>给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * <p>找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * <p>您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * <p>示例:
 *
 * <p>输入:
 * <p>[4,3,2,7,8,2,3,1]
 *
 * <p>输出:
 * <p>[5,6]
 * <p>https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch448FindAllNumbersDisappearedInAnArray {

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(n)。其中 n 是数组 nums 的长度。
   *
   * <p>    空间复杂度：O(1)。返回值不计入空间复杂度。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-d-mabl/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public List<Integer> findDisappearedNumbers(int[] nums) {
    int n = nums.length;
    for (int num : nums) {
      int x = (num - 1) % n;
      nums[x] += n;
    }
    List<Integer> ret = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      if (nums[i] <= n) {
        ret.add(i + 1);
      }
    }
    return ret;
  }
}

