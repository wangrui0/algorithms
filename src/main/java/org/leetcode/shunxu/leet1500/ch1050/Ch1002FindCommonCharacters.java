package org.leetcode.shunxu.leet1500.ch1050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. 查找常用字符
 * <p>
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"] 输出：["e","l","l"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"] 输出：["c","o"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100 1 <= A[i].length <= 100 A[i][j] 是小写字母 https://leetcode-cn.com/problems/find-common-characters/
 * 通过次数50,133 提交次数67,649
 *
 * @author: wangrui
 * @date: 2021/4/3
 */
public class Ch1002FindCommonCharacters {

  public static List<String> commonChars_self(String[] A) {
    int[] ans = new int[26];
    Arrays.fill(ans, Integer.MAX_VALUE);
    for (int i = 0; i < A.length; i++) {
      int[] temp = new int[26];
      for (int j = 0; j < A[i].length(); j++) {
        temp[A[i].charAt(j) - 'a']++;
      }
      for (int j = 0; j < 26; j++) {
        ans[j] = Math.min(temp[j], ans[j]);
      }
    }
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      if (ans[i] != Integer.MAX_VALUE) {
        for (int j = 0; j < ans[i]; j++) {
          list.add(String.valueOf((char) (i + 'a')));
        }
      }
    }
    return list;
  }


  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n(m+∣Σ∣))，其中 n 是数组 A 的长度（即字符串的数目），m 是字符串的平均长度，Σ 为字符集，在本题中字符集为所有小写字母，∣Σ∣=26。
   * <p>      遍历所有字符串并计算 freq 的时间复杂度为 O(nm)；
   * <p>      使用 freq 更新minfreq 的时间复杂度为 (n∣Σ∣)；
   * <p>    由于最终答案包含的字符个数不会超过最短的字符串长度，因此构造最终答案的时间复杂度为 O(m+∣Σ∣)。这一项在渐进意义上小于前二者，可以忽略。
   *
   * <p> 空间复杂度：O(∣Σ∣)，这里只计算存储答案之外的空间。我们使用了数组 freq 和 minfreq，它们的长度均为 |∣Σ∣。
   *
   * @param A
   * @return
   */
  public List<String> commonChars(String[] A) {
    int[] minfreq = new int[26];
    Arrays.fill(minfreq, Integer.MAX_VALUE);
    for (String word : A) {
      int[] freq = new int[26];
      int length = word.length();
      for (int i = 0; i < length; ++i) {
        char ch = word.charAt(i);
        ++freq[ch - 'a'];
      }
      for (int i = 0; i < 26; ++i) {
        minfreq[i] = Math.min(minfreq[i], freq[i]);
      }
    }

    List<String> ans = new ArrayList<String>();
    for (int i = 0; i < 26; ++i) {
      for (int j = 0; j < minfreq[i]; ++j) {
        ans.add(String.valueOf((char) (i + 'a')));
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(commonChars_self(new String[]{"bella", "label", "roller"}));
  }


}


