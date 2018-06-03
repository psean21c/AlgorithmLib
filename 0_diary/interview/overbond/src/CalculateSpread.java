package com;

import java.io.File;

/***
 * @author Simon.Park
 * @version 1.0 (January-29, 2017)
 */

public class CalculateSpread {

	public static void main(String[] args) {
		
		if (args.length == 0) {
            System.out.println("no arguments were given.");
            return;
		}
		File file = new File(args[0]);			

		BondManager manager = new BondManager();
		manager.readInput(file);
		
		manager.printCorporateBonds();
		manager.printGovernmentBonds();
		
		manager.bondBenchMark();
		manager.bondCurve();
		
		manager.printSpreadBenchmark();
		manager.printSpreadCurve();
	}


}
