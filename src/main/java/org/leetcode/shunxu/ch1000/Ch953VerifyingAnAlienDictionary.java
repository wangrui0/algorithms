package org.leetcode.shunxu.ch1000;

/**
 * <p>953. 验证外星语词典
 *
 * <p>某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * <p>给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * <p>输出：true
 * <p>解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 *
 * <p>示例 2：
 *
 * <p>输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * <p>输出：false
 * <p>解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 *
 * <p>示例 3：
 *
 * <p>输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * <p>输出：false
 * <p>解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= words.length <= 100
 * <p>    1 <= words[i].length <= 20
 * <p>    order.length == 26
 * <p>    在 words[i] 和 order 中的所有字符都是英文小写字母。
 *
 * <p>通过次数10,914
 * <p>提交次数19,738
 * <p>@author: wangrui
 * <p>@date: 2021/4/2
 */
public class Ch953VerifyingAnAlienDictionary {

  public boolean isAlienSorted(String[] words, String order) {
    int[] array = new int[26];
    for (int i = 0; i < order.length(); i++) {
      array[order.charAt(i) - 'a'] = i;
    }

    for (int i = 0; i < words.length - 1; i++) {
      boolean flagInter = true;
      String word1 = words[i];
      String word2 = words[i + 1];
      for (int j = 0; flagInter && j < Math.min(word1.length(), word2.length()); j++) {
        if (word1.charAt(j) != word2.charAt(j)) {
          if (array[word1.charAt(j) - 'a'] > array[word2.charAt(j) - 'a']) {
            return false;
          }
          flagInter = false;
        }
      }
      if (flagInter && word1.length() > word2.length()) {
        return false;
      }
    }
    return true;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度： O(C)，其中 C 是 words 中单词总长度和。
   *
   * <p>    空间复杂度： O(1)。
   *
   * @param words
   * @param order
   * @return
   */
  public boolean isAlienSorted_1(String[] words, String order) {
    int[] index = new int[26];
    for (int i = 0; i < order.length(); ++i) {
      index[order.charAt(i) - 'a'] = i;
    }

    search:
    for (int i = 0; i < words.length - 1; ++i) {
      String word1 = words[i];
      String word2 = words[i + 1];

      // Find the first difference word1[k] != word2[k].
      for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
        if (word1.charAt(k) != word2.charAt(k)) {
          // If they compare badly, it's not sorted.
          if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']) {
            return false;
          }
          continue search;
        }
      }

      // If we didn't find a first difference, the
      // words are like ("app", "apple").
      if (word1.length() > word2.length()) {
        return false;
      }
    }

    return true;
  }


}
