package org.leetcode.shunxu.ch100;

/**
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * <p>
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * <p>
 * 输出: 2
 * <p>
 * 说明: 8 的平方根是 2.82842...,
 * <p>
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/12
 */
public class Ch0069MySqrt {

  public static void main(String[] args) {
    System.out.println(mySqrt(8));
    System.out.println(mySqrt(4));
    System.out.println(mySqrt(3));
  }

  /**
   * 二分查找
   * @param x
   * @return
   */
  public static int mySqrt(int x) {
    int left = 0;
    int right = x;
    int result = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if ((long) mid * mid <= x) {
        /*if (mid > result) {
          result = mid;
        }*/
        result = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }

  /**
   * <p>
   * 由于 x 平方根的整数部分 ans 是满足 k^2 <= x 的最大 k 值
   * <p>
   * 因此我们可以对 k 进行二分查找，从而得到答案。
   * <p>
   * 二分查找的下界为 0，上界可以粗略地设定为 x。在二分查找的每一步中，我们只需要比较中间元素 mid 的平方与 x 的大小关系，并通过比较的结果调整上下界的范围。
   * <p>
   * 由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案 ans 后，也就不需要再去尝试 ans+1 了。
   * <p>
   * 作者：LeetCode-Solution
   * <p>
   * 链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
   * <p>
   * 来源：力扣（LeetCode）
   * <p>
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */

  public static int mySqrt2(int x) {
    int l = 0, r = x, ans = -1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if ((long) mid * mid <= x) {
        ans = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return ans;
  }
}
