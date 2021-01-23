package org.leetcode.easy;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * <p>
 * 输出：4
 * <p>
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 0
 * <p>
 * <p> 输出：0
 *
 * <p> 示例 3：
 *
 * <p> 输入：n = 1
 * <p> 输出：0
 *
 *
 *
 * <p> 提示：
 *
 * <p>     0 <= n <= 5 ^ 106
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/count-primes
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p> @author: wangrui
 * <p> @date: 2021/1/22
 */
public class Ch0204CountPrimes {

  /**
   * <p> 很直观的思路是我们枚举每个数判断其是不是质数。
   *
   * <p> 考虑质数的定义：在大于 1 的自然数中，除了 1 和它本身以外不再有其他因数的自然数。因此对于每个数 x，我们可以从小到大枚举 [2,x−1] 中的每个数 y，判断 y 是否为 x
   * 的因数。但这样判断一个数是否为质数的时间复杂度最差情况下会到 O(n)，无法通过所有测试数据。
   *
   * <p> 考虑到如果 y 是 x 的因数，那么 x/y​ 也必然是 x 的因数，因此我们只要校验 y 或者 x/y​ 即可。而如果我们每次选择校验两者中的较小数，则不难发现较小数一定落在 [2,sqrt{x}]
   * <p> ​ 的区间中，因此我们只需要枚举[2,sqrt{x}]
   * <p> ​中的所有数即可，这样单次检查的时间复杂度从O(n) 降低至了O(sqrt{n})
   * <p> ​。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * ===============
   * <p> 时间复杂度：O(nsqrt{n})
   * <p> 空间复杂度：O(1)。
   *
   * @param n
   * @return
   */
  public int countPrimes(int n) {
    int ans = 0;
    for (int i = 2; i < n; ++i) {
      ans += isPrime(i) ? 1 : 0;
    }
    return ans;
  }

  public boolean isPrime(int x) {
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * <p>  枚举没有考虑到数与数的关联性，因此难以再继续优化时间复杂度。接下来我们介绍一个常见的算法，该算法由希腊数学家厄拉多塞（Eratosthenes）提出，称为厄拉多塞筛法，简称埃氏筛。
   *
   * <p>  我们考虑这样一个事实：如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,…2x,3x… 一定不是质数，因此我们可以从这里入手。
   *
   * <p>  我们设 isPrime[i] 表示数 i 是不是质数，如果是质数则为 1，否则为 0。从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即
   * 000，这样在运行结束的时候我们即能知道质数的个数。
   *
   * <p>  这种方法的正确性是比较显然的：这种方法显然不会将质数标记成合数；另一方面，当从小到大遍历到数 x 时，倘若它是合数，则它一定是某个小于 x 的质数 y 的整数倍，故根据此方法的步骤，我们在遍历到 y
   * 时，就一定会在此时将
   * x 标记为 isPrime[x]=0。因此，这种方法也不会将合数标记为质数。
   *
   * <p>  当然这里还可以继续优化，对于一个质数 x，如果按上文说的我们从 2x 开始标记其实是冗余的，应该直接从 x⋅x 开始标记，因为 2x,3x,…2x,3x,这些数一定在 x 之前就被其他数的倍数标记过了，例如 2
   * 的所有倍数，3 的所有倍数等。
   *
   * <p>  作者：LeetCode-Solution
   * <p>  链接：https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/
   * <p>  来源：力扣（LeetCode）
   * <p>  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * <p>
   * ======================
   * <p>  复杂度分析
   *
   * <p>   时间复杂度：O(nlogn)
   * <p>  空间复杂度：O(n)的空间记录每个数是否为质数。
   *
   * <p>  作者：LeetCode-Solution
   * <p>  链接：https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/
   * <p>  来源：力扣（LeetCode）
   * <p>  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param n
   * @return
   */
  public int countPrimes2(int n) {
    int[] isPrime = new int[n];
    Arrays.fill(isPrime, 1);
    int ans = 0;
    for (int i = 2; i < n; ++i) {
      if (isPrime[i] == 1) {
        ans += 1;
        if ((long) i * i < n) {
          for (int j = i * i; j < n; j += i) {
            isPrime[j] = 0;
          }
        }
      }
    }
    return ans;
  }

}
