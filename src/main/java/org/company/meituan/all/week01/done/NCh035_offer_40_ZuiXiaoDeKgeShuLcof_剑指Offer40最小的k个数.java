package org.company.meituan.all.week01.done;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * <p>剑指 Offer 40. 最小的k个数
 *
 * <p>输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [3,2,1], k = 2
 * <p>输出：[1,2] 或者 [2,1]
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [0,1,2,1], k = 1
 * <p>输出：[0]
 *
 *
 *
 * <p>限制：
 *
 * <p>    0 <= k <= arr.length <= 10000
 * <p>    0 <= arr[i] <= 10000
 *
 * <p>通过次数182,603
 * <p>提交次数321,172
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh035_offer_40_ZuiXiaoDeKgeShuLcof_剑指Offer40最小的k个数 {

  /**
   * <p> 方法一:排序
   * <p> 复杂度分析
   * <p>
   * <p>   时间复杂度：O(nlogn)，其中 n是数组 arr 的长度。算法的时间复杂度即排序的时间复杂度。
   *
   * <p>   空间复杂度：O(logn)，排序所需额外的空间复杂度为 O(logn)。
   *
   * @param arr
   * @param k
   * @return
   */
  public int[] getLeastNumbers(int[] arr, int k) {
    int[] vec = new int[k];
    Arrays.sort(arr);
    for (int i = 0; i < k; ++i) {
      vec[i] = arr[i];
    }
    return vec;
  }

  /**
   * <p> 方法二：堆
   * 我们用一个大根堆实时维护数组的前 k 小值。首先将前 k 个数插入大根堆中，随后从第 k+1 个数开始遍历，
   * 如果当前遍历到的数比大根堆的堆顶的数要小，就把堆顶的数弹出，再插入当前遍历到的数。最后将大根堆里的数存入数组返回即可。
   * 在下面的代码中，由于 C++ 语言中的堆（即优先队列）为大根堆，我们可以这么做。
   * 而 Python 语言中的堆为小根堆，因此我们要对数组中所有的数取其相反数，才能使用小根堆维护前 kkk 小值。
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(nlog⁡k)O(n\log k)O(nlogk)，其中 nnn 是数组 arr 的长度。由于大根堆实时维护前 kkk 小值，所以插入删除都是 O(log⁡k)O(\log k)O(logk)
   * 的时间复杂度，最坏情况下数组里 nnn 个数都会插入，所以一共需要 O(nlog⁡k)O(n\log k)O(nlogk) 的时间复杂度。
   *
   * <p>    空间复杂度：O(k)O(k)O(k)，因为大根堆里最多 kkk 个数。
   *
   * @param arr
   * @param k
   * @return
   */
  public int[] getLeastNumbers_2(int[] arr, int k) {
    int[] vec = new int[k];
    if (k == 0) { // 排除 0 的情况
      return vec;
    }
    //大顶堆
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>((num1, num2) -> num2 - num1);
    for (int i = 0; i < k; ++i) {
      queue.offer(arr[i]);
    }
    for (int i = k; i < arr.length; ++i) {
      if (queue.peek() > arr[i]) {
        queue.poll();
        queue.offer(arr[i]);
      }
    }
    for (int i = 0; i < k; ++i) {
      vec[i] = queue.poll();
    }
    return vec;
  }

  /**
   * <p> 方法三：快排思想
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：期望为 O(n)O(n)O(n) ，由于证明过程很繁琐，所以不再这里展开讲。具体证明可以参考《算法导论》第 9 章第 2 小节。
   *
   * <p>   最坏情况下的时间复杂度为 O(n2)O(n^2)O(n2)。情况最差时，每次的划分点都是最大值或最小值，一共需要划分 n−1n - 1n−1 次，而一次划分需要线性的时间复杂度，所以最坏情况下时间复杂度为
   * O(n2)O(n^2)O(n2)。
   *
   * <p>  空间复杂度：期望为 O(log⁡n)O(\log n)O(logn)，递归调用的期望深度为 O(log⁡n)O(\log n)O(logn)，每层需要的空间为 O(1)O(1)O(1)，只有常数个变量。
   *
   * <p>   最坏情况下的空间复杂度为 O(n)O(n)O(n)。最坏情况下需要划分 nnn 次，即 randomized_selected 函数递归调用最深 n−1n - 1n−1 层，而每层由于需要 O(1)O(1)O(1)
   * 的空间，所以一共需要 O(n)O(n)O(n) 的空间复杂度。
   */
  public int[] getLeastNumbers_3(int[] arr, int k) {
    randomizedSelected(arr, 0, arr.length - 1, k);
    int[] vec = new int[k];
    for (int i = 0; i < k; ++i) {
      vec[i] = arr[i];
    }
    return vec;
  }

  private void randomizedSelected(int[] arr, int l, int r, int k) {
    if (l >= r) {
      return;
    }
    int pos = randomizedPartition(arr, l, r);
    int num = pos - l + 1;
    if (k == num) {
      return;
    } else if (k < num) {
      randomizedSelected(arr, l, pos - 1, k);
    } else {
      randomizedSelected(arr, pos + 1, r, k - num);
    }
  }

  // 基于随机的划分
  private int randomizedPartition(int[] nums, int l, int r) {
    int i = new Random().nextInt(r - l + 1) + l;
    swap(nums, r, i);
    return partition(nums, l, r);
  }

  private int partition(int[] nums, int l, int r) {
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


}


