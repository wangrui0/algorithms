package org.leetcode;

/**
 * 最后一个单词的长度
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * <p>
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/11
 */
public class Ch0058LengthOfLastWord {

  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("Hello World He"));
    System.out.println(lengthOfLastWord("a "));
  }

  public static int lengthOfLastWord(String s) {
    int result = 0;
    int pre = 0;
    for (int i = 0; i < s.length(); i++) {
      if (pre == " ".charAt(0) && s.charAt(i) != " ".charAt(0)) {
        result = 1;
      } else if (pre != " ".charAt(0) && s.charAt(i) != " ".charAt(0)) {
        result++;
      }
      pre = s.charAt(i);
    }
    return result;
  }

  /**
   * 官方:
   * <p>
   * 思路
   * <p>
   * 标签：字符串遍历
   * <p>
   * 从字符串末尾开始向前遍历，其中主要有两种情况
   * <p>
   * 第一种情况，以字符串"Hello World"为例，从后向前遍历直到遍历到头或者遇到空格为止，即为最后一个单词"World"的长度5
   * <p>
   * 第二种情况，以字符串"Hello World "为例，需要先将末尾的空格过滤掉，再进行第一种情况的操作，即认为最后一个单词为"World"，长度为5
   * <p>
   * 所以完整过程为先从后过滤掉空格找到单词尾部，再从尾部向前遍历，找到单词头部，最后两者相减，即为单词的长度
   * <p>
   * 时间
   * <p>复杂度：O(n)，n为结尾空格和结尾单词总体长度
   *
   * @param s
   * @return
   */
  public int lengthOfLastWord2(String s) {
    int end = s.length() - 1;
    while (end >= 0 && s.charAt(end) == ' ') {
      end--;
    }
    if (end < 0) {
      return 0;
    }
    int start = end;
    while (start >= 0 && s.charAt(start) != ' ') {
      start--;
    }
    return end - start;
  }

}
