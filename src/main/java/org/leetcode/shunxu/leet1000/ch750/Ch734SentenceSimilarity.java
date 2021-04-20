package org.leetcode.shunxu.leet1000.ch750;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>给定两个句子 words1, words2 （每个用字符串数组表示），和一个相似单词对的列表 pairs ，判断是否两个句子是相似的。
 *
 * <p>例如，当相似单词对是 pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]的时候，"great acting skills" 和 "fine
 * drama talent" 是相似的。
 *
 * <p>注意相似关系是不具有传递性的。
 * <p>例如，如果 “great” 和 “fine” 是相似的，“fine” 和 “good” 是相似的，但是 “great” 和 “good” 未必是相似的。
 *
 * <p>但是，相似关系是具有对称性的。
 * <p>例如，“great” 和 “fine” 是相似的相当于 “fine” 和 “great” 是相似的。
 *
 * <p>而且，一个单词总是与其自身相似。
 * <p>例如，句子 words1 = ["great"], words2 = ["great"], pairs = [] 是相似的，尽管没有输入特定的相似单词对。
 *
 * <p>最后，句子只会在具有相同单词个数的前提下才会相似。
 * <p>所以一个句子 words1 = ["great"] 永远不可能和句子 words2 = ["doubleplus","good"] 相似。
 * <p>注：
 * <p>words1 and words2 的长度不会超过 1000。
 * <p>pairs 的长度不会超过 2000。
 * <p>每个pairs[i] 的长度为 2。
 * <p>每个 words[i] 和 pairs[i][j] 的长度范围为 [1, 20]。
 * <p><p>https://leetcode-cn.com/problems/sentence-similarity/
 * <p><p>@author: wangrui
 * <p><p>@date: 2021/3/24
 */
public class Ch734SentenceSimilarity {

  public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
    if (words1.length != words2.length) {
      return false;
    }
    Map<String, Set<String>> similar_words = new HashMap<>();

    for (String[] pair : pairs) {
      if (!similar_words.containsKey(pair[0])) {
        similar_words.put(pair[0], new HashSet<>());
      }

      if (!similar_words.containsKey(pair[1])) {
        similar_words.put(pair[1], new HashSet<>());
      }

      similar_words.get(pair[0]).add(pair[1]);
      similar_words.get(pair[1]).add(pair[0]);
    }

    for (int i = 0; i < words1.length; ++i) {
      if (words1[i].equals(words2[i])) {
        continue;
      }
      if (!similar_words.containsKey(words1[i])) {
        return false;
      }
      if (!similar_words.get(words1[i]).contains(words2[i])) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out
        .println(areSentencesSimilar2(new String[]{"great", "acting", "skills"}, new String[]{"fine","drama","talent"},
            new String[][]{{"great", "fine"},
                {"acting", "drama"}, {"skills", "talent"}}));
  }

  public static boolean areSentencesSimilar2(String[] words1, String[] words2, String[][] pairs) {
    if (words1.length != words2.length) {
      return false;
    }
    Map<String, String> map = new HashMap<>();
    for (String[] pair : pairs) {
      map.put(pair[0], pair[1]);
      map.put(pair[1], pair[1]);
    }
    for (int i = 0; i < words1.length; i++) {
      if (words1[i].equals(words2[i])) {
        continue;
      }
      if (!map.containsKey(words1[i])) {
        return false;
      }
      if (!map.get(words1[i]).equals(words2[i])) {
        return false;
      }
    }
    return true;
  }
}
