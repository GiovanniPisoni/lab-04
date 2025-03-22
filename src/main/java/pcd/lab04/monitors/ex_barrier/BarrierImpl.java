package pcd.lab04.monitors.ex_barrier;

public class BarrierImpl implements Barrier {

    private int nArrived;
    private final int nWorkers;

    public BarrierImpl(int nWorkers) {
        this.nWorkers = nWorkers;
        this.nArrived = 0;
    }

    @Override
    public synchronized void hitAndWaitAll() throws InterruptedException {
        nArrived++;
        if(nArrived == nWorkers) {
            notifyAll();
        } else {
            while (nArrived < nWorkers) {
                wait();
            }
        }
    }
}
