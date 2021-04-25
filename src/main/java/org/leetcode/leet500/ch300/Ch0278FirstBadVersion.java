package org.leetcode.leet500.ch300;

/**
 * <p> 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * <p> 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * <p> 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * <p> 示例:
 *
 * <p> 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * <p> 调用 isBadVersion(3) -> false
 * <p> 调用 isBadVersion(5) -> true
 * <p> 调用 isBadVersion(4) -> true
 *
 * <p> 所以，4 是第一个错误的版本。
 *
 * <p> 通过次数81,038
 * <p> 提交次数191,666
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/first-bad-version
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 *
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch0278FirstBadVersion extends VersionControl {

  /**
   * 复杂度分析
   *
   *     时间复杂度：O(logn)。搜索空间每次减少一半，因此时间复杂度为 O(logn)。
   *     空间复杂度：O(1)
   *
   * 作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/first-bad-version/solution/di-yi-ge-cuo-wu-de-ban-ben-by-leetcode/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param n
   * @return
   */
  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if(isBadVersion(mid)){
        right=mid;
      }else{
        left=mid+1;
      }
    }
    return left;
  }

  public int firstBadVersion2(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}

class VersionControl {

  public boolean isBadVersion(int version) {
    return true;
  }
}
