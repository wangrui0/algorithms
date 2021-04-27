package org.leetcode.leet2000.ch1750;

/**
 * 1720. 解码异或后的数组
 * <p>
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3]
 * 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：encoded = [1,2,3], first = 1 输出：[1,0,2,1] 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR
 * 1] = [1,2,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：encoded = [6,2,7,3], first = 4 输出：[4,2,0,7,4]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 104 encoded.length == n - 1 0 <= encoded[i] <= 105 0 <= first <= 105
 * <p>
 * 通过次数10,192 提交次数12,140 请问您在哪类招聘中遇到此题？ https://leetcode-cn.com/problems/decode-xored-array/
 *
 * @Author: shenpei
 * @Date: 2021/4/25 9:59 下午
 */
public class NCh1720DecodeXoredArray {

  //  a^b=c,c^a=b;
  public int[] decode(int[] encoded, int first) {
    return null;
  }
}
