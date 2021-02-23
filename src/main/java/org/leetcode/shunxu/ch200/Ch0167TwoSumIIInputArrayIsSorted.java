package org.leetcode.shunxu.ch200;

import java.util.HashMap;
import java.util.Map;

/**
 * 167. 两数之和 II - 输入有序数组
 * <P> 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <P> 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <P> 说明:
 * <P> 返回的下标值（index1 和 index2）不是从零开始的。
 * <P> 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <P> 示例:
 * <P> 输入: numbers = [2, 7, 11, 15], target = 9
 * <P> 输出: [1,2]
 * <P> 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <P> 来源：力扣（LeetCode）
 * <P> 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * <P> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/12/12
 */
public class Ch0167TwoSumIIInputArrayIsSorted {

  /**
   * <P>self 以前有这种思想，不过 (1) 不要求numbers有序; (2) 不要求返回值大小
   * <P>时间复杂度:O(n)
   * <P> 空间复杂度:O(n)
   *
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      int other = target - numbers[i];
      if (map.containsKey(other)) {
        Integer num = map.get(other);
        int other1 = Math.min(num, i);
        int other2 = Math.max(num, i);
        return new int[]{other1 + 1, other2 + 1};
      }
      map.put(numbers[i], i);
    }
    return null;
  }

  /**
   * <P> 官方：二分查找
   * <P> 时间复杂度:O(nlogn)
   * <P> 空间复杂度：O(1)
   *
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum2(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; ++i) {
      int low = i + 1, high = numbers.length - 1;
      while (low <= high) {
        int mid = (high - low) / 2 + low;
        if (numbers[mid] == target - numbers[i]) {
          return new int[]{i + 1, mid + 1};
        } else if (numbers[mid] > target - numbers[i]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }
    return new int[]{-1, -1};
  }

  /**
   * <P>官方：双指针
   * <P>时间复杂度：O(n)，其中 n 是数组的长度。两个指针移动的总次数最多为 n 次。
   * <p>
   * <P>空间复杂度：O(1)。
   *
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum3(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1;
    while (low < high) {
      int sum = numbers[low] + numbers[high];
      if (sum == target) {
        return new int[]{low + 1, high + 1};
      } else if (sum < target) {
        ++low;
      } else {
        --high;
      }
    }
    return new int[]{-1, -1};
  }

  public int[] twoSum4(int[] numbers, int target) {
    int low = 0;
    int height = numbers.length - 1;
    while (low < height) {
      int sum = numbers[low] + numbers[height];
      if (sum == target) {
        return new int[]{low + 1, height + 1};
      } else if (sum < target) {
        low++;
      } else {
        height--;
      }
    }
    return new int[]{-1, -1};
  }


  public int[] twoSum5(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      int left = i + 1, right = numbers.length - 1;
      while (left < right) {
        int mid = (left + right) / 2;
        if (target == numbers[i] + numbers[mid]) {
          return new int[]{left + 1, mid + 1};
        } else if (target < numbers[i] + numbers[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return new int[]{-1, -1};
  }

}
