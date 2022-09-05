package lesson4;

public class Temp {
    private final Object mon = new Object();
    private char currentLetter = 'A';

    public static void main(String[] args) {
        Temp temp = new Temp();
        new Thread(()->{
            temp.printA();
        }).start();
        new Thread(()->{
            temp.printB();
        }).start();
        new Thread(()->{
            temp.printC();
        }).start();
    }

    private void printA() {
        //синхронизация по монитору мон
        synchronized (mon) {
            try {
                //5 раз печатать букву
                for (int i = 0; i < 5; i++) {
                    //если сейчас не очередь печатать букву А
                    while (currentLetter != 'A') {
                        // мы ждём
                        mon.wait();
                    }
                    //если время мечатать букву А то печатаем ей
                    System.out.print("A");
                    //и ставим на очередь букву В
                    currentLetter = 'B';
                    // Включаем все потоки когда будет напечатана буква А
                    mon.notifyAll();
                    //для наглядности поставил ожидание
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notifyAll();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        mon.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
