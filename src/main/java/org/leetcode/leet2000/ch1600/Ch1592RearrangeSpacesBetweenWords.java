package org.leetcode.leet2000.ch1600;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1592. 重新排列单词间的空格
 *
 * <p>给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 *
 * <p>请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 *
 * <p>返回 重新排列空格后的字符串 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：text = "  this   is  a sentence "
 * <p>输出："this   is   a   sentence"
 * <p>解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
 *
 * <p>示例 2：
 *
 * <p>输入：text = " practice   makes   perfect"
 * <p>输出："practice   makes   perfect "
 * <p>解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
 *
 * <p>示例 3：
 *
 * <p>输入：text = "hello   world"
 * <p>输出："hello   world"
 *
 * <p>示例 4：
 *
 * <p>输入：text = "  walks  udp package   into  bar a"
 * <p>输出："walks  udp  package  into  bar  a "
 *
 * <p>示例 5：
 *
 * <p>输入：text = "a"
 * <p>输出："a"
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= text.length <= 100
 * <p>    text 由小写英文字母和 ' ' 组成
 * <p>    text 中至少包含一个单词
 *
 * <p>通过次数6,450
 * <p>提交次数14,461
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/rearrange-spaces-between-words/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1592RearrangeSpacesBetweenWords {
    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
    }

    public static String reorderSpaces(String text) {
        String[] splits = text.trim().split("\\s+");
        int countWord = 0;
        for (String word : splits) {
            countWord += word.length();
        }
        int blank = text.length() - countWord;
        StringBuilder sb = new StringBuilder();
        int eachBlank;
        int reminder;
        if (splits.length == 1) {
            eachBlank = 0;
            reminder = blank;
        } else {
            eachBlank = blank / (splits.length - 1);
            reminder = blank % (splits.length - 1);
        }

        for (int i = 0; i < splits.length; i++) {
            String word = splits[i];
            sb.append(word);
            int num = 0;
            if (i == splits.length - 1) {
                break;
            }
            while (num < eachBlank) {
                sb.append(" ");
                num++;
            }
        }
        for (int i = 0; i < reminder; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public String reorderSpaces_2(String text) {
        StringBuilder sb = new StringBuilder();
        //空格计数
        int spaceCnt = 0;
        //存储单词
        List<String> words = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                //空格数加1
                spaceCnt++;
            } else {
                int j = i + 1;
                while (j < text.length() && text.charAt(j) != ' ') {
                    j++;
                }
                //加入words
                words.add(text.substring(i, j));
                i = j - 1;
            }
        }
        //特判只有1个单词的情况，避免”除0异常“
        if (words.size() == 1) {
            //拼接上唯一的单词
            sb.append(words.get(0));
            //拼接上所有的空格
            for (int i = 0; i < spaceCnt; i++) {
                sb.append(' ');
            }
        } else {
            //间隔数
            int gap = spaceCnt / (words.size() - 1);
            //单词间的空格
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < gap; i++) {
                space.append(' ');
            }
            //剩余数
            int left = spaceCnt % (words.size() - 1);
            for (int i = 0; i < words.size(); i++) {
                //拼接单词
                sb.append(words.get(i));
                //拼接空格
                if (i != words.size() - 1) {
                    sb.append(space);
                }
            }
            //如果有剩余的，拼接到末尾
            for (int i = 0; i < left; i++) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

}
