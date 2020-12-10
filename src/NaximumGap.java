import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 164. 最大间距
 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

 如果数组元素个数小于 2，则返回 0。

 示例 1:

 输入: [3,6,9,1]
 输出: 3
 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 示例 2:

 输入: [10]
 输出: 0
 解释: 数组元素个数小于 2，因此返回 0。
 https://leetcode-cn.com/problems/maximum-gap/
 */
public class NaximumGap {
    public static void main(String[] args) {
        int [] arr={1,10000000};
        System.out.println(maximumGap(arr));
    }
    public static  int maximumGap(int[] nums) {
        int diff=0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int start=-1;
        for (Integer integer : set) {
            if(start<0){
                start=integer;
            }
            diff= Math.max(integer - start, diff);
            start=integer;
        }
        return diff;
    }
}
