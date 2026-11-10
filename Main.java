import java.io.*;

public class Main {
    private static final InputStream IN = new BufferedInputStream(System.in);
    private static int nextInt() throws IOException {
        int c;
        do { c = IN.read(); } while (c <= 32 && c >= 0);
        if (c < 0) return -1;
        int value = 0;
        while (c > 32 && c >= 0) { value = value * 10 + c - '0'; c = IN.read(); }
        return value;
    }
    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) { int value = nextInt(); if (value < 0) break; a[i] = value; }
        int slow = 0, fast = 0;
        do { slow = a[slow]; fast = a[a[fast]]; } while (slow != fast);
        int start = 0;
        while (start != slow) { start = a[start]; slow = a[slow]; }
        System.out.println(start);
    }
}
