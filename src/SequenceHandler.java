import java.util.Scanner;

public class SequenceHandler {
    private int currNumber = 1;
    private int n;
    private final Runnable fizz = new Runnable() {
        public void run() {
            fizz();
        }
    };
    private final Runnable buzz = new Runnable() {
        public void run() {
            buzz();
        }
    };
    private final Runnable fizzbuzz = new Runnable() {
        public void run() {
            fizzbuzz();
        }
    };
    private final Runnable number = new Runnable() {
        public void run() {
            number();
        }
    };
    private void fizz() {
        synchronized (this) {
            while(currNumber < n) {
                while (currNumber % 3 != 0 || currNumber % 15 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("fizz");
                currNumber++;
                notifyAll();
            }
        }
    }
    private void buzz() {
        synchronized (this) {
            while(currNumber < n) {
                while (currNumber % 5 != 0 || currNumber % 15 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("buzz");
                currNumber++;
                notifyAll();
            }
        }
    }
    private void fizzbuzz() {
        synchronized (this) {
            while(currNumber < n) {
                while (currNumber % 15 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("fizzbuzz");
                currNumber++;
                notifyAll();
            }
        }
    }
    private void number() {
        synchronized (this) {
            while(currNumber < n) {
                while (currNumber % 3 == 0 || currNumber % 5 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(currNumber++);
                notifyAll();
            }
        }
    }

    public void handleSequence() {
        Scanner in = new Scanner(System.in);
        System.out.print("n = ");
        this.n = Integer.parseInt(in.next());
        Thread t1 = new Thread(fizz);
        Thread t2 = new Thread(buzz);
        Thread t3 = new Thread(fizzbuzz);
        Thread t4 = new Thread(number);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
