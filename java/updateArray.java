//updatedarray
import java.util.*;
public class updateArray {
        public static void main(String [] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            Integer [] arr = new Integer[n];
            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int l = sc.nextInt();
            int m = sc.nextInt();
            int key = sc.nextInt();

            Arrays.sort(arr,l,m+1,Collections.reverseOrder());

            int min = Math.abs(arr[0]-key);
            int index = 0;
            int val = arr[0];

            for(int i =1;i<arr.length;i++){
                if(Math.abs(arr[i]-key)<min)
                {
                    min = Math.abs(arr[i]-key);
                    index = i;
                    val = arr[i];
                }
            }

            System.out.println(val*index);
            sc.close();
        }
    }

