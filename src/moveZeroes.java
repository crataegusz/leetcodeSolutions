import java.util.Arrays;

/**
 283. 移动零
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 https://leetcode-cn.com/problems/move-zeroes/
 */
public class moveZeroes {
    public static void main(String[] args) {
        int []arr={0,0,1};
        moveZeroes(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static  void moveZeroes(int[] nums) {
       int i=0;
         for (int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                nums[i]=nums[j];
                //单个元素时避免覆盖
                if(j!=i){
                    //将2个元素置换
                    nums[j]=0;
                }
                i++;
            }
         }
    }

    public void moveZeroeBubbling(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                for (int j=i;j<nums.length;j++){
                    if(nums[j]!=0){
                        nums[i]=nums[j];
                        nums[j]=0;
                        break;
                    }
                }
            }
        }
    }
}

