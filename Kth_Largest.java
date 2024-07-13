import java.util.ArrayList;
import java.util.Arrays;

public class Kth_Largest {
    static int findKthLargest(int[] data, int K_th){
        Arrays.sort(data);
        return data[data.length-K_th];
    }
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
        ArrayList<int[]> left = new ArrayList<>();
        ArrayList<int[]> right = new ArrayList<>();
    }
}
