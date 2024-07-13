import java.util.ArrayList;

public class Interval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int x=newInterval[0];
        int y=newInterval[1];
        ArrayList<int[]> left = new ArrayList();
        ArrayList<int[]> right = new ArrayList();
        for(int[] interval : intervals){
            if(x>interval[1]){
                left.add(interval);
            }
            else if(y<interval[0]){
                right.add(interval);
            }
            else{
                x=Math.min(x,interval[0]);
                y=Math.max(y,interval[1]);
            }
        }
        ArrayList<int[]> result = new ArrayList<>(left);
        result.add(new int[]{x, y});
        result.addAll(right);
        return result.toArray(new int[result.size()][]);
    }
    static void display(int[][] intervals){
        for(int[] ele : intervals){
            System.out.println("["+ele[0]+","+ele[1]+"]");
        }
    }
    public static void main(String[] args) {
        int data[][] = insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8});
        display(data);
    }
}
