package assignment1;

public class Recursion {
    public static int[] getMinMax(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return new int[] {min, max};
    }
    public int print(int small, int big) {
        int[] minMax = getMinMax(small, big);
        small = minMax[0];
        big = minMax[1];
        if (small < big) {
            System.err.println(small);
            return print(small+1, big);
        }
        return small;
    }
    
}
