package org.company.meituan.all.week01.done;

import java.util.Random;

/**
 * <p>|补充题4. 手撕快速排序
 * 912. 排序数组
 *
 * <p>给你一个整数数组 nums，请你将该数组升序排列。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [5,2,3,1]
 * <p>输出：[1,2,3,5]
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [5,1,1,2,0,0]
 * <p>输出：[0,0,1,1,2,5]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 50000
 * <p>    -50000 <= nums[i] <= 50000
 * |4|https://leetcode-cn.com/problems/sort-an-array|
 * <p>通过次数144,869
 * <p>提交次数245,267
 * <p>@author: wangrui
 * <p>@date: 2021/4/29
 */
public class NCh001_912QuickSort快速排序 {

  public static void main(String[] args) {
    NCh001_912QuickSort快速排序 n = new NCh001_912QuickSort快速排序();
    n.sortArray(new int[]{5, 1, 1, 2, 0, 0});
  }

  /**
   * <p> 方法一：快速排序
   * <p>复杂度分析
   *
   * <p> 时间复杂度：基于随机选取主元的快速排序时间复杂度为期望 O(nlogn)，其中 n 为数组的长度。详细证明过程可以见《算法导论》第七章，这里不再大篇幅赘述。
   *
   * <p>空间复杂度：O(h)，其中 h 为快速排序递归调用的层数。我们需要额外O(h) 的递归调用的栈空间，
   * <p>由于划分的结果不同导致了快速排序递归调用的层数也会不同，最坏情况下需 O(n)
   * <p>的空间，最优情况下每次都平衡，此时整个递归树高度为 nlogn，空间复杂度为 O(logn)。
   *
   * @param nums
   * @return
   */
  public int[] sortArray(int[] nums) {
    randomizedQuicksort(nums, 0, nums.length - 1);
    return nums;
  }

  public void randomizedQuicksort(int[] nums, int l, int r) {
    if (l < r) {
      //选基准点,并且将数据变为，左边都比他小，右边都比他大
      int pos = randomizedPartition(nums, l, r);
      //对左边的数字，进行快速排序
      randomizedQuicksort(nums, l, pos - 1);
      //对右边的数字，进行快速排序
      randomizedQuicksort(nums, pos + 1, r);
    }
  }

  //选基准点
  public int randomizedPartition(int[] nums, int l, int r) {
    // 随机选一个作为基准点
    int i = new Random().nextInt(r - l + 1) + l;
    swap(nums, r, i);
    //快速排序
    return partition(nums, l, r);
  }

  //  双指针法,i 指针指向比r 小的元素的最右面的下标。j 代表遍历到哪个元素
  public int partition(int[] nums, int l, int r) {
    //基准点
    int pivot = nums[r];
    int i = l - 1;
    for (int j = l; j <= r - 1; ++j) {
      if (nums[j] <= pivot) {
        i = i + 1;
        swap(nums, i, j);
      }
    }
    //交换第一个比pivot 大的元素与基准点，那么右边的元素都是比他大的，左边的元素都是比他小的
    swap(nums, i + 1, r);
    return i + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
