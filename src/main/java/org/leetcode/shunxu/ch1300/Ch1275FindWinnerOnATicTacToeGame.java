package org.leetcode.shunxu.ch1300;

/**
 * <p>1275. 找出井字棋的获胜者
 *
 * <p>A 和 B 在一个 3 x 3 的网格上玩井字棋。
 *
 * <p>井字棋游戏的规则如下：
 *
 * <p>    玩家轮流将棋子放在空方格 (" ") 上。
 * <p>    第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
 * <p>    "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
 * <p>    只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
 * <p>    如果所有方块都放满棋子（不为空），游戏也会结束。
 * <p>    游戏结束后，棋子无法再进行任何移动。
 *
 * <p>给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
 *
 * <p>如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * <p>你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * <p>输出："A"
 * <p>解释："A" 获胜，他总是先走。
 * <p>"X  "    "X  "    "X  "    "X  "    "X  "
 * <p>"   " -> "   " -> " X " -> " X " -> " X "
 * <p>"   "    "O  "    "O  "    "OO "    "OOX"
 *
 * <p>示例 2：
 *
 * <p>输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * <p>输出："B"
 * <p>解释："B" 获胜。
 * <p>"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
 * <p>"   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
 * <p>"   "    "   "    "   "    "   "    "   "    "O  "
 *
 * <p>示例 3：
 *
 * <p>输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * <p>输出："Draw"
 * <p>输出：由于没有办法再行动，游戏以平局结束。
 * <p>"XXO"
 * <p>"OOX"
 * <p>"XOX"
 *
 * <p>示例 4：
 *
 * <p>输入：moves = [[0,0],[1,1]]
 * <p>输出："Pending"
 * <p>解释：游戏还没有结束。
 * <p>"X  "
 * <p>" O "
 * <p>"   "
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= moves.length <= 9
 * <p>    moves[i].length == 2
 * <p>    0 <= moves[i][j] <= 2
 * <p>    moves 里没有重复的元素。
 * <p>    moves 遵循井字棋的规则。
 * https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game/
 * <p>通过次数7,148
 * <p>提交次数13,319
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1275FindWinnerOnATicTacToeGame {

  /**
   * <p>（非官方）方法二 【时间超过100% 】 【java】
   *
   * <p> 万一棋盘不是3x3 一一枚举就很伤了
   * <p> 造福一下只会java的朋友们
   * <p>其他解法有点难理解
   *
   * <p>思路：（可直接看代码，代码有详细注释）
   *
   * <p> 虽然有A、B、Pending、Draw四种答案的可能。我们首先判断A、B谁能赢，再讨论A、B都未胜的情况下游戏是结束了还是继续进行；
   * <p>判断A、B是否有人能取胜，只需要判断最后一个落棋的人是否能胜；（因为要是另外一个人赢了，游戏就结束了，不再有继续下棋的机会）
   * <p>用数组记录最后落棋者的走棋情况，如果等于三，游戏结束，此人胜利；（以3x3为例，其余可以类推）
   * <p>最后落棋者为未胜时，棋盘被下满则Draw，棋盘未下满则Pending。
   *
   * @param moves
   * @return
   */
  public String tictactoe(int[][] moves) {
    int m = moves.length;
    // 用数组记录0-2行、0-2列、正对角线、副对角线是否已满3个棋子
    // count[0-2]对应0-2行、count[3-5]对应0-2列、count[6]对应正对角线、count[7]对应副对角线
    int[] count = new int[8];
    // 思路第2步已解释为何只需考虑最后一个落棋的人
    // 倒序统计此人走棋情况
    for (int i = m - 1; i >= 0; i -= 2) {
      // 此棋对行的影响
      count[moves[i][0]]++;
      // 此棋对列的影响
      count[moves[i][1] + 3]++;
      // 此棋对正对角线的影响
      if (moves[i][0] == moves[i][1]) {
        count[6]++;
      }
      // 此棋对副对角线的影响 (此处为3x3的情况，其余大小的棋盘可以类推)
      if (moves[i][0] + moves[i][1] == 2) {
        count[7]++;
      }
      // 满3个棋子则胜利
      if (count[moves[i][0]] == 3 || count[moves[i][1] + 3] == 3 ||
          count[6] == 3 || count[7] == 3)
      // A先B后 则总长度为偶时 最后为B 反之为A
      {
        return m % 2 == 0 ? "B" : "A";
      }
    }
    // 未胜时，棋盘未下满则继续
    if (moves.length < 9) {
      return "Pending";
    }
    // 未胜时，棋盘下满则平局结束
    return "Draw";
  }

  /**
   * <p>题目分析
   *
   * <p>  井字棋总共只有9个格子，且赢面是固定的
   * <p> 可以使用一个9位二进制数代表行走的结果，规定：
   * <p>    井字棋坐标[i,j]对应于数字的第3i+j位
   * <p>    每走一步棋等价于与对应的位进行(异)或运算
   * <p>判断游戏结果的方法：
   * <p>    将一方的数字num与赢面对应的数字k进行与运算，若结果为k，此方获胜
   * <p>  若双方都未获胜：
   * <p>     若总步数为9步，则平局(Draw)
   * <p>    否则，未完成(Pending)
   * <p>(附1)赢面数字：
   * <p>    井字棋的赢面只有8种(3种横+3种竖+2种对角)
   * <p>   计算举例：{[0,0],[0,1],[0,2]}为横的一种赢面，对应的9位二进制数为000000111，即十进制下的7
   * <p>  事实上，由对应规则可以得知：
   * <p>     3种横的赢面数字是公比为8的等比数列
   * <p>    3种竖的赢面数字是公比为2的等比数列
   * <p>   总共只需要计算出4个数字(1种横+1种竖+2种对角)，其余按倍数推导即可
   * <p>  所有赢面数字分别为7,56(即7×8),448(即7×8^2),73,146(即73×2),292(即73×2^2),273,84
   * <p>(附2)我在评论区对使用位运算的思路进行了更细致的阐述，如果有不清楚的地方欢迎移步评论区~
   *
   * @param moves
   * @return
   */
  public String tictactoe_2(int[][] moves) {
    // a, b record the moving results of A, B
    int a = 0, b = 0, len = moves.length;
    // ac records all cases of winning
    int[] ac = {7, 56, 448, 73, 146, 292, 273, 84};
    for (int i = 0; i < len; i++) {
      // if i is add
      if ((i & 1) == 1) {
        // record the step result
        b ^= 1 << (3 * moves[i][0] + moves[i][1]);
      } else {
        a ^= 1 << (3 * moves[i][0] + moves[i][1]);
      }
    }
    for (int i : ac) {
      // if the moving result contains the winning case in record, then win
      if ((a & i) == i) {
        return "A";
      }
      if ((b & i) == i) {
        return "B";
      }
    }
    // or judge the result by the amount of steps
    return len == 9 ? "Draw" : "Pending";
  }
}
