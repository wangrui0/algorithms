package org.leetcode.shunxu.ch350;

/**
 * <p> 342. 4的幂
 *
 * <p> 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * <p> 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4的x 次方
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：n = 16
 * <p> 输出：true
 *
 * <p> 示例 2：
 *
 * <p> 输入：n = 5
 * <p> 输出：false
 *
 * <p> 示例 3：
 *
 * <p> 输入：n = 1
 * <p> 输出：true
 *
 *
 *
 * <p> 提示：
 *
 * <p>     -231 <= n <= 231 - 1
 *
 *
 *
 * <p> 进阶：
 *
 * <p>     你能不使用循环或者递归来完成本题吗？
 *
 * <p> 通过次数39,884
 * <p> 提交次数79,789
 * <p> 在真实的面试中遇到过这道题？
 * <p> https://leetcode-cn.com/problems/power-of-four/
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch303RangeSumQueryImmutable {

  private int[] data;
  private int[] sum;

  public Ch303RangeSumQueryImmutable(int[] nums) {
    sum = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：每次查询的时间 O(1)，O(N) 预计算时间。由于累积和被缓存，每个sumrange查询都可以用 O(1) 时间计算。
   * <p>    空间复杂度：O(n).
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/range-sum-query-immutable/solution/qu-yu-he-jian-suo-shu-zu-bu-ke-bian-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param i
   * @param j
   * @return
   */
  public int sumRange(int i, int j) {
    return sum[j + 1] - sum[i];
  }


  public Ch303RangeSumQueryImmutable(int[] nums, boolean cache) {
    this.data = nums;
  }


  /**
   * 方法2：
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：每次查询的时间 O(n)，每个 sumrange 查询需要 O(n) 时间。
   * <p>     空间复杂度：O(1)，请注意，data 是对 nums 的引用，不是它的副本。
   *
   * @param j
   * @return
   */
  public int sumRange2(int i, int j) {
    int sum = 0;
    for (int k = i; k <= j && k < data.length; k++) {
      sum += data[k];
    }
    return sum;
  }


}
