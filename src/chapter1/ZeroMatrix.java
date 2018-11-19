package chapter1;


/**
 * Write a method such that if a element in the matrix is 0, then the whole row and the whole col
 * will be zero
 *
 * @author andy
 * @date Nov 19th
 */
public class ZeroMatrix {

    int[][] matrix;

    public ZeroMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    /**
     * 某行或某列填充0
     * @param isRow
     * @param index
     * @return
     */
    public boolean nullify(boolean isRow, int index){
        if(isRow){
            for(int j=0; j<matrix[0].length; j++){
                matrix[index][j] = 0;
            }
        } else {
            for(int i=0; i<matrix.length; i++){
                matrix[i][index] = 0;
            }
        }
        return true;
    }

    public boolean setZeros(){
        // check which rows and cols have zeros;
        boolean[] rowHasZero = new boolean[matrix.length];
        boolean[] colHasZero = new boolean[matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowHasZero[i] = true;
                    colHasZero[j] = true;
                }
            }
        }

        for(int i=0; i<matrix.length; i++){
            if(rowHasZero[i]){
                nullify(true, i);
            }
        }

        for(int j=0; j<matrix[0].length; j++){
            if(colHasZero[j]){
                nullify(false, j);
            }
        }
        return true;
    }

    /***
     * 更节省空间的做法, 不用开辟boolean数组, 把第一行、列作为flag
     * @return
     */
    public boolean setZerosSpaceLess(){
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for(int j=0; j<matrix[0].length; j++){
            if(matrix[0][j] == 0){
                firstRowHasZero = true;
                break;
            }
        }

        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColHasZero = true;
                break;
            }
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    nullify(true, i);
                    nullify(false, j);
                }
            }
        }

        if(firstRowHasZero){
            nullify(true, 0);
        }
        if(firstColHasZero){
            nullify(false,0);
        }

        return true;
    }
}
