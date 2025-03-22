package pcd.lab04.liveness.deadlock_simplest;

public class ThreadA extends Thread {

    Resource resource;

    public ThreadA(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        while (true) {
            resource.rightLeft();
        }
    }
}
