package org.company.meituan;

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
public class A001排序数组 {

  /**
   * <p> 方法一：快速排序
   * <p>复杂度分析
   *
   * <p> 时间复杂度：基于随机选取主元的快速排序时间复杂度为期望 O(nlog⁡n)O(n\log n)O(nlogn)，其中 nnn 为数组的长度。详细证明过程可以见《算法导论》第七章，这里不再大篇幅赘述。
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
      int pos = randomizedPartition(nums, l, r);
      randomizedQuicksort(nums, l, pos - 1);
      randomizedQuicksort(nums, pos + 1, r);
    }
  }

  public int randomizedPartition(int[] nums, int l, int r) {
    int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
    swap(nums, r, i);
    return partition(nums, l, r);
  }

  public int partition(int[] nums, int l, int r) {
    int pivot = nums[r];
    int i = l - 1;
    for (int j = l; j <= r - 1; ++j) {
      if (nums[j] <= pivot) {
        i = i + 1;
        swap(nums, i, j);
      }
    }
    swap(nums, i + 1, r);
    return i + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  /**
   * <p>方法二：堆排序
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(nlogn)。初始化建堆的时间复杂度为 O(n)，建完堆以后需要进行 n−1 次调整，一次调整（即 maxHeapify） 的时间复杂度为 O(logn)，那么 n−1n-1n−1 次调整即需要
   * O(nlogn) 的时间复杂度。因此，总时间复杂度为 O(nlogn)。
   *
   * <p>  空间复杂度：O(1)。只需要常数的空间存放若干变量。
   *
   * @param nums
   * @return
   */
  public int[] sortArray_2(int[] nums) {
    heapSort(nums);
    return nums;
  }

  public void heapSort(int[] nums) {
    int len = nums.length - 1;
    buildMaxHeap(nums, len);
    for (int i = len; i >= 1; --i) {
      swap(nums, i, 0);
      len -= 1;
      maxHeapify(nums, 0, len);
    }
  }

  public void buildMaxHeap(int[] nums, int len) {
    for (int i = len / 2; i >= 0; --i) {
      maxHeapify(nums, i, len);
    }
  }

  public void maxHeapify(int[] nums, int i, int len) {
    for (; (i << 1) + 1 <= len; ) {
      int lson = (i << 1) + 1;
      int rson = (i << 1) + 2;
      int large;
      if (lson <= len && nums[lson] > nums[i]) {
        large = lson;
      } else {
        large = i;
      }
      if (rson <= len && nums[rson] > nums[large]) {
        large = rson;
      }
      if (large != i) {
        swap(nums, i, large);
        i = large;
      } else {
        break;
      }
    }
  }

  int[] tmp;

  /**
   * 方法三：归并排序
   *
   * @param nums
   * @return
   */
  public int[] sortArray2(int[] nums) {
    tmp = new int[nums.length];
    mergeSort(nums, 0, nums.length - 1);
    return nums;
  }

  public void mergeSort(int[] nums, int l, int r) {
    if (l >= r) {
      return;
    }
    int mid = (l + r) >> 1;
    mergeSort(nums, l, mid);
    mergeSort(nums, mid + 1, r);
    int i = l, j = mid + 1;
    int cnt = 0;
    while (i <= mid && j <= r) {
      if (nums[i] <= nums[j]) {
        tmp[cnt++] = nums[i++];
      } else {
        tmp[cnt++] = nums[j++];
      }
    }
    while (i <= mid) {
      tmp[cnt++] = nums[i++];
    }
    while (j <= r) {
      tmp[cnt++] = nums[j++];
    }
    for (int k = 0; k < r - l + 1; ++k) {
      nums[k + l] = tmp[k];
    }
  }

  public int[] quickSort2(int[] arr, int low, int high) {
    if (low >= high) {
      return arr;
    }
    int i = low, j = high;
    int posValue = arr[i];
    while (i < j) {
      while (i < j && arr[j] >= posValue) {
        j--;
      }
      while (i < j && arr[i] <= posValue) {
        i++;
      }
      if (i < j) {
        swap(arr, i, j);
      }
    }
    swap(arr, low, i);
    quickSort2(arr, low, i - 1);
    quickSort2(arr, i + 1, high);
    return arr;
  }
/**
 * 方法四：计数排序（桶排序）
 *
 * @param nums
 * @return
 */


}
