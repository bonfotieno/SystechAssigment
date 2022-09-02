import java.util.Arrays;
import java.util.Random;

class ThreadFindMax extends Thread{
    private int start;
    private int end;
    private int max;
    public ThreadFindMax(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getMax() {
        return this.max;
    }

    @Override
    public void run() {
        this.max = FindMax.values[0];
        for (int j=start; j < end; j++) {
            if (FindMax.values[j] > this.max)
                this.max = FindMax.values[j];
        }
        System.out.println("Max inside Thread ID "+this.getId()+" is: "+this.max);
    }
}

public class FindMax {
    static int[] values = new int[19];
    public static void main(String[] args) {
        for (int i =0; i< values.length;i++){
            values[i]=new Random().nextInt(4,20);
        }
        System.out.println(Arrays.toString(values));

        ThreadFindMax[] TFindMax = new ThreadFindMax[4];
        TFindMax[0] = new ThreadFindMax(0,values.length/4);
        TFindMax[1] = new ThreadFindMax(values.length/4, (2*values.length)/4);
        TFindMax[2] = new ThreadFindMax((2*values.length)/4, (3 * values.length) / 4);
        TFindMax[3] = new ThreadFindMax((3 * values.length) / 4, values.length);

        int max = TFindMax[0].getMax();
        for (ThreadFindMax t : TFindMax) {
            t.start();
        }
        for (ThreadFindMax t : TFindMax) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (ThreadFindMax t : TFindMax) {
            if (t.getMax() > max) {
                max = t.getMax();
            }
        }
        System.out.println("Max:"+max);
    }
}
