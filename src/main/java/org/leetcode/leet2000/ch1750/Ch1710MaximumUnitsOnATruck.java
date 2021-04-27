package org.leetcode.leet2000.ch1750;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>1710. 卡车上的最大单元数
 *
 * <p>请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 *
 * <p>    numberOfBoxesi 是类型 i 的箱子的数量。
 * <p>    numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 *
 * <p>整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 *
 * <p>返回卡车可以装载 单元 的 最大 总数。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * <p>输出：8
 * <p>解释：箱子的情况如下：
 * <p>- 1 个第一类的箱子，里面含 3 个单元。
 * <p>- 2 个第二类的箱子，每个里面含 2 个单元。
 * <p>- 3 个第三类的箱子，每个里面含 1 个单元。
 * <p>可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * <p>单元总数 = (1 *<p>3) + (2 *<p>2) + (1 *<p>1) = 8
 *
 * <p>示例 2：
 *
 * <p>输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * <p>输出：91
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= boxTypes.length <= 1000
 * <p>    1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * <p>    1 <= truckSize <= 106
 *
 * <p>通过次数8,159
 * <p>提交次数11,702
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-units-on-a-truck/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:36 下午
 */
public class Ch1710MaximumUnitsOnATruck {

  public int maximumUnits(int[][] boxTypes, int truckSize) {
    //重写比较器,让能装单元数多的箱子排在前边
    Arrays.sort(boxTypes, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return b[1] - a[1];
      }
    });
    //贪心,先让能装多的箱子上车

    int count = 0;
    for (int[] box : boxTypes) {
      if (box[0] < truckSize) {
//0表示箱子数量,1表示箱子里装的单元数
        count += box[0] * box[1];
        truckSize -= box[0];
      } else {
        count += truckSize * box[1];
        return count;
      }
    }
    return count;
  }

  public int maximumUnits_2(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (o1, o2) -> (o2[1] - o1[1]));
    int ans = 0;
    for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
      int num = Math.min(truckSize, boxTypes[i][0]);
      truckSize -= num;
      ans += num * boxTypes[i][1];
    }
    return ans;
  }

  public static int maximumUnits_3(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
    int ans = 0;
    for (int i = 0; i < boxTypes.length; i++) {
      if (boxTypes[i][0] <= truckSize) {
        ans += boxTypes[i][0] * boxTypes[i][1];
        truckSize -= boxTypes[i][0];
      } else {
        ans += truckSize * boxTypes[i][1];
        return ans;
      }
    }
    return ans;
  }
}
