package org.company.meituan.all.week01.done;

/**
 * @author: wangrui
 * @date: 2021/5/14
 */
public class NCh001_912MergeSort归并排序 {

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
}
