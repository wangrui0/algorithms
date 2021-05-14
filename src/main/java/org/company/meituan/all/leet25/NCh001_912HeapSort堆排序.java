package org.company.meituan.all.leet25;

/**
 * @author: wangrui
 * @date: 2021/5/9
 */
public class NCh001_912HeapSort堆排序 {

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

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
