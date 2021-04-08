package org.leetcode.shunxu.ch1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>字符串的索引对
 * <p>1. 题目
 * <p>给出 字符串 text 和 字符串列表 words, 返回所有的索引对 [i, j] 使得在索引对范围内的子字符串 text[i]…text[j]（包括 i 和 j）属于字符串列表 words。
 *
 * <p>示例 1:
 * <p>输入: text = "thestoryofleetcodeandme",
 * <p>		words = ["story","fleet","leetcode"]
 * <p>输出: [[3,7],[9,13],[10,17]]
 *
 * <p>示例 2:
 * <p>输入: text = "ababa", words = ["aba","ab"]
 * <p>输出: [[0,1],[0,2],[2,3],[2,4]]
 * <p>解释:
 * <p>注意，返回的配对可以有交叉，比如，"aba" 既在 [0,2] 中也在 [2,4] 中
 *
 * <p>提示:
 * <p>所有字符串都只包含小写字母。
 * <p>保证 words 中的字符串无重复。
 * <p>1 <= text.length <= 100
 * <p>1 <= words.length <= 20
 * <p>1 <= words[i].length <= 50
 * <p>按序返回索引对 [i,j]（即，按照索引对的第一个索引进行排序，
 * <p>			当第一个索引对相同时按照第二个索引对排序）。
 * <p>https://leetcode-cn.com/problems/index-pairs-of-a-string/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1065IndexPairsOfAString {

  /**
   * <p>方法一：滑动窗口法
   *
   * <p>  1、遍历 words 的每一个单词 word。定义窗口大小 windowSize = word.length()；
   * <p>
   * <p> 2、遍历字符串 text：
   *
   * <p>   2.1 如果 text.substring(i, i + windowSize) 和 word 一样，则保存一对索引 [i,i+i + windowSize - 1]
   * <p>
   * <p> 2.2 遍历的结束条件是：不满足 i <= text.length() - windowSize 则结束；
   * <p>
   *  <p>3、遍历完一个 word ，接着遍历下一个，知道遍历完所有的 word；
   * <p>
   *  <p> 4、最终得到的 ans[][] 需要排序（提示的第 6 条有说明这个条件）
   *
   * @param text
   * @param words
   * @return
   */
  public int[][] indexPairs_1(String text, String[] words) {
    int windowSize;
    List<Integer[]> lists = new ArrayList<>();
    for (String word : words) {
      windowSize = word.length();
      for (int i = 0; i <= text.length() - windowSize; i++) {
        if (word.equals(text.substring(i, i + windowSize))) {
          Integer[] target = new Integer[2];
          target[0] = i;
          target[1] = i + windowSize - 1;
          lists.add(target);
        }
      }
    }
    int[][] ans = new int[lists.size()][2];
    for (int j = 0; j < lists.size(); j++) {
      ans[j][0] = lists.get(j)[0];
      ans[j][1] = lists.get(j)[1];
    }
    Arrays.sort(ans, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] != o2[0]) {
          return o1[0] - o2[0];
        } else {
          return o1[1] - o2[1];
        }
      }
    });
    return ans;
  }

  /**
   * <p>方法二：使用 indexOf 函数
   * <p>
   *  <p> text.indexOf(word)函数可以找到 word 在 text 中第一次出现的位置。
   * <p>
   *   <p>有了这个函数，就比直接手撕好多了，逻辑和方法一一样，直接看代码即可。
   *
   * @param text
   * @param words
   * @return
   */
  public int[][] indexPairs_2(String text, String[] words) {
    int wordLength;
    List<Integer[]> lists = new ArrayList<>();
    for (String word : words) {
      wordLength = word.length();
      int idx = text.indexOf(word);
      while (idx != -1) {
        Integer[] temp = {idx, idx + wordLength - 1};
        lists.add(temp);
        idx = text.indexOf(word, idx + 1);
      }
    }
    int[][] ans = new int[lists.size()][2];
    for (int j = 0; j < lists.size(); j++) {
      ans[j][0] = lists.get(j)[0];
      ans[j][1] = lists.get(j)[1];
    }
    Arrays.sort(ans, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    return ans;
  }

}
