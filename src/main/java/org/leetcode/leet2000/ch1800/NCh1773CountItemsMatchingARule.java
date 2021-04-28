package org.leetcode.leet2000.ch1800;

import java.util.List;

/**
 * <p>1773. 统计匹配检索规则的物品数量
 *
 * <p>给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 *
 * <p>另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 *
 * <p>如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 *
 * <p>    ruleKey == "type" 且 ruleValue == typei 。
 * <p>    ruleKey == "color" 且 ruleValue == colori 。
 * <p>    ruleKey == "name" 且 ruleValue == namei 。
 *
 * <p>统计并返回 匹配检索规则的物品数量 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color",
 * ruleValue = "silver"
 * <p>输出：1
 * <p>解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 *
 * <p>示例 2：
 *
 * <p>输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type",
 * ruleValue = "phone"
 * <p>输出：2
 * <p>解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"]
 * 未匹配检索规则。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= items.length <= 104
 * <p>    1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
 * <p>    ruleKey 等于 "type"、"color" 或 "name"
 * <p>    所有字符串仅由小写字母组成
 *
 * <p>通过次数12,189
 * <p>提交次数14,562
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/count-items-matching-a-rule/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:10 下午
 */
public class NCh1773CountItemsMatchingARule {

  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    return 0;
  }
}
