package org.leetcode.shunxu.leet1500.ch1300;

/**
 * <p>1299. 将每个元素替换为右侧最大元素
 *
 * <p>给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 *
 * <p>完成所有替换操作后，请你返回这个数组。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [17,18,5,4,6,1]
 * <p>输出：[18,6,6,6,1,-1]
 * <p>解释：
 * <p>- 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
 * <p>- 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * <p>- 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * <p>- 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * <p>- 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
 * <p>- 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [400]
 * <p>输出：[-1]
 * <p>解释：下标 0 的元素右侧没有其他元素。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 104
 * <p>    1 <= arr[i] <= 105
 *
 * <p>通过次数27,017
 * <p>提交次数34,570
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1299ReplaceElementsWithGreatestElementOnRightSide {

  public static void main(String[] args) {
    System.out.println(replaceElements_2(new int[]{17, 18, 5, 4, 6, 1}));
  }

  /**
   * <p>方法一：逆序遍历
   *
   * <p>本题等价于对于数组 arr 中的每个元素 arr[i]，将其替换成 arr[i + 1], arr[i + 2], ..., arr[n - 1] 中的最大值。因此我们可以逆序地遍历整个数组，同时维护从数组右端到当前位置所有元素的最大值。
   *
   * <p>设 ans[i] = max(arr[i + 1], arr[i + 2], ..., arr[n - 1])，那么在进行逆序遍历时，我们可以直接通过
   *
   * <p> ans[i] = max(ans[i + 1], arr[i + 1])
   *
   * <p>
   */
  public static int[] replaceElements(int[] arr) {
    int pre = -1;
    for (int i = arr.length - 2; i >= 0; i--) {
      int temp = arr[i];
      if (i == arr.length - 2) {
        arr[i] = arr[i + 1];
      } else {
        arr[i] = Math.max(arr[i + 1], pre);
      }
      pre = temp;
    }
    arr[arr.length - 1] = -1;
    return arr;
  }

  public static int[] replaceElements_2(int[] arr) {
    int[] ans = new int[arr.length];

    for (int i = arr.length - 2; i >= 0; i--) {
      ans[i] = Math.max(ans[i + 1], arr[i + 1]);
    }
    ans[arr.length - 1] = -1;
    return ans;
  }
}
