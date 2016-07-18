public class EggDrop {

   public static void main(String args[]){
       int r = calculate(100,2);
       System.out.println("Result: "+r);
   }
   
   public static int calculate(int floors,int eggs){
       
       int matrix[][] = new int[eggs+1][floors+1];
       int c =0;
       
       System.out.println("Before");
       for(int e=0;e<=eggs;e++){
       	for(int f=0;f<=floors;f++){
       		System.out.print(matrix[e][f]+" ");
       	}
       	System.out.println();
       }
       
       for(int i=0; i <= floors; i++){
       	matrix[1][i] = i;
       }
       
       for(int e = 2; e <= eggs; e++){
           for(int f = 1; f <=floors; f++){
           	matrix[e][f] = Integer.MAX_VALUE;
               for(int k = 1; k <=f ; k++){
                   c = 1 + Math.max(matrix[e-1][k-1], matrix[e][f-k]);
                   if(c < matrix[e][f]){
                   	matrix[e][f] = c;
                   }
               }
           }
       }
       
       System.out.println("After");
       for(int e=0;e<=eggs;e++){
       	for(int f=0;f<=floors;f++){
       		System.out.print(matrix[e][f]+" ");
       	}
       	System.out.println();
       }
       
       return matrix[eggs][floors];
   }
}