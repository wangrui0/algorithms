package org.leetcode.leet1500.ch1400;

import java.util.Arrays;

/**
 * <p>1385. 两个数组间的距离值
 *
 * <p>给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 *
 * <p>「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
 * <p>输出：2
 * <p>解释：
 * <p>对于 arr1[0]=4 我们有：
 * <p>|4-10|=6 > d=2
 * <p>|4-9|=5 > d=2
 * <p>|4-1|=3 > d=2
 * <p>|4-8|=4 > d=2
 * <p>所以 arr1[0]=4 符合距离要求
 *
 * <p>对于 arr1[1]=5 我们有：
 * <p>|5-10|=5 > d=2
 * <p>|5-9|=4 > d=2
 * <p>|5-1|=4 > d=2
 * <p>|5-8|=3 > d=2
 * <p>所以 arr1[1]=5 也符合距离要求
 *
 * <p>对于 arr1[2]=8 我们有：
 * <p>|8-10|=2 <= d=2
 * <p>|8-9|=1 <= d=2
 * <p>|8-1|=7 > d=2
 * <p>|8-8|=0 <= d=2
 * <p>存在距离小于等于 2 的情况，不符合距离要求
 *
 * <p>故而只有 arr1[0]=4 和 arr1[1]=5 两个符合距离要求，距离值为 2
 *
 * <p>示例 2：
 *
 * <p>输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
 * <p>输出：2
 *
 * <p>示例 3：
 *
 * <p>输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
 * <p>输出：1
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr1.length, arr2.length <= 500
 * <p>    -10^3 <= arr1[i], arr2[j] <= 10^3
 * <p>    0 <= d <= 100
 *
 * <p>通过次数11,259
 * <p>提交次数16,013
 * <p>https://leetcode-cn.com/problems/find-the-distance-value-between-two-arrays/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1385FindTheDistanceValueBetweenTwoArrays {

  /**
   * <P>方法一:模拟
   * <P>复杂度分析
   *
   * <P>假设 arr1 中元素个数为 n，arr2 中元素个数为 m。
   *
   * <P> 时间复杂度：从代码可以看出这里的渐进时间复杂度是 O(n×m)。
   *
   * <P>     空间复杂度：这里没有使用任何的辅助空间，故渐进空间复杂度为 O(1)。
   *
   * @param arr1
   * @param arr2
   * @param d
   * @return
   */
  public int findTheDistanceValue_1(int[] arr1, int[] arr2, int d) {
    int cnt = 0;
    for (int x : arr1) {
      boolean ok = true;
      for (int y : arr2) {
        ok &= Math.abs(x - y) > d;
      }
      cnt += ok ? 1 : 0;
    }
    return cnt;
  }

  /**
   * <p>复杂度分析
   *
   * <p>假设 arr1 中元素个数为 n，arr2 中元素个数为 m。
   *
   * <p> 时间复杂度：给 arr2 排序的时间代价是 O(mlogm)，对于 arr1 中的每个元素都在 arr2 中二分的时间代价是 O(nlogm)，故渐进时间复杂度为 O((n+m)logm)。
   *
   * <p>空间复杂度：这里没有使用任何的辅助空间，故渐进空间复杂度为 O(1)。
   *
   * @param arr1
   * @param arr2
   * @param d
   * @return
   */
  public int findTheDistanceValue_2(int[] arr1, int[] arr2, int d) {
    Arrays.sort(arr2);
    int cnt = 0;
    for (int x : arr1) {
      int p = binarySearch(arr2, x);
      boolean ok = true;
      //寻找大于等于他的最靠近的元素，然后只需要计算当前元素，和前一个元素就可以了
      if (p < arr2.length) {
        ok &= arr2[p] - x > d;
      }
      if (p - 1 >= 0 && p - 1 <= arr2.length) {
        ok &= x - arr2[p - 1] > d;
      }
      cnt += ok ? 1 : 0;
    }
    return cnt;
  }

  public int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    if (arr[high] < target) {
      return high + 1;
    }
    while (low < high) {
      int mid = (high - low) / 2 + low;
      if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

}
