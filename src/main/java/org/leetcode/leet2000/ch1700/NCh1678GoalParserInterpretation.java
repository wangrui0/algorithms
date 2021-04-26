package org.leetcode.leet2000.ch1700;

/**
 *<p>1678. 设计 Goal 解析器
 *<p>请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 *<p>给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 *
 *
 *<p>示例 1：
 *
 *<p>输入：command = "G()(al)"
 *<p>输出："Goal"
 *<p>解释：Goal 解析器解释命令的步骤如下所示：
 *<p>G -> G
 *<p>() -> o
 *<p>(al) -> al
 *<p>最后连接得到的结果是 "Goal"
 *<p>示例 2：
 *
 *<p>输入：command = "G()()()()(al)"
 *<p>输出："Gooooal"
 *<p>示例 3：
 *
 *<p>输入：command = "(al)G(al)()()G"
 *<p>输出："alGalooG"
 *
 *
 *<p>提示：
 *
 *<p>1 <= command.length <= 100
 *<p>command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 *<p>通过次数14,334提交次数17,279
 *<p>https://leetcode-cn.com/problems/goal-parser-interpretation/
 *<p>@Author: shenpei
 *<p>@Date: 2021/4/25 7:32 下午
 */
public class NCh1678GoalParserInterpretation {
}
