import java.util.Arrays;

public class MainThreads {
    static final int size = 10_000_000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] arr1 = new float[h];
    static float[] arr2 = new float[h];

    static void firstMethod() {
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Time execute first method (millis) : " + (System.currentTimeMillis() - a));
    }

    static void secondMethod() {
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });


        Thread t2 = new Thread(() -> {
            int val;
            for (int i = 0; i < h; i++) {
                val = i + h;
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + val / 5) * Math.cos(0.2f + val / 5) * Math.cos(0.4f + val / 2));
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            t1.interrupt();
            t2.interrupt();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("Time execute second method (millis) : " + (System.currentTimeMillis() - a));
    }

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }
}
