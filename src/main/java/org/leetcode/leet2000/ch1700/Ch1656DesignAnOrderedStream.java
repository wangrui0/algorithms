package org.leetcode.leet2000.ch1700;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1656. 设计有序流
 *
 * <p>有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
 *
 * <p>设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 *
 * <p>实现 OrderedStream 类：
 *
 * <p>    OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * <p>    String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * <p>        如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个
 * id + 1 。
 *
 * <p>        否则，返回一个空列表。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入
 * <p>["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * <p>[[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 * <p>输出
 * <p>[null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 *
 * <p>解释
 * <p>OrderedStream os= new OrderedStream(5);
 * <p>os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
 * <p>os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
 * <p>os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
 * <p>os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
 * <p>os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 1000
 * <p>    1 <= id <= n
 * <p>    value.length == 5
 * <p>    value 仅由小写字母组成
 * <p>    每次调用 insert 都会使用一个唯一的 id
 * <p>    恰好调用 n 次 insert
 *
 * <p>通过次数6,569
 * <p>提交次数8,373
 * <p>https://leetcode-cn.com/problems/design-an-ordered-stream/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:30 下午
 */
public class Ch1656DesignAnOrderedStream {
    private String[] stream;
    private int ptr, n;

    public Ch1656DesignAnOrderedStream(int n) {
        stream = new String[n + 1];
        this.ptr = 1;
        this.n = n;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> ans = new ArrayList<>();
        for (int i = ptr; i <= n; i++) {
            if (stream[i] == null) {
                break;
            }
            ans.add(stream[i]);
            ptr++;
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such: OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
