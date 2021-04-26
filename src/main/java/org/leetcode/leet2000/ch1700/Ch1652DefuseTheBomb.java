package org.leetcode.leet2000.ch1700;

import java.util.Arrays;

/**
 * <p>1652. 拆炸弹
 *
 * <p>你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 *
 * <p>为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 *
 * <p>    如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * <p>    如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * <p>    如果 k == 0 ，将第 i 个数字用 0 替换。
 *
 * <p>由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 *
 * <p>给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：code = [5,7,1,4], k = 3
 * <p>输出：[12,10,16,13]
 * <p>解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 *
 * <p>示例 2：
 *
 * <p>输入：code = [1,2,3,4], k = 0
 * <p>输出：[0,0,0,0]
 * <p>解释：当 k 为 0 时，所有数字都被 0 替换。
 *
 * <p>示例 3：
 *
 * <p>输入：code = [2,4,9,3], k = -2
 * <p>输出：[12,5,6,13]
 * <p>解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 *
 *
 *
 * <p>提示：
 *
 * <p>    n == code.length
 * <p>    1 <= n <= 100
 * <p>    1 <= code[i] <= 100
 * <p>    -(n - 1) <= k <= n - 1
 *
 * <p>通过次数5,404
 * <p>提交次数8,150
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/defuse-the-bomb/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:29 下午
 */
public class Ch1652DefuseTheBomb {

  public static int[] decrypt_self(int[] code, int k) {
    int[] ans = new int[code.length];
    if (k == 0) {
      return ans;
    }
    int[] sum = new int[code.length];
    sum[0] = code[0];
    for (int i = 1; i < code.length; i++) {
      sum[i] = code[i] + sum[i - 1];
    }
    for (int i = 0; i < code.length; i++) {
      if (k > 0) {
        if (i + k <= code.length - 1) {
          ans[i] = sum[i + k] - sum[i];
        } else {
          ans[i] = (sum[code.length - 1] - sum[i]) + (sum[k - (code.length - i)]);
        }
      } else {
        if (i == 0) {
          ans[i] = sum[code.length - 1] - sum[code.length - 1 + k];
        } else if (-k == i) {
          ans[i] = sum[i - 1];
        } else if (-k > i) {
          ans[i] = (sum[i - 1]) + (sum[code.length - 1] - sum[code.length - 1 + k + i]);
        } else {
          ans[i] = (sum[i - 1] - sum[i - 1 + k]);
        }
      }
    }

    return ans;
  }

  public int[] decrypt_2(int[] code, int k) {
    int[] newCode = new int[code.length];   //新数组，用来存放答案
    if (k == 0) {
      return newCode;
    }
    int offset = k > 0 ? 0 : code.length + k - 1;   //偏移量，当K是负数的时候，要等价代换一下
    k = k > 0 ? k : -k; //对K取绝对值
    for (int i = 0 + offset; i < code.length + offset; i++) {
      int sum = 0;
      for (int j = 0; j < k; j++) {
        sum += code[(i + 1 + j) % code.length];//通过取余就可以实现循环操作
      }
      newCode[i - offset] = sum;  //对0-n-1下标的新数组赋值
    }
    return newCode;
  }

  public int[] decrypt_3(int[] code, int k) {
    // 用来存储结果的数组
    int[] result = new int[code.length];
    // 分情况讨论
    if (k == 0) {
      // 当k==0，直接返回全是0的数组
      Arrays.fill(result, k);
    } else if (k > 0) {
      // 当k>0，循环遍历重置每个数为该数后k个元素之和
      for (int i = 0; i < code.length; i++) {
        // 调用sumArrAfter()方法获取code数组中i索引之后的k个元素之和
        result[i] = sumArrAfter(code, i, k);
      }
    } else if (k < 0) {
      // 当k<0，循环遍历重置为个数为该数前k个元素之和
      for (int i = 0; i < code.length; i++) {
        // 调用sumArrBefore()方法获取code数组中i索引之前的k个元素之和
        result[i] = sumArrBefore(code, i, Math.abs(k));// 注意，这里k是负数，所以要取绝对值
      }
    }
    return result;
  }

  // 获取指定start索引之后的k个元素之和
  private int sumArrAfter(int[] code, int start, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
      // code[(start + i + 1) % code.length]核心代码，如果向左超出则取余数
      sum += code[(start + i + 1) % code.length];
    }
    return sum;
  }

  // 获取指定end索引之前的k个元素之和
  private int sumArrBefore(int[] code, int end, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
      // code[(end - i - 1 + code.length) % code.length]核心代码，如果向右超出则取余数
      sum += code[(end - i - 1 + code.length) % code.length];
    }
    return sum;
  }
/*
    解题思路：
        0.暴力破解
        1.分三种情况讨论：
            1.1当k>0时，将第 i 个数字用接下来 k 个数字之和替换，主要是向左会超出数组长度，所以要取模
            1.2当k==0时，直接返回一个全是0的数组
            1.3当k<0时，将第 i 个数字用之前 k 个数字之和替换，主要是向右索引会变成负数，所以要加上长度取模
 */
/*
    执行用时：2 ms, 在所有 Java 提交中击败了75.70% 的用户
    内存消耗：38.6 MB, 在所有 Java 提交中击败了37.42% 的用户
 */


}
