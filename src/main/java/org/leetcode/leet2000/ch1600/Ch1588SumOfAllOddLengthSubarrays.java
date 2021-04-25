package org.leetcode.leet2000.ch1600;

/**
 * <p>1588. 所有奇数长度子数组的和
 *
 * <p>给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * <p>子数组 定义为原数组中的一个连续子序列。
 *
 * <p>请你返回 arr 中 所有奇数长度子数组的和 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [1,4,2,5,3]
 * <p>输出：58
 * <p>解释：所有奇数长度子数组和它们的和为：
 * <p>[1] = 1
 * <p>[4] = 4
 * <p>[2] = 2
 * <p>[5] = 5
 * <p>[3] = 3
 * <p>[1,4,2] = 7
 * <p>[4,2,5] = 11
 * <p>[2,5,3] = 10
 * <p>[1,4,2,5,3] = 15
 * <p>我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1,2]
 * <p>输出：3
 * <p>解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [10,11,12]
 * <p>输出：66
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 100
 * <p>    1 <= arr[i] <= 1000
 *
 * <p>通过次数18,398
 * <p>提交次数22,948
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1588SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays_2(new int[]{1, 4, 2, 5, 3}));
    }

    /**
     * 时间O(n^3)
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; i + j - 1 < arr.length; j += 2) {
                sum += accumulate(i, i + j - 1, arr);
            }
        }
        return sum;
    }

    public static int accumulate(int i, int j, int[] arr) {
        int sum = 0;
        for (int index = i; index <= j; index++) {
            sum += arr[index];
        }
        return sum;
    }

    /**
     * 在上面的解法中，accumulate的本质就是在计算从 arr[i] 到 arr[i + j - 1] 的连续子数组的和。计算连续子数组的和，很容想到可以使用前缀和（Prefix Sum）的方式。使用 O(n) 的时间可以预处理前缀和数组，之后使用 O(1) 的时间即可计算出一个连续子数组的和。
     * <p>
     * 时间复杂度是 O(n^2) 的，空间复杂度是 O(n) 的。
     * <p>
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays_2(int[] arr) {
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; i + j - 1 < arr.length; j += 2) {
                if (i == 0) {
                    ans += sum[j - 1];
                } else {
                    ans += sum[i + j - 1] - sum[i - 1];
                }
            }
        }
        return ans;
    }

    /**
     * 下面重点来了。这个问题有 O(n) 的解法。
     * <p>
     * 其实想法很简单，相对也比较套路。就是遍历一遍所有的元素，然后查看这个元素会在多少个长度为奇数的数组中出现过。
     * <p>
     * <p>
     * <p>
     * 比如题目给出的第一个测试用例 [1, 4, 2, 5, 3] 中；
     * <p>
     * 1 在 3 个长度为奇数的数组中出现过：[1], [1, 4, 2], [1, 4, 2, 5, 3]；所以最终的和，要加上 1 * 3；
     * <p>
     * 4 在 4 个长度为奇数的数组中出现过：[4], [4, 2, 5], [1, 4, 2], [1, 4, 2, 5, 3]；所以最终和，要加上 4 * 4；
     * <p>
     * 2 在 5 个长度为奇数的数组中出现过：[2], [2, 5, 3], [4, 2, 5], [1, 4, 2], [1, 4, 2, 5, 3]；所以最终和，要加上 5 * 2；
     * <p>
     * ...
     * <p>
     * 下面的关键就是，如何计算一个数字在多少个奇数长度的数组中出现过？
     * <p>
     * <p>
     * <p>
     * 对于一个数字，它所在的数组，可以在它前面再选择 0, 1, 2, ... 个数字，一共有 left = i + 1 个选择；
     * <p>
     * 可以在它后面再选择 0, 1, 2, ... 个数字，一共有 right = n - i 个选择。
     * <p>
     * 如果在前面选择了偶数个数字，那么在后面，也必须选择偶数个数字，这样加上它自身，才构成奇数长度的数组；
     * <p>
     * 如果在前面选择了奇数个数字，那么在后面，也必须选择奇数个数字，这样加上它自身，才构成奇数长度的数组；
     * <p>
     * 数字前面共有 left 个选择，其中偶数个数字的选择方案有 left_even = (left + 1) / 2 个，奇数个数字的选择方案有 left_odd = left / 2 个；
     * <p>
     * 数字后面共有 right 个选择，其中偶数个数字的选择方案有 right_even = (right + 1) / 2 个，奇数个数字的选择方案有 right_odd = right / 2 个；
     * <p>
     * 所以，每个数字一共在 left_even * right_even + left_odd * right_odd 个奇数长度的数组中出现过。
     * <p>
     * 作者：liuyubobobo
     * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/solution/cong-on3-dao-on-de-jie-fa-by-liuyubobobo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays_3(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i + 1, right = arr.length - i;
            int leftEven = (left + 1) / 2, rightEven = (right + 1) / 2;
            int leftOdd = left / 2, rightOdd = right / 2;
            ans += (leftEven * rightEven + rightOdd * leftOdd) * arr[i];
        }
        return ans;
    }


}
