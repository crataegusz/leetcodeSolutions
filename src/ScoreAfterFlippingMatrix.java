import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 861. 翻转矩阵后的得分
 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。

 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。

 返回尽可能高的分数。



 示例：

 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 输出：39
 解释：
 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39


 提示：

 1 <= A.length <= 20
 1 <= A[0].length <= 20
 A[i][j] 是 0 或 1
 https://leetcode-cn.com/problems/score-after-flipping-matrix/
 */
public class ScoreAfterFlippingMatrix {

    public static void main(String[] args) {
        String a="10046_10045";
        System.out.println(count(25, 9));
    }
    public static  int matrixScore(int[][] A) {
        //如果想要总值最大，那么首位必定置位1 首位1=后续所有位为1之和
        int col = A.length;
        int row = A[0].length;
        for (int i = 0; i < col; i++) {
            if(A[i][0]==0){
                for (int j = 0; j < row; j++) {
                    A[i][j]=A[i][j]==0? 1:0;
                }
            }
        }
        //从最后一列开始翻转至第二列 使每一列0的数量大于1的数量
        int sum=0;
        int p=1;
        for (int i = row-1; i >= 0; i--) {
            int count_zero=0;
            int  count_one=0;
            for (int j = 0; j < col; j++) {
                if(A[j][i]==0){
                    count_zero++;
                }
                else {
                    count_one++;
                }
                sum +=(Math.max(count_one, count_zero))*p;
                p*=2;
            }
        }
        return sum;
    }

    public static int count(int m,int n){
        int i=0;
        if(m==0 && n==0){
            return 1;
        }
         if(m>0){
            i +=count(m-1,n);
        }
         if(n>0){
             i +=count(m,n-1);
         }
         return i;
    }
}
