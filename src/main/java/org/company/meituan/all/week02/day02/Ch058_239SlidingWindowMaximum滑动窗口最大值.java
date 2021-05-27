package org.company.meituan.all.week02.day02;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * <p>239. 滑动窗口最大值
 *
 * <p>给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * <p>返回滑动窗口中的最大值。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * <p>输出：[3,3,5,5,6,7]
 * <p>解释：
 * <p>滑动窗口的位置                最大值
 * <p>---------------               -----
 * <p>[1  3  -1] -3  5  3  6  7       3
 * <p> 1 [3  -1  -3] 5  3  6  7       3
 * <p> 1  3 [-1  -3  5] 3  6  7       5
 * <p> 1  3  -1 [-3  5  3] 6  7       5
 * <p> 1  3  -1  -3 [5  3  6] 7       6
 * <p> 1  3  -1  -3  5 [3  6  7]      7
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1], k = 1
 * <p>输出：[1]
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1,-1], k = 1
 * <p>输出：[1,-1]
 *
 * <p>示例 4：
 *
 * <p>输入：nums = [9,11], k = 2
 * <p>输出：[11]
 *
 * <p>示例 5：
 *
 * <p>输入：nums = [4,-2], k = 2
 * <p>输出：[4]
 *
 *
 *
 * <p>提示：
 *
 * <p>  1 <= nums.length <= 105
 * <p>  -104 <= nums[i] <= 104
 * <p>  1 <= k <= nums.length
 *
 * <p>通过次数153,686
 * <p>提交次数310,378
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/sliding-window-maximum/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class Ch058_239SlidingWindowMaximum滑动窗口最大值 {

  /**
   * <p>方法一：优先队列
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(nlogn)，其中 n 是数组 nums 的长度。在最坏情况下，数组 nums 中的元素单调递增，那么最终优先队列中包含了所有元素，没有元素被移除。由于将一个元素放入优先队列的时间复杂度为
   * O(logn)，因此总时间复杂度为 O(nlogn)。
   *
   * <p>空间复杂度：O(n)，即为优先队列需要使用的空间。这里所有的空间复杂度分析都不考虑返回的答案需要的 O(n) 空间，只计算额外的空间使用。
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow_1(int[] nums, int k) {
    int n = nums.length;
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      public int compare(int[] pair1, int[] pair2) {
        return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
      }
    });
    for (int i = 0; i < k; ++i) {
      pq.offer(new int[]{nums[i], i});
    }
    int[] ans = new int[n - k + 1];
    ans[0] = pq.peek()[0];
    for (int i = k; i < n; ++i) {
      pq.offer(new int[]{nums[i], i});
      while (pq.peek()[1] <= i - k) {
        pq.poll();
      }
      ans[i - k + 1] = pq.peek()[0];
    }
    return ans;
  }

  /**
   * <p>方法二：单调队列
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(n)，其中 n 是数组 nums 的长度。每一个下标恰好被放入队列一次，并且最多被弹出队列一次，因此时间复杂度为 O(n)。
   *
   * <p> 空间复杂度：O(k)。与方法一不同的是，在方法二中我们使用的数据结构是双向的，因此「不断从队首弹出元素」保证了队列中最多不会有超过 k+1 个元素，因此队列使用的空间为 O(k)。
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow_2(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> deque = new LinkedList<Integer>();
    for (int i = 0; i < k; ++i) {
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
    }


    int[] ans = new int[n - k + 1];
    ans[0] = nums[deque.peekFirst()];
    for (int i = k; i < n; ++i) {
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      while (deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      ans[i - k + 1] = nums[deque.peekFirst()];
    }
    return ans;
  }

  /**
   * <p> 方法三：分块 + 预处理
   * <p> 复杂度分析
   *
   * <p>  时间复杂度：O(n)，其中 n 是数组 nums 的长度。我们需要 O(n) 的时间预处理出数组 prefixMax，suffixMax 以及计算答案。
   *
   * <p>  空间复杂度：O(n)，即为存储 prefixMax 和 suffixMax 需要的空间。
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] prefixMax = new int[n];
    int[] suffixMax = new int[n];
    for (int i = 0; i < n; ++i) {
      if (i % k == 0) {
        prefixMax[i] = nums[i];
      } else {
        prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
      }
    }
    for (int i = n - 1; i >= 0; --i) {
      if (i == n - 1 || (i + 1) % k == 0) {
        suffixMax[i] = nums[i];
      } else {
        suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
      }
    }

    int[] ans = new int[n - k + 1];
    for (int i = 0; i <= n - k; ++i) {
      ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
    }
    return ans;
  }


}
