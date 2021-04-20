package org.leetcode.shunxu.leet1500.ch1200;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1160. 拼写单词
 *
 * <p>给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * <p>假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * <p>注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * <p>返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * <p>输出：6
 * <p>解释：
 * <p>可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 *
 * <p>示例 2：
 *
 * <p>输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * <p>输出：10
 * <p>解释：
 * <p>可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= words.length <= 1000
 * <p>    1 <= words[i].length, chars.length <= 100
 * <p>    所有字符串中都仅包含小写英文字母
 *
 * <p>通过次数55,169
 * <p>提交次数80,221
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1160FindWordsThatCanBeFormedByCharacters {

  public static void main(String[] args) {
    System.out.println(countCharacters_self(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
  }

  public static int countCharacters_self(String[] words, String chars) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < chars.length(); i++) {
      char c = chars.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int length = 0;
    for (String word : words) {
      int[] wordNum = new int[27];
      for (int i = 0; i < word.length(); i++) {
        wordNum[word.charAt(i) - 'a']++;
        if (wordNum[word.charAt(i) - 'a'] > map.getOrDefault(word.charAt(i), 0)) {
          break;
        }
      }
      for (int i = 0; i < wordNum.length; i++) {
        if (map.getOrDefault((char) (i + 'a'), 0) < wordNum[i]) {
          break;
        }
        if (i == wordNum.length - 1) {
          length += word.length();
        }
      }
    }

    return length;
  }

  /**
   * 复杂度分析
   *
   *     时间复杂度：O(n)，其中 n 为所有字符串的长度和。我们需要遍历每个字符串，包括 chars 以及数组 words 中的每个单词。
   *
   *     空间复杂度：O(S)，其中 S 为字符集大小，在本题中 S 的值为 262626（所有字符串仅包含小写字母）。程序运行过程中，最多同时存在两个哈希表，使用的空间均不超过字符集大小 S，因此空间复杂度为 O(S)。
   *
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/solution/pin-xie-dan-ci-by-leetcode-solution/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param words
   * @param chars
   * @return
   */
  public int countCharacters_2(String[] words, String chars) {
    Map<Character, Integer> charsCnt = new HashMap<Character, Integer>();
    int length = chars.length();
    for (int i = 0; i < length; ++i) {
      char c = chars.charAt(i);
      charsCnt.put(c, charsCnt.getOrDefault(c, 0) + 1);
    }
    int ans = 0;
    for (String word : words) {
      Map<Character, Integer> wordCnt = new HashMap<Character, Integer>();
      int wordLength = word.length();
      for (int i = 0; i < wordLength; ++i) {
        char c = word.charAt(i);
        wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
      }
      boolean isAns = true;
      for (int i = 0; i < wordLength; ++i) {
        char c = word.charAt(i);
        if (charsCnt.getOrDefault(c, 0) < wordCnt.getOrDefault(c, 0)) {
          isAns = false;
          break;
        }
      }
      if (isAns) {
        ans += word.length();
      }
    }
    return ans;
  }


}
