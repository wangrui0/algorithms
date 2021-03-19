package org.leetcode.shunxu.ch700;

/**
 * <p>657. 机器人能否返回原点
 *
 * <p>在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 *
 * <p>移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 *
 * <p>注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 *
 *
 *
 * <p>示例 1:
 *
 * <p>输入: "UD"
 * <p>输出: true
 * <p>解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
 *
 * <p>示例 2:
 *
 * <p>输入: "LL"
 * <p>输出: false
 * <p>解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
 * <p>https://leetcode-cn.com/problems/robot-return-to-origin/
 * <p>通过次数75,095
 * <p>提交次数96,038
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/18
 */
public class Ch657RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'L') {
                y--;
            } else if (c == 'R') {
                y++;
            } else if (c == 'U') {
                x++;
            } else {
                x--;
            }
        }
        return x == 0 && y == 0;
    }

    /**
     * <p>复杂度分析
     *
     * <p> 时间复杂度： O(N)，其中 N 表示 moves 指令串的长度。我们只需要遍历一遍字符串即可。
     *
     * <p>空间复杂度： O(1)。我们只需要常数的空间来存放若干变量
     *
     * <p>作者：LeetCode-Solution
     * <p>链接：https://leetcode-cn.com/problems/robot-return-to-origin/solution/ji-qi-ren-neng-fou-fan-hui-yuan-dian-by-leetcode-s/
     * <p>来源：力扣（LeetCode）
     * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param moves
     * @return
     */
    public boolean judgeCircle2(String moves) {
        int x = 0, y = 0;
        int length = moves.length();
        for (int i = 0; i < length; i++) {
            char move = moves.charAt(i);
            if (move == 'U') {
                y--;
            } else if (move == 'D') {
                y++;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }
        return x == 0 && y == 0;
    }

}
