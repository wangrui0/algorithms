package org.leetcode.shunxu.leet1500.ch1100;

import java.util.ArrayList;
import java.util.List;

/**
 * 1078. Bigram 分词
 *
 * <p>给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second
 * 出现。
 *
 * <p>对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * <p>输出：["girl","student"]
 *
 * <p>示例 2：
 *
 * <p>输入：text = "we will we will rock you", first = "we", second = "will"
 * <p>输出：["we","rock"]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= text.length <= 1000
 * <p>    text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
 * <p>    1 <= first.length, second.length <= 10
 * <p>    first 和 second 由小写英文字母组成
 *
 * <p>通过次数10,070
 * <p>提交次数16,117
 * <p>https://leetcode-cn.com/problems/occurrences-after-bigram/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1078OccurrencesAfterBigram {

  public String[] findOcurrences(String text, String first, String second) {
    // 首先按照 " " 空格去切分字符串
    String[] words = text.split(" ");
    List<String> list = new ArrayList<>();
    // 然后按照规则直接检查就可以了
    for (int i = 0; i < words.length - 2; ++i) {
      if (words[i].equals(first) && words[i + 1].equals(second))
        // 遇到符合要求的，直接添加进返回值
        list.add(words[i + 2]);
    }
    String[] ans = new String[list.size()];
    list.toArray(ans);
    return ans;

  }
}
