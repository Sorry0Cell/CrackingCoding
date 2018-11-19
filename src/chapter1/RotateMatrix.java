package chapter1;

/**
 * Rotate a image by 90 degrees, clockwise, counterclockwise
 * 时间复杂度: O(n), n是矩阵元素的个数
 *
 * 核心: 在旋转的时候定义一个offset
 *
 * @author andy
 * @date Nov 19th
 */
public class RotateMatrix {

    int[][] matrix;

    public RotateMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    // 顺时针
    public boolean rotateCW(){
        if(matrix.length == 0 || matrix.length != matrix[1].length){
            System.out.println("Can't rotate, the size of matrix should be n*n ...");
            return false;
        }
        int n = matrix.length;
        for(int layer=0; layer<n/2; layer++){
            int firstIndex = layer;
            int lastIndex = n - 1 - layer;

            for(int i=firstIndex; i<lastIndex; i++){
                int offset = i - firstIndex;
                //save top
                int top = matrix[firstIndex][i];
                // left to top
                matrix[firstIndex][i] = matrix[lastIndex-offset][firstIndex];
                // bottom to left
                matrix[lastIndex-offset][firstIndex] = matrix[lastIndex][lastIndex-offset];
                // right to bottom
                matrix[lastIndex][lastIndex-offset] = matrix[i][lastIndex];
                // top to right
                matrix[i][lastIndex] = top;
            }
        }
        return true;
    }

    // 逆时针
    public boolean rotateCCW(){
        if(matrix.length == 0 || matrix.length != matrix[0].length){
            System.out.println("Can't rotate, the size of matrix should be n*n ...");
            return false;
        }

        int n = matrix.length;
        for(int layer=0; layer<n/2; layer++){
            int firstIndex = layer;
            int lastIndex = n - 1 - layer;

            for(int i=firstIndex; i<lastIndex; i++){
                int offset = i - firstIndex;
                //save top
                int top = matrix[firstIndex][i];
                // right to top
                matrix[firstIndex][i] = matrix[i][lastIndex];
                // bottom to right
                matrix[i][lastIndex] = matrix[lastIndex][lastIndex-offset];
                // left to bottom
                matrix[lastIndex][lastIndex-offset] = matrix[lastIndex-offset][i];
                // top to left
                matrix[lastIndex-offset][i] = top;
            }
        }
        return true;
    }
}
