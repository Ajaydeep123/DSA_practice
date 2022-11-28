import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n=scn.nextInt();
    int []arr=new int[n];
    for(int i=0;i<n;++i) arr[i]=scn.nextInt();
    int k=scn.nextInt();
    int [][]queries=new int[k][2];
    for(int i=0;i<k;++i) {
        queries[i][0]=scn.nextInt();
        queries[i][1]=scn.nextInt();
    }
    int []ans=xorQueries(arr,queries);
    for(int ele:ans) System.out.print(ele+" ");
    System.out.println();

  }
  
  public static int[] xorQueries(int[] arr, int[][] queries) {
         int n=arr.length;
        int prefix[]=new int[n];
        int size=queries.length;
        
        int answer[]=new int[size];
        
        prefix[0]=arr[0];
        
//         Making prefix Array
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]^arr[i];
        }
        
        for(int i=0;i<size;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            
            if(left==0) answer[i]=prefix[right];
            else {
                answer[i]=prefix[right]^prefix[left-1];
            }
        }
        
        
        
        
        return answer;
    }
  
}