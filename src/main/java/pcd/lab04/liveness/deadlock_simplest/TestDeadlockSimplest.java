package pcd.lab04.liveness.deadlock_simplest;

public class TestDeadlockSimplest {

    public static void main(String[] args) {
        Resource resource = new Resource();
        new ThreadA(resource).start();
        new ThreadB(resource).start();
    }
}
