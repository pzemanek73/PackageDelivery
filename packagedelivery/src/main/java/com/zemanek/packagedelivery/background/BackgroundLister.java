package com.zemanek.packagedelivery.background;

import com.zemanek.packagedelivery.storage.PackageStorage;
import com.zemanek.packagedelivery.util.StopListener;

/**
 * Class for listing of the items in the background 
 * 
 * @author Petr Zemanek
 *
 */
public class BackgroundLister implements StopListener {

	private Thread t;
	private int DELAY = 60000;
	private int CHECK_SLICE = 250;
	private PackageStorage store;
	private boolean run = true;

	public BackgroundLister(PackageStorage store) {
		this.store = store;
		init();
	}
	
	private void init() {
		// Background thread
		t = new Thread(() -> {
			while (run) {
				try {
					for (int i = 0; i <= DELAY && run; i += CHECK_SLICE) {
						Thread.sleep(CHECK_SLICE);
					}
				} catch (Exception e) {				
				}
				if (run) {
					System.out.println("Listing sums of package weights by ZIP:");

					store.listByWeightSorted().forEach(System.out::println);
				}
			}
			System.out.println("Bckg list stop");
		});
	}
	
	public void start() {
		t.start();
	}
	
	@Override
	public void stopRequested() {
		this.run = false;
	}
}
