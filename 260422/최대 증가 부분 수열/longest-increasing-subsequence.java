import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] lis;

    // lower bound:
    // lis[0 ~ len-1] 범위에서
    // 처음으로 target 이상이 나오는 위치 반환
    public static int lowerBound(int len, int target) {
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        arr = new int[N];
        lis = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;

        for (int i = 0; i < N; i++) {
            int x = arr[i];

            if (len == 0 || x > lis[len - 1]) {
                lis[len] = x;
                len++;
            } else {
                int idx = lowerBound(len, x);
                lis[idx] = x;
            }
        }

        System.out.println(len);
    }
}