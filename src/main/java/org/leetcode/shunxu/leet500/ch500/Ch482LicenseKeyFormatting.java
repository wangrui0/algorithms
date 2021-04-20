package org.leetcode.shunxu.leet500.ch500;

/**
 * <p> 482. 密钥格式化
 *
 * <p>有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 *
 * <p>给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *
 * <p>给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：S = "5F3Z-2e-9-w", K = 4
 * <p> 输出："5F3Z-2E9W"
 * <p>解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 * <p>   注意，两个额外的破折号需要删掉。
 *
 * <p>示例 2：
 *
 * <p>输入：S = "2-5g-3-J", K = 2
 * <p>输出："2-5G-3J"
 * <p>解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 *
 *
 *
 * <p>提示:
 *
 * <p>   S 的长度可能很长，请按需分配大小。K 为正整数。
 * <p>   S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
 * <p>   S 非空
 * <p> https://leetcode-cn.com/problems/license-key-formatting/
 *
 *
 * @author: wangrui
 * @date: 2021/3/11
 */
public class Ch482LicenseKeyFormatting {

  /**
   * self
   *
   * @param S
   * @param K
   * @return
   */
  public static String licenseKeyFormatting(String S, int K) {
    StringBuilder sb = new StringBuilder();
    int num = S.length();
    int count = 0;
    for (int i = num - 1; i >= 0; i--) {
      if (S.charAt(i) != '-' && count < K) {
        sb.append(Character.toUpperCase(S.charAt(i)));
        count++;
      } else if (S.charAt(i) != '-') {
        sb.append('-');
        count = 0;
        i++;
      }
    }
    return sb.reverse().toString();
  }

  public String licenseKeyFormatting2(String S, int K) {
    StringBuilder s = new StringBuilder();
    // 统计已打印字符个数
    int count = 0;
    // 倒序遍历字符串
    for (int i = S.length() - 1; i >= 0; i--) {
      if (S.charAt(i) != '-') {
        // 计算什么时候打印分隔符
        if (count != 0 && count % K == 0) {
          s.append('-');
        }
        // 转为大写字母添加
        s.append(Character.toUpperCase(S.charAt(i)));
        count++;
      }
    }
    // 反转字符串
    return s.reverse().toString();
  }

  public String licenseKeyFormatting3(String S, int K) {
    char[] array = S.toCharArray();
    // 统计字符的个数
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != '-') {
        // 将小写字符转为大写字符
        if (array[i] > 'Z') {
          array[i] -= 32;
        }
        count++;
      }
    }
    // 没有字符返回空串
    if (count == 0) {
      return "";
    }
    // 计算分隔符的个数
    int separator = count / K;
    // 如果正好整除，分隔符个数 - 1
    separator = count % K == 0 ? separator - 1 : separator;
    // 存储结果的数组
    char[] result = new char[count + separator];
    // 指向结果数组的下标，倒序赋值
    int index = result.length - 1;
    // 统计已打印字符个数
    int letter = 0;
    for (int i = S.length() - 1; i >= 0; i--) {
      if (array[i] != '-') {
        // 计算什么时候打印分隔符
        if (letter != 0 && letter % K == 0) {
          result[index--] = '-';
        }
        result[index--] = array[i];
        letter++;
      }
    }
    return new String(result);
  }
}
