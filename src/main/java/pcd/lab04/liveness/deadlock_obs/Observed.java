package pcd.lab04.liveness.deadlock_obs;

public interface Observed {
	int getState();
	void register(Observer obj);
}

