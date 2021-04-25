package org.leetcode.leet1500.ch1450;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>1436. 旅行终点站
 *
 * <p>给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi
 * 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 *
 * <p>题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * <p>输出："Sao Paulo"
 * <p>解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 *
 * <p>示例 2：
 *
 * <p>输入：paths = [["B","C"],["D","B"],["C","A"]]
 * <p>输出："A"
 * <p>解释：所有可能的线路是：
 * <p>"D" -> "B" -> "C" -> "A".
 * <p>"B" -> "C" -> "A".
 * <p>"C" -> "A".
 * <p>"A".
 * <p>显然，旅行终点站是 "A" 。
 *
 * <p>示例 3：
 *
 * <p>输入：paths = [["A","Z"]]
 * <p>输出："Z"
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= paths.length <= 100
 * <p>    paths[i].length == 2
 * <p>    1 <= cityAi.length, cityBi.length <= 10
 * <p>    cityAi != cityBi
 * <p>    所有字符串均由大小写英文字母和空格字符组成。
 * https://leetcode-cn.com/problems/destination-city/
 * <p>通过次数19,063
 * <p>提交次数24,361
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/20
 */
public class Ch1436DestinationCity {

  public String destCity(List<List<String>> paths) {
    Map<String, String> map = new HashMap<>();
    for (List<String> path : paths) {
      map.put(path.get(0), path.get(1));
    }
    // 首先将paths中的起点和终点分别存在map的键值对中；
    for (String s : map.values()) {
      if (!map.containsKey(s)) {
        return s;
      }
    }
    // 如果一个键值对的值不存在于这个map的键的集合中，就说明它是终点；
    return null;
  }
}
