package org.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>最短单词距离
 * <p> 题目描述：
 * <p> 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 *
 * <p> 示例:
 * <p> 假设 words = [“practice”, “makes”, “perfect”, “coding”, “makes”]
 * <p> 输入: word1 = “coding”, word2 = “practice”
 * <p> 输出: 3
 * <p> 输入: word1 = “makes”, word2 = “coding”
 * <p> 输出: 1
 *
 * <p> 注意:
 * <p> 你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。
 * <p>  https://leetcode-cn.com/problems/shortest-word-distance/
 *
 * @author: wangrui
 * @date: 2021/1/31
 */
public class Ch0243ShortestWordDistance {

  public int shortestDistance(String[] words, String word1, String word2) {
    List<Integer> w1 = new ArrayList<>();
    List<Integer> w2 = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      if (word1.equals(words[i])) {
        w1.add(i);
      } else if (word2.equals(words[i])) {
        w2.add(i);
      }
    }
    int i = 0, j = 0;
    int min = Integer.MAX_VALUE;
    int w1Index;
    int w2Index;
    while (i < w1.size() && j < w2.size()) {
      w1Index = w1.get(i);
      w2Index = w2.get(j);
      min = Math.min(Math.abs(w1Index - w2Index), min);
      if (w1Index < w2Index) {
        i++;
      }
      if (w2Index < w1Index) {
        j++;
      }
    }
    return min;
  }

  /**
   * <p> 记录二者最新位置和最小距离，遍历实现。
   *
   * <p> 因为list中可能存在相同的单词，所以不能使用Hash来实现；
   * <p> 通过两个指针指示两个单词的最新位置，遍历实现即可
   * <p>时间复杂度：O(n)，空间复杂度：O(1)
   *
   * @param words
   * @param word1
   * @param word2
   * @return
   */
  public int shortestDistance2(String[] words, String word1, String word2) {
    int pos1 = -1;
    int pos2 = -1;
    int distance = words.length - 1;
    for (int i = 0; i < words.length; i++) {
      if (word1.equals(words[i])) {
        pos1 = i;
        if (pos2 != -1 && pos1 - pos2 < distance) {
          distance = pos1 - pos2;
        }
      } else if (word2.equals(words[i])) {
        pos2 = i;
        if (pos1 != -1 && pos2 - pos1 < distance) {
          distance = pos2 - pos1;
        }
      }
    }
    return distance;
  }
}
