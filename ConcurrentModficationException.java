import java.util.ArrayList;
public class ConcurrentModficationException {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(6);
        list.add(7);
        try {
            for(int ele : list){
                System.out.println(ele);
                list.remove(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
