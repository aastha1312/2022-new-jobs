public class ThreadsDeadlock extends Thread {

    A a = new A();
    B b = new B();

    public static void main(String[] args) {
        ThreadsDeadlock me = new ThreadsDeadlock();
        me.m1();
    }

    public void m1() {
        this.start();
        a.d1(b);
    }

    public void run() {
        b.d2(a);
    }
}

class A {
    public synchronized void d1(B b) {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("trying to call method of B class");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Inside A's last method");
    }
}

class B {
    public synchronized void d2(A a) {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("trying to call method of A class");
        a.last();
    }

    public synchronized void last() {
        System.out.println("Inside B's last method");

    }
}