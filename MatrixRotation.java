y/*
    Given NxN matrix rotate it by 90 degrees clockwise / anticlockwise
*/
import java.io.*;
public class MatrixRotation{
    static int row = 0, col = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] mat = new int[n][n];
        row = n;
        col = n;
        
        for(int i = 0 ; i < n ; i++){
            String[] arr = br.readLine().split(" ");
            for(int j = 0 ; j < Math.min(arr.length, n) ; j++){
                mat[i][j] = Integer.parseInt(arr[j].trim());
            }
        }

        // 1 = clockwise , 2 = anticlockwise
        int choice = Integer.parseInt(br.readLine().trim());

        if(choice == 1){
            clockwise(mat);
        }
        else if(choice == 2){
            anticlockwise(mat);
        }
    }

    static void clockwise(int[][] mat){
        transpose(mat);

        int begin = 0;
        int end = col - 1;
        while(begin < end){
            for(int i = 0 ; i < row ; i++){
                int temp = mat[i][begin];
                mat[i][begin] = mat[i][end];
                mat[i][end] = temp;
            }
            begin++;
            end--;
        }

        display(mat);
    }

    static void anticlockwise(int[][] mat){
        transpose(mat);

        int begin = 0;
        int end = col - 1;
        while(begin < end){
            for(int i = 0 ; i < col ; i++){
                int temp = mat[begin][i];
                mat[begin][i] = mat[end][i];
                mat[end][i] = temp;
            }
            begin++;
            end--;
        }

        display(mat);
    }

    static void transpose(int[][] mat){
        for(int swap = 1 ; swap < row ; swap++){
            for(int t = swap - 1 ; t >= 0 ; t--){
                int temp = mat[t][swap];
                mat[t][swap] = mat[swap][t];
                mat[swap][t] = temp;
            }
        }
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
