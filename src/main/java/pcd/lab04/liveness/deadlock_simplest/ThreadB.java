package pcd.lab04.liveness.deadlock_simplest;

public class ThreadB extends Thread {

    Resource resource;

    public ThreadB(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        while (true) {
            resource.leftRight();
        }
    }
}
