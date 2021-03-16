package org.leetcode.shunxu.ch550;

/**
 * <p>541. 反转字符串 II
 * <p>给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * <p>如果剩余字符少于 k 个，则将剩余字符全部反转。
 * <p>如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * <p>示例:
 *
 * <p>输入: s = "abcdefg", k = 2
 * <p>输出: "bacdfeg"
 *
 *
 *
 * <p>提示：
 *
 * <p>该字符串只包含小写英文字母。
 * <p>给定字符串的长度和 k 在 [1, 10000] 范围内。
 * <p>通过次数31,163提交次数54,440
 * <p>https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * @Author: shenpei
 * @Date: 2021/3/15 8:17 下午
 */
public class Ch541ReverseStringII {
    public static void main(String[] args) {

    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int num = s.length();
        for (int start = 0; start < num; start += 2 * k) {
            int i = start;
            int j = Math.min(i + k - 1, num - 1);
            while (i < j) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
        return new String(chars);
    }

    /**
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(N)，其中 N 是 s 的大小。我们建立一个辅助数组，用来翻转 s 的一半字符。
     * <p>空间复杂度：O(N)，a 的大小。
     *
     * <p>作者：LeetCode
     * <p>链接：https://leetcode-cn.com/problems/reverse-string-ii/solution/fan-zhuan-zi-fu-chuan-ii-by-leetcode/
     * <p>来源：力扣（LeetCode）
     * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr2(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
