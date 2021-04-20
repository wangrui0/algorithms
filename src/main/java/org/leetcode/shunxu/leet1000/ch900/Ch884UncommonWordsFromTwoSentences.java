package org.leetcode.shunxu.leet1000.ch900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>884. 两句话中的不常见单词
 *
 * <p>给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 *
 * <p>如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 *
 * <p>返回所有不常用单词的列表。
 *
 * <p>您可以按任何顺序返回列表。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：A = "this apple is sweet", B = "this apple is sour"
 * <p>输出：["sweet","sour"]
 *
 * <p>示例 2：
 *
 * <p>输入：A = "apple apple", B = "banana"
 * <p>输出：["banana"]
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= A.length <= 200
 * <p>    0 <= B.length <= 200
 * <p>    A 和 B 都只包含空格和小写字母。
 *
 * <p>通过次数16,067
 * <p>提交次数24,713
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch884UncommonWordsFromTwoSentences {

  public String[] uncommonFromSentences(String A, String B) {
    Map<String, Integer> map = new HashMap<>();
    for (String a : A.split(" ")) {
      map.put(a, map.getOrDefault(a, 0) + 1);
    }

    for (String b : B.split(" ")) {
      map.put(b, map.getOrDefault(b, 0) + 1);
    }
    List<String> ans = new ArrayList<>();
    for (String key : map.keySet()) {
      Integer value = map.get(key);
      if (value == 1) {
        ans.add(key);
      }
    }

    return ans.toArray(new String[ans.size()]);
  }

  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(M+N)，其中 M,N 分别是 A 和 B 的长度。
   *
   * <p>  空间复杂度：O(M+N)，count 所用去的空间。
   *
   * @param A
   * @param B
   * @return
   */
  public String[] uncommonFromSentences2(String A, String B) {
    Map<String, Integer> count = new HashMap();
    for (String word : A.split(" ")) {
      count.put(word, count.getOrDefault(word, 0) + 1);
    }
    for (String word : B.split(" ")) {
      count.put(word, count.getOrDefault(word, 0) + 1);
    }

    List<String> ans = new LinkedList();
    for (String word : count.keySet()) {
      if (count.get(word) == 1) {
        ans.add(word);
      }
    }
    return ans.toArray(new String[ans.size()]);
  }
}
