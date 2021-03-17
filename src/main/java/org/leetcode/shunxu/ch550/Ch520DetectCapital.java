package org.leetcode.shunxu.ch550;

/**
 * <p>520. 检测大写字母
 * <p>给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * <p>我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * <p>全部字母都是大写，比如"USA"。
 * <p>单词中所有字母都不是大写，比如"leetcode"。
 * <p>如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * <p>否则，我们定义这个单词没有正确使用大写字母。
 *
 * <p>示例 1:
 *
 * <p>输入: "USA"
 * <p>输出: True
 * <p>示例 2:
 *
 *
 * <p>输入: "FlaG"
 * <p>输出: False
 * <p>注意: 输入是由大写和小写拉丁字母组成的非空单词。
 *
 * <p>通过次数32,849提交次数58,743
 * <p> 在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/detect-capital/
 * @Author: shenpei
 * @Date: 2021/3/15 8:23 下午
 */
public class Ch520DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("FlaG"));
    }

    public static boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                count++;
            }
        }
        if (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' || count == word.length()) {
            return true;
        } else if (count == 0) {
            return true;
        }
        return false;
    }

    public boolean detectCapitalUse2(String word) {
        boolean res = false;
        int count = 0;
        char x;
        for (int i = 0; i < word.length(); i++) {
            x = word.charAt(i);
            if(x >= 65 && x <= 90) {
                count++;
            }
        }
        if ((count == 1 && (word.charAt(0) >= 65 && word.charAt(0) <= 90)) || (count == word.length())) {
            res = true;
        } else if (count == 0) {
            res = true;
        }
        return res;
    }
}
