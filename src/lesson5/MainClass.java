package lesson5;

public class MainClass {

    static class MyRunnableClass implements Runnable {
        private String nameThread;

        public MyRunnableClass(String nameThread) {
            this.nameThread = nameThread;
        }

        public String getNameThread() {
            return nameThread;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println( getNameThread() + ": " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        new Thread(new MyRunnableClass("Thread 1")).start();
        new Thread(new MyRunnableClass("Thread 2")).start();
    }
}
