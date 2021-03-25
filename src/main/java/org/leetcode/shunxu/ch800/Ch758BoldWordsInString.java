package org.leetcode.shunxu.ch800;

/**
 * <p>字符串中的加粗单词
 *
 * <p>给定一个关键字集合words和一个字符串S，将所有S中出现的关键词加粗。所有在标签<b>和</b>之间的字母都会加粗
 *
 * <p>返回的字符串应该使用尽可能少的标签，当然这些标签应该形成一个有效的组合。
 * <p>
 * 例如，假设words=[“ab”，“bc”]和S=“aabcd”，我们应该返回“a<b>abc</b>d”。请注意，返回“a<b>a</b><b>b</b><b>c</b>d”将使用更多标记，因此这是不正确的。
 * <p>
 * 注：
 * <p>
 * words的长度在[0，50]范围内。
 * <p>
 * words[i]的长度在[1，10]范围内。
 * <p>
 * S的长度在[0，500]范围内。
 * <p>
 * 所有words[i]和S中的所有字符都是小写字母。
 *
 * @author: wangrui
 * @date: 2021/3/24
 */
public class Ch758BoldWordsInString {

  public String boldWords(String[] words, String S) {
    if (words.length == 0) {
      return S;
    }
    boolean[] isBold = new boolean[S.length()];
    int idx;
    // 把需要加粗的索引标记出来
    for (String word : words) {
      idx = S.indexOf(word);
      while (idx != -1) {
        for (int i = idx; i <= idx + word.length() - 1; i++) {
          isBold[i] = true;
        }
        idx = S.indexOf(word, idx + 1);
      }
    }

    // 遍历 S ，在加粗的入口加<b> 出口加 </b>
    StringBuilder sb = new StringBuilder();
    if (isBold[0]) {
      sb.append("<b>");
    }
    for (int j = 0; j < S.length(); j++) {
      sb.append(S.charAt(j));
      if (j == S.length() - 1) {
        if (isBold[j]) {
          sb.append("</b>");
        }
      } else {
        if (isBold[j] && !isBold[j + 1]) {
          sb.append("</b>");
        }
        if (!isBold[j] && isBold[j + 1]) {
          sb.append("<b>");
        }
      }
    }
    return sb.toString();
  }
}
