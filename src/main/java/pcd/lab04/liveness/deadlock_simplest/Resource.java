package pcd.lab04.liveness.deadlock_simplest;

public class Resource {

    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                System.out.println("leftRight");
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                System.out.println("rightLeft");
            }
        }
    }
}
