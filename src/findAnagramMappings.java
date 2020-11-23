/**
 760. 找出变位映射
 给定两个列表 Aand B，并且 B 是 A 的变位（即 B 是由 A 中的元素随机排列后组成的新列表）。

 我们希望找出一个从 A 到 B 的索引映射 P 。一个映射 P[i] = j 指的是列表 A 中的第 i 个元素出现于列表 B 中的第 j 个元素上。

 列表 A 和 B 可能出现重复元素。如果有多于一种答案，输出任意一种。

 例如，给定

 A = [12, 28, 46, 32, 50]
 B = [50, 12, 32, 46, 28]


 需要返回

 [1, 4, 3, 2, 0]
 P[0] = 1 ，因为 A 中的第 0 个元素出现于 B[1]，而且 P[1] = 4 因为 A 中第 1 个元素出现于 B[4]，以此类推。



 注：

 A, B 有相同的长度，范围为 [1, 100]。
 A[i], B[i] 都是范围在 [0, 10^5] 的整数。
 https://leetcode-cn.com/problems/find-anagram-mappings/
 */
public class findAnagramMappings {
    public static void main(String[] args) {
       int[] A ={12, 28, 46, 32, 50};
       int [] B = {50, 12, 32, 46, 28};
        for (int i : anagramMappings(A, B)) {
            System.out.println(i);
        }
    }
    public static int[] anagramMappings(int[] A, int[] B) {
        int []index=new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(B[j]==A[i]){
                    index[i]=j;
                    break;
                }
            }
        }
        return index;
    }
}