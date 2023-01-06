package com.basejava.webapp;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {
    public static final int THREADS_NUMBER = 10000;
    private static int counter;
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " " + getState());
            }
        };
        thread0.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            }
        }).start();

        System.out.println(thread0.getState());


        /*for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    inc();
                }
            }).start();
        }*/

        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);

        for (int i = 0; i < THREADS_NUMBER; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
            });
            thread.start();
            threads.add(thread);
            //thread.join(); ожидает пока завершится один поток и переходит к следующему
        }

        //       Thread.sleep(500);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
            System.out.println(counter);

        final String lock1 = "lock1";
        final String lock2 = "lock2";
        deadlock(lock1,lock2);
        deadlock(lock2, lock1);

        //new MainConcurrency().inc();  // если метод inc() не статический
    }

    // deadlock
    private static void deadlock(String lock1, String lock2) {
        new Thread(()->{
            System.out.println("Waiting" + lock1);
            synchronized (lock1) {
                System.out.println("Holding" + lock1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Waiting" + lock2);
                synchronized (lock2) {
                    System.out.println("Holding" + lock2);
                }

            }
        }).start();
    }

    private /*static*/ synchronized void inc() {
//      synchronized (MainConcurrency.class){
//      synchronized (LOCK) {  так лучше писать, когда нужно засинхронизировать не весь метод
        counter++;
//        }
    }

}
