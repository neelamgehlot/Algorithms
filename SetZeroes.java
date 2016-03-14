/*
    if an element in MxN matrix is 0, set its entire row and column are set to 0.
*/
import java.io.*;
public class SetZeroes{
    static int row = 0, col = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        row = Integer.parseInt(br.readLine().trim());
        col = Integer.parseInt(br.readLine().trim());
        int[][] mat = new int[row][col];

        for(int i = 0 ; i < row ; i++){
            String[] arr = br.readLine().split(" ");
            for(int j = 0 ; j < Math.min(arr.length, col) ; j++){
                mat[i][j] = Integer.parseInt(arr[j].trim());
            }
        }

        boolean rowZero = false;
        boolean colZero = false;

        for(int j = 0 ; j < col ; j++){
            if(mat[0][j] == 0){
                rowZero = true;
                break;
            }
        }

        for(int i = 0 ; i < row ; i++){
            if(mat[i][0] == 0){
                colZero = true;
                break;
            }
        }

        for(int i = 1 ; i < row ; i++){
            for(int j = 1 ; j < col ; j++){
                if(mat[i][j] == 0){
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                }
            }
        }

        for(int i = 0 ; i < row ; i++){
            if(mat[i][0] == 0){
                for(int j = 0 ; j < col ; j++){
                    mat[i][j] = 0;
                }
            }
        }

        for(int j = 0 ; j < col ; j++){
            if(mat[0][j] == 0){
                for(int i = 0 ; i < row ; i++){
                    mat[i][j] = 0;
                }
            }
        }

        if(rowZero){
            for(int j = 0 ; j < col ; j++){
                mat[0][j] = 0;
            }
        }

        if(colZero){
            for(int i = 0 ; i < row ; i++){
                mat[i][0] = 0;
            }
        }

        display(mat);
    }

    static void display(int[][] mat){
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
