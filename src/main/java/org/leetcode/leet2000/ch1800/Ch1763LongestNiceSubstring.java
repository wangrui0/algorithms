package org.leetcode.leet2000.ch1800;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <p>1763. 最长的美好子字符串
 *
 * <p>当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b'
 * 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
 *
 * <p>给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "YazaAay"
 * <p>输出："aAa"
 * <p>解释："aAa" 是一个美好字符串，因为这个子串中仅含一种字母，其小写形式 'a' 和大写形式 'A' 也同时出现了。
 * <p>"aAa" 是最长的美好子字符串。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "Bb"
 * <p>输出："Bb"
 * <p>解释："Bb" 是美好字符串，因为 'B' 和 'b' 都出现了。整个字符串也是原字符串的子字符串。
 *
 * <p>示例 3：
 *
 * <p>输入：s = "c"
 * <p>输出：""
 * <p>解释：没有美好子字符串。
 *
 * <p>示例 4：
 *
 * <p>输入：s = "dDzeE"
 * <p>输出："dD"
 * <p>解释："dD" 和 "eE" 都是最长美好子字符串。
 * <p>由于有多个美好子字符串，返回 "dD" ，因为它出现得最早。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 100
 * <p>    s 只包含大写和小写英文字母。
 *
 * <p>通过次数2,657
 * <p>提交次数4,355
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/longest-nice-substring/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:06 下午
 */
public class Ch1763LongestNiceSubstring {


  public String longestNiceSubstring(String s) {
    char[] cs = s.toCharArray();
    String res = "";
    for (int i = 0; i < cs.length; i++) {
      for (int j = cs.length - 1; j > i; j--) {
        boolean flag = true;
        HashSet<Character> set = new HashSet<>();
        for (int k = i; k <= j; k++) {
          set.add(cs[k]);
        }
        if (set.size() % 2 != 0) {
          continue;
        }
        for (char c : set) {
          if (c < 'a' && !set.contains((char) (c + 32))) {
            flag = false;
          }
          if (c >= 'a' && !set.contains((char) (c - 32))) {
            flag = false;
          }
        }
        if (flag && j - i + 1 > res.length()) {
          res = s.substring(i, j + 1);
        }
      }
    }
    return res;
  }


  public String longestNiceSubstring_2(String s) {
    char[] c = s.toCharArray();
    int n = c.length, diff = 0, len = 0, ansl = -1, ansr = -1;
    int[] ch = new int[26], CH = new int[26];
    for (int l = 0; l < n; l++) {
      int maxR = -1;//当前最长美好子字符串右边界
      Arrays.fill(ch, 0);//重置当前美好子字符串中的小写字符数
      Arrays.fill(CH, 0);//重置当前美好子字符串中的大写字符数
      diff = 0;//未配对的字符种类数
      for (int r = l; r < n; r++) {//寻找右边界
        if (c[r] > 'Z') {
          if (ch[c[r] - 'a']++ == 0) {
            if (CH[c[r] - 'a'] > 0) {
              diff--;
            } else {
              diff++;
            }
          }
        } else {
          if (CH[c[r] - 'A']++ == 0) {
            if (ch[c[r] - 'A'] > 0) {
              diff--;
            } else {
              diff++;
            }
          }
        }
        if (diff == 0) {
          maxR = r;
        }
      }
      if (maxR != -1) {//当前存在美好子字符串
        if (maxR - l + 1 > len) {
          len = maxR - l + 1;
          ansl = l;
          ansr = maxR;
        }
        l = maxR;//指针直接移动到有边界后
      }
    }
    if (len == 0) {
      return "";
    }
    return s.substring(ansl, ansr + 1);
  }

  public String longestNiceSubstring_3(String s) {
    int n = s.length();
    if (n < 2) {
      return "";
    }
    String ans = "";
    // len 滑动窗口长度
    for (int len = 2; len <= n; len++) {
      // i 滑动窗口起始位置
      for (int i = 0; i + len - 1 < n; i++) {
        String substring = s.substring(i, i + len);
        if (substring.length() > ans.length() && isNicety(substring)) {
          ans = substring;
        }
      }
    }
    return ans;
  }

  private boolean isNicety(String s) {
    HashSet<Character> upperSet = new HashSet<>();
    HashSet<Character> lowerSet = new HashSet<>();
    for (char ch : s.toCharArray()) {
      if (Character.isUpperCase(ch)) {
        upperSet.add(ch);
      } else {
        lowerSet.add(Character.toUpperCase(ch));
      }
    }
    if (upperSet.size() != lowerSet.size()) {
      return false;
    }
    upperSet.removeAll(lowerSet);
    return upperSet.size() == 0;
  }
}
