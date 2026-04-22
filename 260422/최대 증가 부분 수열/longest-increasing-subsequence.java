import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static int maxLen;

    public static void initialize(){
        dp = new int[N];

        for(int i = 0; i < N; i++){
            dp[i] = Integer.MIN_VALUE;
        }

        dp[0] = arr[0];
    }

    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        arr = new int[N];
        maxLen = 1;

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initialize();

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = 0; i < N; i++){
            maxLen = Math.max(maxLen, dp[i]);
        }



        System.out.println(maxLen);
    }
}