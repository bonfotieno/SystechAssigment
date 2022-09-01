import java.util.Arrays;
import java.util.Random;

class ThreadFindMax extends  Thread{
    @Override
    public void run() {
        int max = FindMax.values[0];
        for (int j : FindMax.values) {
            if (j > max)
                max = j;
        }
        System.out.println("Max:"+max);
    }

    public void getMax(){
        System.out.println("Am running");
    }
}

public class FindMax {
    static int[] values = new int[88];
    public static void main(String[] args) {
        for (int i =0; i< values.length;i++){
            values[i]=new Random().nextInt(4,90);
        }
        Thread t1 = new ThreadFindMax();
        Thread t2 = new ThreadFindMax();
        Thread t3 = new ThreadFindMax();
        Thread t4 = new ThreadFindMax();
        t1.start();
        t2.start();
        t3.start().getMax();
        t4.start();
        System.out.println(Arrays.toString(values));
    }
}
