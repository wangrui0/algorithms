package org.leetcode.shunxu.leet1000.ch750;

/**
 * <p>748. 最短补全词
 *
 * <p>给定一个字符串牌照 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 *
 * <p>如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为 补全词 。在所有完整词中，最短的单词我们称之为 最短补全词 。
 *
 * <p>单词在匹配牌照中的字母时要：
 *
 * <p>    忽略牌照中的数字和空格。
 * <p>    不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 * <p>    如果某个字母在牌照中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 *
 * <p>例如：licensePlate = "aBc 12c"，那么它由字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 是 "abccdef"、"caaacab" 以及 "cbca" 。
 *
 * <p>题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取单词列表中最靠前的一个。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * <p>输出："steps"
 * <p>说明：最短补全词应该包括 "s"、"p"、"s" 以及 "t"。在匹配过程中我们忽略牌照中的大小写。
 * <p>"step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * <p>"steps" 包含 "t"、"p" 和两个 "s"。
 * <p>"stripe" 缺一个 "s"。
 * <p>"stepple" 缺一个 "s"。
 * <p>因此，"steps" 是唯一一个包含所有字母的单词，也是本样例的答案。
 *
 * <p>示例 2：
 *
 * <p>输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * <p>输出："pest"
 * <p>说明：存在 3 个包含字母 "s" 且有着最短长度的补全词，"pest"、"stew"、和 "show" 三者长度相同，但我们返回最先出现的补全词 "pest" 。
 *
 * <p>示例 3：
 *
 * <p>输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
 * <p>输出："husband"
 *
 * <p>示例 4：
 *
 * <p>输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
 * <p>输出："enough"
 *
 * <p>示例 5：
 *
 * <p>输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
 * <p>输出："simple"
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= licensePlate.length <= 7
 * <p>    licensePlate 由数字、大小写字母或空格 ' ' 组成
 * <p>    1 <= words.length <= 1000
 * <p>    1 <= words[i].length <= 15
 * <p>    words[i] 由小写英文字母组成
 * <p>  https://leetcode-cn.com/problems/shortest-completing-word/
 * <p>通过次数10,401
 * <p>提交次数17,388
 * <p>@author: wangrui
 * <p>@date: 2021/3/24
 */
public class Ch748ShortestCompletingWord {

  /**
   * <p>复杂度分析
   * <p>
   * <p>   时间复杂度：O(N)。N 指的是 words 的元素个数，比较 licensePlate 和 words[i] 的字母计数需要 O(1) 的时间
   * <p>   空间复杂度：O(1)，使用常数的空间。
   *
   * @param licensePlate
   * @param words
   * @return
   */
  public String shortestCompletingWord(String licensePlate, String[] words) {
    int[] target = count(licensePlate);
    String ans = "";
    for (String word : words) {
      if ((word.length() < ans.length() || ans.length() == 0) &&
          dominates(count(word.toLowerCase()), target)) {
        ans = word;
      }
    }
    return ans;
  }

  public boolean dominates(int[] count1, int[] count2) {
    for (int i = 0; i < 26; ++i) {
      if (count1[i] < count2[i]) {
        return false;
      }
    }
    return true;
  }

  public int[] count(String word) {
    int[] ans = new int[26];
    for (char letter : word.toCharArray()) {
      int index = Character.toLowerCase(letter) - 'a';
      if (0 <= index && index < 26) {
        ans[index]++;
      }
    }
    return ans;
  }
}


