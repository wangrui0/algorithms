package org.leetcode.shunxu.leet500.ch400;

/**
 * <p>374. 猜数字大小
 *
 * <p>猜数字游戏的规则如下：
 *
 * <p>   每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * <p>    如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 *
 * <p>你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 *
 * <p>    -1：我选出的数字比你猜的数字小 pick < num
 * <p>    1：我选出的数字比你猜的数字大 pick > num
 * <p>    0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 *
 * <p>返回我选出的数字。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 10, pick = 6
 * <p>输出：6
 *
 * <p>示例 2：
 *
 * <p>输入：n = 1, pick = 1
 * <p>输出：1
 *
 * <p>示例 3：
 *
 * <p>输入：n = 2, pick = 1
 * <p>输出：1
 *
 * <p>示例 4：
 *
 * <p>输入：n = 2, pick = 2
 * <p>输出：2
 *
 *
 *
 * <p>提示：
 *
 * <p>  1 <= n <= 231 - 1
 * <p> 1 <= pick <= n
 * <p>https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch374GuessNumberHigherOrLower extends GuessGame {

  /**
   * <p>复杂度分析：
   *
   * <p>   时间复杂度： O(log2​n) 。为二分查找的时间复杂度。
   * <p>  空间复杂度：O(1) 。没有使用额外的空间。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/cai-shu-zi-da-xiao-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param n
   * @return
   */
  public int guessNumber(int n) {
    int low = 1;
    int high = n;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int res = guess(mid);
      if (res == 0) {
        return mid;
      } else if (res < 0) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度： O(log3​n) 。为三分查找所需的时间复杂度。
   * <p>   空间复杂度： O(1) 。没有使用额外的空间。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/cai-shu-zi-da-xiao-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param n
   * @return
   */
  public int guessNumber2(int n) {
    int low = 1;
    int high = n;
    while (low <= high) {
      int mid1 = low + (high - low) / 3;
      int mid2 = high - (high - low) / 3;
      int res1 = guess(mid1);
      int res2 = guess(mid2);
      if (res1 == 0) {
        return mid1;
      }
      if (res2 == 0) {
        return mid2;
      } else if (res1 < 0) {
        high = mid1 - 1;
      } else if (res2 > 0) {
        low = mid2 + 1;
      } else {
        low = mid1 + 1;
        high = mid2 - 1;
      }
    }
    return -1;
  }

  @Override
  public int guess(int num) {
    if (num == 6) {
      return 0;
    } else if (num < 6) {
      return -1;
    } else {
      return 1;
    }
  }
}

abstract class GuessGame {

  abstract int guess(int num);
}
