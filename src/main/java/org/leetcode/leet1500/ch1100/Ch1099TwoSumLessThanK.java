package org.leetcode.leet1500.ch1100;

import java.util.Arrays;

/**
 * <p>小于K的两数之和
 * <p>1. 题目
 * <p>给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
 *
 * <p>如不存在这样的两个元素，请返回 -1。
 *
 * <p>示例 1：
 * <p>输入：A = [34,23,1,24,75,33,54,8], K = 60
 * <p>输出：58
 * <p>解释：
 * <p>34 和 24 相加得到 58，58 小于 60，满足题意。
 *
 * <p>示例 2：
 * <p>输入：A = [10,20,30], K = 15
 * <p>输出：-1
 * <p>解释：
 * <p>我们无法找到和小于 15 的两个元素。
 *
 * <p>提示：
 * <p>1 <= A.length <= 100
 * <p>1 <= A[i] <= 1000
 * <p>1 <= K <= 2000
 * <p>https://leetcode-cn.com/problems/two-sum-less-than-k/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1099TwoSumLessThanK {

  /**
   * 太聪明了啊
   *
   * @param A
   * @param K
   * @return
   */
  public int twoSumLessThanK(int[] A, int K) {
    if (A == null || A.length == 0) {
      return 0;
    }
    Arrays.sort(A);
    int left = 0;
    int right = A.length - 1;
    int result = Integer.MIN_VALUE;
    while (left < right) {
      if (A[left] + A[right] < K) {
        result = Math.max(result, A[left] + A[right]);
        left++;
      } else {
        right--;
      }
    }
    return result == Integer.MIN_VALUE ? -1 : result;
  }

  public int twoSumLessThanK_2(int[] A, int K) {
    if (A == null || A.length == 0) return 0;
    Arrays.sort(A);
    int left = 0;
    int right = A.length - 1;
    int result = Integer.MIN_VALUE;
    while (left < right) {
      if (A[left] + A[right] < K) {
        result = Math.max(result, A[left] + A[right]);
        left++;
      } else {
        right--;
      }
    }
    return result == Integer.MIN_VALUE ? -1 : result;
  }

//    public:
//    int twoSumLessThanK(vector<int>& A, int K) {
//      int i, j, n = A.size(), sum, mindiff = INT_MAX;
//      for(i = 0; i < n-1; ++i)
//      {
//        for(j = i + 1; j < n; ++j)
//        {
//          if(A[i]+A[j] < K && K-A[i]-A[j] < mindiff)
//          {
//            mindiff = K-A[i]-A[j];
//            sum = A[i]+A[j];
//          }
//        }
//      }
//      return mindiff==INT_MAX ? -1 : sum;
//    }

//  public:
//  int twoSumLessThanK(vector<int>& A, int K) {
//    sort(A.begin(), A.end());
//    int sum, mindiff = INT_MAX, l, r, mid, t;
//    for(int i = 0; i < A.size(); ++i)
//    {
//      l = 0, r = A.size()-1;
//      t = K-A[i];//找到小于t的最大数
//      while(l <= r)
//      {
//        mid = l+((r-l)>>1);
//        if(A[mid] >= t)
//          r = mid-1;
//        else
//        {
//          if(mid==A.size()-1 || A[mid+1] >= t)
//          {	//找到了
//            if(mid != i && K-A[mid]-A[i] < mindiff)
//            {	//不是同一个数，且更接近
//              mindiff = K-A[mid]-A[i];
//              sum = A[mid]+A[i];
//            }
//            break;
//          }
//          else
//            l = mid+1;
//        }
//      }
//    }
//    return mindiff==INT_MAX ? -1 : sum;
//  }
}
