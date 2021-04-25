package org.leetcode.shunxu.leet2000.ch1650;

/**
 * <p>1603. 设计停车系统
 *
 * <p>请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 *
 * <p>请你实现 ParkingSystem 类：
 *
 * <p>    ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
 * <p>    bool addCar(int carType) 检查是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一辆车只能停在  carType
 * 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：
 * <p>["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * <p>[[1, 1, 0], [1], [2], [3], [1]]
 * <p>输出：
 * <p>[null, true, true, false, false]
 *
 * <p>解释：
 * <p>ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * <p>parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
 * <p>parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
 * <p>parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
 * <p>parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= big, medium, small <= 1000
 * <p>    carType 取值为 1， 2 或 3
 * <p>    最多会调用 addCar 函数 1000 次
 *
 * <p>通过次数51,060
 * <p>提交次数60,196
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/design-parking-system/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1603DesignParkingSystem {
    private int big;
    private int medium;
    private int small;

    /**
     * 时间复杂度
     * <p>
     * 时间复杂度：单次操作为 O(1)O(1)。
     * <p>
     * 空间复杂度：O(1)O(1)。
     *
     * @param big
     * @param medium
     * @param small
     */
    public Ch1603DesignParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;

    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
        } else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        } else {
            if (small > 0) {
                small--;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such: ParkingSystem obj = new ParkingSystem(big, medium,
 * small); boolean param_1 = obj.addCar(carType);
 */
