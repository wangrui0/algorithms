package org.company.meituan.all.leet25;

import java.util.Random;

/**
 * <p>215. 数组中的第K个最大元素
 *
 * <p>在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * <p>示例 1:
 *
 * <p>输入: [3,2,1,5,6,4] 和 k = 2
 * <p>输出: 5
 *
 * <p>示例 2:
 *
 * <p>输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * <p>输出: 4
 *
 * <p>说明:
 *
 * <p>你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class NCh013_215KthLargestElementInAnArray数组中的第K个最大元素 {

  Random random = new Random();

  /**
   * 基于快速排序
   *
   * @param nums
   * @param k
   * @return
   */
  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }

  public int quickSelect(int[] a, int l, int r, int index) {
    int q = randomPartition(a, l, r);
    if (q == index) {
      return a[q];
    } else {
      return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
    }
  }

  public int randomPartition(int[] a, int l, int r) {
    int i = random.nextInt(r - l + 1) + l;
    swap(a, i, r);
    return partition(a, l, r);
  }

  public int partition(int[] a, int l, int r) {
    int x = a[r], i = l - 1;
    for (int j = l; j < r; ++j) {
      if (a[j] <= x) {
        swap(a, ++i, j);
      }
    }
    swap(a, i + 1, r);
    return i + 1;
  }

  public void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  /**
   * 基于堆排序
   *
   * @param nums
   * @param k
   * @return
   */
  public int findKthLargest_2(int[] nums, int k) {
    int heapSize = nums.length;
    buildMaxHeap(nums, heapSize);
    for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
      swap(nums, 0, i);
      --heapSize;
      maxHeapify(nums, 0, heapSize);
    }
    return nums[0];
  }

  public void buildMaxHeap(int[] a, int heapSize) {
    for (int i = heapSize / 2; i >= 0; --i) {
      maxHeapify(a, i, heapSize);
    }
  }

  public void maxHeapify(int[] a, int i, int heapSize) {
    int l = i * 2 + 1, r = i * 2 + 2, largest = i;
    if (l < heapSize && a[l] > a[largest]) {
      largest = l;
    }
    if (r < heapSize && a[r] > a[largest]) {
      largest = r;
    }
    if (largest != i) {
      swap(a, i, largest);
      maxHeapify(a, largest, heapSize);
    }
  }

}


