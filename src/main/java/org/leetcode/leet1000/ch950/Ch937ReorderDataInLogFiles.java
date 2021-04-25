package org.leetcode.leet1000.ch950;

import java.util.Arrays;

/**
 * <p>937. 重新排列日志文件
 *
 * <p>给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 *
 * <p>有两种不同类型的日志：
 *
 * <p>    字母日志：除标识符之外，所有字均由小写字母组成
 * <p>    数字日志：除标识符之外，所有字均由数字组成
 *
 * <p>请按下述规则将日志重新排序：
 *
 * <p>    所有 字母日志 都排在 数字日志 之前。
 * <p>    字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * <p>    数字日志 应该保留原来的相对顺序。
 *
 * <p>返回日志的最终顺序。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * <p>输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * <p>解释：
 * <p>字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * <p>数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 *
 * <p>示例 2：
 *
 * <p>输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * <p>输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= logs.length <= 100
 * <p>    3 <= logs[i].length <= 100
 * <p>    logs[i] 中，字与字之间都用 单个 空格分隔
 * <p>    题目数据保证 logs[i] 都有一个标识符，并且在标识符之后至少存在一个字
 *
 * <p>通过次数9,441
 * <p>提交次数16,103
 * <p>在真实的面试中遇到过这道题？
 * <p> https://leetcode-cn.com/problems/reorder-data-in-log-files/
 * <p>@author: wangrui
 * <p>@date: 2021/3/22
 */
public class Ch937ReorderDataInLogFiles {

  /**
   * <p> 方法：自定义排序
   *
   * <p> 思路和算法
   *
   * <p> 我们按照指定的自定义顺序进行排序，而不是按默认顺序排序。
   *
   * <p> 排序规则如下：
   *
   * <p>     字母日志先于数字日志；
   * <p>     字母日志按字母数字顺序排列，先按内容排序，再按标识符排序；
   * <p>     数字日志的顺序保持不变。
   *
   * <p> 这些想法很容易转化为代码。
   * <p>注意： . 、 $、 | 和 * 等转义字符，必须得加 \\。
   * =================================================================
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(AlogA)，其中 A 是 logs 的内容总和。
   *
   * <p> 空间复杂度：O(A)。
   *
   * @param logs
   * @return
   */
  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, (log1, log2) -> {
      //分割的份数
      String[] split1 = log1.split(" ", 2);
      String[] split2 = log2.split(" ", 2);
      boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
      boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
      if (!isDigit1 && !isDigit2) {
        int cmp = split1[1].compareTo(split2[1]);
        if (cmp != 0) {
          return cmp;
        }
        return split1[0].compareTo(split2[0]);
      }
      return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
    });
    return logs;
  }


  public String[] reorderLogFiles2(String[] logs) {
    Arrays.sort(logs, (log1, log2) -> {
      String[] split1 = log1.split(" ", 2);
      String[] split2 = log2.split(" ", 2);
      boolean digit1 = Character.isDigit(split1[1].charAt(0));
      boolean digit2 = Character.isDigit(split2[1].charAt(0));
      if (!digit1 && !digit2) {
        int compare = split1[1].compareTo(split2[1]);
        if (compare != 0) {
          return compare;
        }
        return split1[0].compareTo(split2[0]);
      }
      return digit1 ? (digit2 ? 0 : 1) : -1;
    });
    return logs;
  }
}
