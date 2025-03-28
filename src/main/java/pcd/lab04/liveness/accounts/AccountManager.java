package pcd.lab04.liveness.accounts;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountManager {
	
	private final Account[] accounts;
	private final Lock[] locks;
	
	public AccountManager(int nAccounts, int amount){
		accounts = new Account[nAccounts];
		locks = new ReentrantLock[nAccounts];
		for (int i = 0; i < accounts.length; i++){
			accounts[i] = new Account(amount);
			locks[i] = new ReentrantLock();
		}
	}

	public void transferMoneyWithDeadlock(int from,	int to, int amount) throws InsufficientBalanceException {
		try {			
			locks[from].lock();
			locks[to].lock();
			if (accounts[from].getBalance() < amount) {
				throw new InsufficientBalanceException();
			}
			accounts[from].debit(amount);
			accounts[to].credit(amount);			
		} finally {
			locks[from].unlock();
			locks[to].unlock();
		}
	}

	// Controlla che non si verifichi il deadlock,
	// controllando che il lock con indice minore venga acquisito prima di quello con indice maggiore
	public void transferMoneyNoDeadlock(int from, int to, int amount) throws InsufficientBalanceException {
		int min = from;
		int max = to;
		if (from > to) {
			min = to;
			max = from;
		}
		try {			
			locks[min].lock();
			locks[max].lock();
			if (accounts[from].getBalance() < amount) {
				throw new InsufficientBalanceException();
			}
			accounts[from].debit(amount);
			accounts[to].credit(amount);			
		} finally {
			locks[max].unlock();
			locks[min].unlock();
		}
	}

	
	public int getNumAccounts() {
		return accounts.length;
	}
}

