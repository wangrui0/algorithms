package org.leetcode.lcp;

/**
 * <p>LCP 33. 蓄水
 * <p>给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 *
 * <p>升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * <p>蓄水：将全部水桶接满水，倒入各自对应的水缸
 * <p>每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 *
 * <p>注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 *
 * <p>示例 1：
 *
 * <p>输入：bucket = [1,3], vat = [6,8]
 *
 * <p>输出：4
 *
 * <p>解释：
 * <p>第 1 次操作升级 bucket[0]；
 * <p>第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
 * <p>vat1.gif
 *
 * <p>示例 2：
 *
 * <p>输入：bucket = [9,0,1], vat = [0,2,2]
 *
 * <p>输出：3
 *
 * <p>解释：
 * <p>第 1 次操作均选择升级 bucket[1]
 * <p>第 2~3 次操作选择蓄水，即可完成蓄水要求。
 *
 * <p>提示：
 *
 * <p>1 <= bucket.length == vat.length <= 100
 * <p>0 <= bucket[i], vat[i] <= 10^4
 * <p>通过次数2,344提交次数14,925
 * <p>https://leetcode-cn.com/problems/o8SXZn/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:22 下午
 */
public class NLCP033O8SXZn {
    public int storeWater(int[] bucket, int[] vat) {
        return -1;
    }
}
