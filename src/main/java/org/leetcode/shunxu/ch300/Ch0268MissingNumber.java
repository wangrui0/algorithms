package org.leetcode.shunxu.ch300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>268. 丢失的数字
 * <p>给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *
 *
 * <p>进阶：
 *
 * <p>你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [3,0,1]
 * <p>输出：2
 * <p>解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>示例 2：
 *
 * <p>输入：nums = [0,1]
 * <p>输出：2
 * <p>解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>示例 3：
 *
 * <p>输入：nums = [9,6,4,2,3,5,7,0,1]
 * <p>输出：8
 * <p>解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * <p>示例 4：
 *
 * <p>输入：nums = [0]
 * <p>输出：1
 * <p>解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *
 *
 * <p>提示：
 *
 * <p>n == nums.length
 * <p>1 <= n <= 104
 * <p>0 <= nums[i] <= n
 * <p>nums 中的所有数字都 独一无二
 * <p>
 * <p>
 * <p>
 *
 * @author: wangrui
 * @date: 2021/2/18
 */
public class Ch0268MissingNumber {

  /**
   * <p>复杂度分析
   *
   * <p>时间复杂度：O(nlogn)。由于排序的时间复杂度为 O(nlogn)，扫描数组的时间复杂度为 O(n)，因此总的时间复杂度为 O(nlogn)。
   * <p>空间复杂度：O(1) 或 O(n)。空间复杂度取决于使用的排序算法，根据排序算法是否进行原地排序（即不使用额外的数组进行临时存储），空间复杂度为 O(1) 或 O(n)。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int missingNumber1(int[] nums) {
    Arrays.sort(nums);

    // 判断 n 是否出现在末位
    if (nums[nums.length - 1] != nums.length) {
      return nums.length;
    }
    // 判断 0 是否出现在首位
    else if (nums[0] != 0) {
      return 0;
    }

    // 此时缺失的数字一定在 (0, n) 中
    for (int i = 1; i < nums.length; i++) {
      int expectedNum = nums[i - 1] + 1;
      if (nums[i] != expectedNum) {
        return expectedNum;
      }
    }

    // 未缺失任何数字（保证函数有返回值）
    return -1;
  }

  public int missingNumber11(int[] nums) {
    Arrays.sort(nums);
    int length = nums.length;
    if (nums[length - 1] != length) {
      return length;
    } else if (nums[0] != 0) {
      return 0;
    }
    for (int i = 1; i < length; i++) {
      int expected = nums[i - 1] + 1;
      if (expected != nums[i]) {
        return expected;
      }
    }
    return -1;
  }

  /**
   * <p>复杂度分析
   * <p>时间复杂度：O(n)。集合的插入操作的时间复杂度都是 O(1)，一共插入了 n 个数，时间复杂度为 O(n)。集合的查询操作的时间复杂度同样是 O(1)，最多查询 n+1 次，时间复杂度为 O(n)。因此总的时间复杂度为
   * O(n)。
   * <p>空间复杂度：O(n)。集合中会存储 n 个数，因此空间复杂度为 O(n)。
   *
   * @param nums
   * @return
   */
  public int missingNumber2(int[] nums) {
    Set<Integer> numSet = new HashSet<Integer>();
    for (int num : nums) {
      numSet.add(num);
    }

    int expectedNumCount = nums.length + 1;
    for (int number = 0; number < expectedNumCount; number++) {
      if (!numSet.contains(number)) {
        return number;
      }
    }
    return -1;
  }

  public int missingNumber21(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (Integer i = 0; i <= nums.length; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * <p>分析
   *
   * <p>由于异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数，因此我们可以通过异或运算找到缺失的数字。
   * <p>missing
   * <p>=4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
   * <p>=(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
   * <p>=0∧0∧0∧0∧2
   * <p>=2
   * <p>复杂度分析
   *
   * <p>时间复杂度：O(n)。这里假设异或运算的时间复杂度是常数的，总共会进行 O(n) 次异或运算，因此总的时间复杂度为 O(n)。
   * <p>空间复杂度：O(1)。算法中只用到了 O(1) 的额外空间，用来存储答案
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int missingNumber31(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
      missing ^= i ^ nums[i];
    }
    return missing;
  }

  public int missingNumber32(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
      missing ^= i ^ nums[i];
    }
    return missing;
  }
}
