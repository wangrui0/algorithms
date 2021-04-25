package org.leetcode.leet1000.ch950;

import java.util.Arrays;

/**
 * <p>905. 按奇偶排序数组
 *
 * <p>给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * <p>你可以返回满足此条件的任何数组作为答案。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：[3,1,2,4]
 * <p>输出：[2,4,3,1]
 * <p>输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= A.length <= 5000
 * <p>    0 <= A[i] <= 5000
 *
 * <p>通过次数50,303
 * <p>提交次数71,862
 * <p>在真实的面试中遇  到过这道题？
 * <p>https://leetcode-cn.com/problems/sort-array-by-parity/
 * <p>贡献者
 */
public class Ch905SortArrayByParity {

  public int[] sortArrayByParity(int[] A) {
    for (int i = 0, j = A.length - 1; i <= j; i++, j--) {
      while (i <= j && A[i] % 2 == 0) {
        i++;
      }
      while (i <= j && A[j] % 2 == 1) {
        j--;
      }
      if (i > j) {
        return A;
      }
      int tem = A[i];
      A[i] = A[j];
      A[j] = tem;
    }
    return A;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(NlogN)，其中 NNN 是 A 的长度。
   * <p> 空间复杂度：排序空间为 O(N)，取决于内置的 sort 函数实现。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/sort-array-by-parity/solution/an-qi-ou-pai-xu-shu-zu-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param A
   * @return
   */
  public int[] sortArrayByParity2(int[] A) {
    Integer[] B = new Integer[A.length];
    for (int t = 0; t < A.length; ++t) {
      B[t] = A[t];
    }

    Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));

    for (int t = 0; t < A.length; ++t) {
      A[t] = B[t];
    }
    return A;

        /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是 A 的长度。
   * <p> 空间复杂度：O(N)，存储结果的数组。
   *
   * @param A
   * @return
   */
  public int[] sortArrayByParity3(int[] A) {
    int[] ans = new int[A.length];
    int t = 0;

    for (int i = 0; i < A.length; ++i) {
      if (A[i] % 2 == 0) {
        ans[t++] = A[i];
      }
    }

    for (int i = 0; i < A.length; ++i) {
      if (A[i] % 2 == 1) {
        ans[t++] = A[i];
      }
    }

    return ans;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是 A 的长度。循环的每一步都让 j-i 至少减少了一。（注意虽然快排的复杂度是 O(NlogN)，但是我们只需要一轮扫描就可以了）。
   * <p> 空间复杂度：O(1)，不需要额外空间。
   *
   * @param A
   * @return
   */
  public int[] sortArrayByParity4(int[] A) {
    int i = 0, j = A.length - 1;
    while (i < j) {
      if (A[i] % 2 > A[j] % 2) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
      }

      if (A[i] % 2 == 0) {
        i++;
      }
      if (A[j] % 2 == 1) {
        j--;
      }
    }

    return A;
  }
}
