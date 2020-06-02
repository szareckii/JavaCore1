package lesson5.dz;

public class MyArrayThread {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        arrayChangeNoThread();
        arrayChangeThread();
    }

    public static void arrayChangeThread() {
        float[] arr = new float[size];

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.out.println();
        System.arraycopy(arr, h, a2, 0, h);

        Thread myThready0 = new Thread(new MyArrayThread.ArrayThread(a1));
        Thread myThready1 = new Thread(new MyArrayThread.ArrayThread(a2));

        myThready0.start();
        myThready1.start();

        try {
            myThready0.join();
            myThready1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Время работы в двух потоках (мс): " + (System.currentTimeMillis() - a));
    }

    static class ArrayThread implements Runnable{

        private final float[] arr;

        public ArrayThread(float[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            Thread current = Thread.currentThread();
            if (current.getName().equals("Thread-0")) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
            else {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + (h + i) / 5) * Math.cos(0.2f + (h + i) / 5) * Math.cos(0.4f + (h + i) / 2));
                }
            }
        }
    }

    public static void arrayChangeNoThread() {
        float[] arr = new float[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время работы в одном потоке (мс): " + (System.currentTimeMillis() - a));

        }
}
