package org.leetcode.shunxu.ch850;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>804. 唯一摩尔斯密码词
 *
 * <p>国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 *
 * <p>为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *
 * <p>[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *
 * <p>给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * <p>返回我们可以获得所有词不同单词翻译的数量。
 *
 * <p>例如:
 * <p>输入: words = ["gin", "zen", "gig", "msg"]
 * <p>输出: 2
 * <p>解释:
 * <p>各单词翻译如下:
 * <p>"gin" -> "--...-."
 * <p>"zen" -> "--...-."
 * <p>"gig" -> "--...--."
 * <p>"msg" -> "--...--."
 *
 * <p>共有 2 种不同翻译, "--...-." 和 "--...--.".
 *
 *
 *
 * <p>注意:
 *
 * <p>    单词列表words 的长度不会超过 100。
 * <p>    每个单词 words[i]的长度范围为 [1, 12]。
 * <p>    每个单词 words[i]只包含小写字母。
 *
 * <p>通过次数35,665
 * <p>提交次数46,648
 * <p>在真实的面试中遇到过这道题？
 * <p>贡献者
 * <p>https://leetcode-cn.com/problems/unique-morse-code-words/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch804UniqueMorseCodeWords {

  public int uniqueMorseRepresentations(String[] words) {
    String[] MORSE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--.."};
    Set<String> set = new HashSet<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        sb.append(MORSE[index]);
      }
      set.add(sb.toString());
    }
    return set.size();
  }

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(S)，其中 S 是数组 words 中所有单词的长度之和。
   *
   * <p>    空间复杂度：O(S)。
   *
   * @param words
   * @return
   */
  public int uniqueMorseRepresentations2(String[] words) {
    String[] MORSE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--.."};

    Set<String> seen = new HashSet();
    for (String word : words) {
      StringBuilder code = new StringBuilder();
      for (char c : word.toCharArray()) {
        code.append(MORSE[c - 'a']);
      }
      seen.add(code.toString());
    }

    return seen.size();
  }
}
