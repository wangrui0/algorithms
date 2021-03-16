package org.leetcode.shunxu.ch500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>  500. 键盘行
 *
 * <p> 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * <p> 美式键盘 中：
 *
 * <p>     第一行由字符 "qwertyuiop" 组成。
 * <p>    第二行由字符 "asdfghjkl" 组成。
 * <p>    第三行由字符 "zxcvbnm" 组成。
 *
 * <p>  American keyboard
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：words = ["Hello","Alaska","Dad","Peace"]
 * <p> 输出：["Alaska","Dad"]
 *
 * <p> 示例 2：
 *
 * <p> 输入：words = ["omk"]
 * <p> 输出：[]
 *
 * <p> 示例 3：
 *
 * <p> 输入：words = ["adsdf","sfd"]
 * <p> 输出：["adsdf","sfd"]
 *
 *
 *
 * <p> 提示：
 *
 * <p>    1 <= words.length <= 20
 * <p>    1 <= words[i].length <= 100
 * <p>    words[i] 由英文字母（小写和大写字母）组成
 *
 * <p> https://leetcode-cn.com/problems/keyboard-row/
 *
 * @author: wangrui
 * @date: 2021/3/12
 */
public class Ch500KeyboardRow {

    public String[] findWords(String[] words) {
        if (words == null) {
            return null;
        }

        List<String> ans = new ArrayList<>();

        // 字典行
        String lines[] = new String[]{
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        // 挨个单词匹配是否满足条件
        for (String word : words) {
            if (judge(word.toLowerCase(), lines)) {
                ans.add(word);
            }
        }

        // 刚看到的时候有点疑惑返回值为什么不是List<String>而是String[]
        // list可直接利用API转换为String数组即可
        return ans.toArray(new String[ans.size()]);
    }

    private boolean judge(String word, String[] lines) {
        boolean ok = true;
        String find = null;

        // 先用word首字符确定属于哪一行
        for (String line : lines) {
            if (line.indexOf(word.charAt(0)) > -1) {
                find = line;
                break;
            }
        }




        if (find == null) {
            ok = false;
            return ok;
        }

        // 判断word字符串所有字符是否都属于同一行
        for (int i = 1; i < word.length(); i++) {
            if (find.indexOf(word.charAt(i)) < 0) {
                ok = false;
                break;
            }
        }

        return ok;
    }

    public String[] findWords2(String[] words) {
        HashMap<Character, Integer> map = getMap();
        String[] res = new String[words.length];
        int index = 0;
        for (String word : words) {
            int tmp = 0;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (c >= 97) {
                    //小写字母转大写
                    c = (char) (c - 32);
                }
                int line = map.get(c);
                if (tmp != 0 && line != tmp) {
                    break;
                }
                tmp = line;
                if (i == len - 1) {
                    res[index++] = word;
                }
            }
        }
        return Arrays.copyOf(res, index);
    }

    public HashMap getMap() {
        HashMap<Character, Integer> map = new HashMap();
        //第一行
        map.put('Q', 1);
        map.put('W', 1);
        map.put('E', 1);
        map.put('R', 1);
        map.put('T', 1);
        map.put('Y', 1);
        map.put('U', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('P', 1);
        //第二行
        map.put('A', 2);
        map.put('S', 2);
        map.put('D', 2);
        map.put('F', 2);
        map.put('G', 2);
        map.put('H', 2);
        map.put('J', 2);
        map.put('K', 2);
        map.put('L', 2);
        //第三行
        map.put('Z', 3);
        map.put('X', 3);
        map.put('C', 3);
        map.put('V', 3);
        map.put('B', 3);
        map.put('N', 3);
        map.put('M', 3);
        return map;

    }
}

