package org.leetcode.shunxu.ch800;

import java.util.HashMap;
import java.util.Map;

/**
 * <P>给定两个列表 A and B，并且 B 是 A 的变位（即 B 是由 A 中的元素随机排列后组成的新列表）。
 *
 * <P>我们希望找出一个从 A 到 B 的索引映射 P 。
 * <P>一个映射 P[i] = j 指的是列表 A 中的第 i 个元素出现于列表 B 中的第 j 个元素上。
 *
 * <P>列表 A 和 B 可能出现重复元素。如果有多于一种答案，输出任意一种。
 * <P>找出变位映射
 * <P>例如，给定
 * <P>A = [12, 28, 46, 32, 50]
 * <P>B = [50, 12, 32, 46, 28]
 *
 * <P>需要返回
 * <P>[1, 4, 3, 2, 0]
 * <P>P[0] = 1 ，因为 A 中的第 0 个元素出现于 B[1]，
 * <P>而且 P[1] = 4 因为 A 中第 1 个元素出现于 B[4]，以此类推。
 *
 * <P>注：
 * <P> A, B 有相同的长度，范围为 [1, 100]。
 * <P> A[i], B[i] 都是范围在 [0, 10^5] 的整数。
 *
 * @author: wangrui
 * @date: 2021/3/24
 */
public class Ch760FindAnagramMappings {

  public int[] anagramMappings(int[] A, int[] B) {
    Map<Integer, Integer> map = new HashMap<>();
    int nA = A.length;
    int nB = B.length;
    for (int i = 0; i < nB; i++) {
      map.put(B[i], i);
    }
    int[] ans = new int[nA];
    for (int i = 0; i < nA; i++) {
      ans[i] = map.get(A[i]);
    }
    return ans;
  }
}
