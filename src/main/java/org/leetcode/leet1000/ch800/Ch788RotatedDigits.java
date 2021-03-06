package org.leetcode.leet1000.ch800;

/**
 * <p>788. 旋转数字
 *
 * <p>我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * <p>如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9
 * <p>同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * <p>现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 *
 *
 * <p>示例：
 *
 * <p>输入: 10
 * <p>输出: 4
 * <p>解释:
 * <p>在[1, 10]中有四个好数： 2, 5, 6, 9。
 * <p>注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 *
 *
 *
 * <p>提示：
 *
 * <p>    N 的取值范围是 [1, 10000]。
 *
 * <p>通过次数16,001
 * <p>提交次数26,465
 * <p>https://leetcode-cn.com/problems/rotated-digits/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch788RotatedDigits {

  /**
   * <p>方法一：暴力解法【通过】
   * <p><p>复杂度分析
   *
   * <p><p>   时间复杂度：O(NlogN)，检查每个 X 的每一位数字。
   *
   * <p><p>  空间复杂度：O(logN)，存储字符串或者 good 函数的调用栈。
   *
   * <p>@param N
   * <p>@return
   */
  public int rotatedDigits(int N) {
    // Count how many n in [1, N] are good.
    int ans = 0;
    for (int n = 1; n <= N; ++n) {
      if (good(n, false)) {
        ans++;
      }
    }
    return ans;
  }

  // Return true if n is good.
  // The flag is true iff we have an occurrence of 2, 5, 6, 9.
  public boolean good(int n, boolean flag) {
    if (n == 0) {
      return flag;
    }

    int d = n % 10;
    if (d == 3 || d == 4 || d == 7) {
      return false;
    }
    if (d == 0 || d == 1 || d == 8) {
      return good(n / 10, flag);
    }
    return good(n / 10, true);
  }

  /**
   * 方法二：动态规划【通过】
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(logN)，在 N 的每位数字上计算花费的时间。
   *
   * <p>    空间复杂度：O(logN)，memo 的存储空间。
   *
   * <p>@param N
   * <p>@return
   */
  public int rotatedDigits2(int N) {
    char[] A = String.valueOf(N).toCharArray();
    int K = A.length;

    int[][][] memo = new int[K + 1][2][2];
    memo[K][0][1] = memo[K][1][1] = 1;
    for (int i = K - 1; i >= 0; --i) {
      for (int eqf = 0; eqf <= 1; ++eqf) {
        for (int invf = 0; invf <= 1; ++invf) {
          // We will compute ans = memo[i][eqf][invf],
          // the number of good numbers with respect to N = A[i:].
          // If eqf is true, we must stay below N, otherwise
          // we can use any digits.
          // Invf becomes true when we write a 2569, and it
          // must be true by the end of our writing as all
          // good numbers have a digit in 2569.
          int ans = 0;
          for (char d = '0'; d <= (eqf == 1 ? A[i] : '9'); ++d) {
            if (d == '3' || d == '4' || d == '7') {
              continue;
            }
            boolean invo = (d == '2' || d == '5' || d == '6' || d == '9');
            ans += memo[i + 1][d == A[i] ? eqf : 0][invo ? 1 : invf];
          }
          memo[i][eqf][invf] = ans;
        }
      }
    }

    return memo[0][1][0];
  }
}
