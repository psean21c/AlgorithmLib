package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/***
 * Sort: Sort the list of Government bonds in terms of years in ascending order
 */
class Sorter implements Comparator<GovernmentBond> {
	@Override
	public int compare(GovernmentBond g1, GovernmentBond g2) {
		if (g1.term == g2.term)
			return (g1.id.compareTo(g2.id) > 1 ? -1 : 1);
		else
			return (g1.term < g2.term ? -1 : 1);
	}

}
public class BondManager {

	/**
	 * Two Basic containers to hold corporate Bonds and government Bonds 
	 */
	public List<CorporateBond> listCorporate = new ArrayList<CorporateBond>();
	public List<GovernmentBond> listGovernment = new ArrayList<GovernmentBond>();
	public float maxGovernmentTerm = 0;

	/***
	 * Read the input file and save each different type of bonds to List<Bond>
	 * * 
	 * This method can handle the situation - reading different format 
	 * C1	corporate	1.3 years	3.30%      (1) when term has 'years'
	 * C1	corporate	10.3	5.30%         (2) when it has no years
	 */
	public void readInput(File file){

		try{
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				
				// 1) Read file and format data
				String line = in.nextLine();
				StringTokenizer token = new StringTokenizer(line,"\t");
				while(token.hasMoreTokens()){
					String id = token.nextToken();
					String type = token.nextToken();
		            float term = 0;
					String year = token.nextToken();
					if(year.contains("years")) {
						term =  Float.valueOf(year.substring(0, year.indexOf("years")-1));
					}
					else{
						term = Float.valueOf(year);
					}
		            String percent = token.nextToken();
		            float yield = Float.valueOf(percent.substring(0, percent.indexOf("%")));
		            //System.out.println("debug-log:" + id + " " + type + " "+ term + " " + yield);
					
		            // 2) Save each input to Bond List based on the type (corporate / government)
		            if(type.equalsIgnoreCase("corporate")){
		            	CorporateBond corportate = new CorporateBond(id,term,yield);
		            	listCorporate.add(corportate);
		            } else {
		            	GovernmentBond government = new GovernmentBond(id,term,yield);
		            	listGovernment.add(government);
		            	if(maxGovernmentTerm < term) maxGovernmentTerm = term;
		            }
				}
	            
	        }
	        in.close();			
			
		} catch (InputMismatchException e) {
	        e.printStackTrace();
		} catch (FileNotFoundException e) {
	        e.printStackTrace();
		} catch (StringIndexOutOfBoundsException e) {
	        e.printStackTrace();
		} catch (Exception e) {
	        e.printStackTrace();
	    } 

	}
	
	/***
	 * 
	 * @strategy: Have the value of 'maxGovernmentTerm' first while reading the input file.
	 * This variable will be used to detect the minimum difference in terms of years.
	 */
	public void bondBenchMark(){
		for (CorporateBond corporate : listCorporate) {
			float min = Math.abs(maxGovernmentTerm - corporate.term);
			int idx = 0;
			for(int i=0;i<listGovernment.size();i++){
				GovernmentBond gov = listGovernment.get(i);
				float diff = Math.abs(corporate.term - gov.term);
				if(min >= diff) {
					min = diff;
					idx = i;
				}
			}
			GovernmentBond bestBenchGov = listGovernment.get(idx);
			corporate.benchmark = bestBenchGov.id;
			corporate.spreadToBenchmark = corporate.yield - bestBenchGov.yield; 
		}
	}
	
	/***
	 * spreadCurve: Engine to calculate the spread to the government bond curve
	 * 
	 *                G2
	 *               /|
	 *              / |            Y      Y1
	 *             /  |            --  =  --
	 *            /   | Y          X      X1
	 *           /|Y1 | 
	 *          /_|___|            G2.yield - G1.yield       B - G1.yield 
	 *        G1 X1                -------------------  =  ------------------- 
	 *          <- X ->            G2.term - G1.term        C1.term - G1.term
	 *          
	 */
	public float spreadCurve(GovernmentBond start, GovernmentBond end, CorporateBond c){
		float B = start.yield + (end.yield - start.yield) * (c.term - start.term) / (end.term - start.term);
		float A = c.yield;
		float spreadcurve = Math.abs(A-B);
		return spreadcurve;
	}


	/***
	 * 
	 * @strategy: Sort the list of government bonds first before calculate the spread-curve.
	 * It will be easier to identify which range (of two government bonds) each corporate bond stands.
	 */
	public void bondCurve(){

		Sorter sorter = new Sorter();
		Collections.sort(listGovernment, sorter);
		
		for (CorporateBond c : listCorporate) {
			int start = 0;
			int end = 0;
			for(int i=0;i<listGovernment.size();i++){
				GovernmentBond gov = listGovernment.get(i);
				if(c.term > gov.term) start = i;
				else if(c.term < gov.term) {
					end = i;
					break;
				} else {
					start = end = i;
				}
			}
			GovernmentBond g1 = listGovernment.get(start);
			GovernmentBond g2 = listGovernment.get(end);
			
			c.spreadToCurve = spreadCurve(g1,g2,c);
			//System.out.println("debug-log:" + c.id + " " + ",start=" + g1.id + ",end=" + g2.id + "=" + c.spreadToCurve);
			
		}
	}

	/***
	 * Print Basic information for Government Bond
	 */
	public void printGovernmentBonds(){
		System.out.println("\n===========Government=============");
		for (GovernmentBond gov : listGovernment) {
			System.out.println(gov.id + " " + gov.term + " " + gov.yield);
		}
	}
	
	/***
	 * Print Basic information for Corporate Bond
	 */
	public void printCorporateBonds(){
		System.out.println("\n===========Corporate=============");
		for (CorporateBond corp : listCorporate) {
			System.out.println(corp.id + " " + corp.term + " " + corp.yield);
		}
	}

	
	/***
	 * Print Spread-To-Benchmark for Corporate Bond
	 */
	public void printSpreadBenchmark(){
		System.out.println("---------------------------------------------------------------");
		System.out.println("\t\t Report for Spread BenchMark");
		System.out.println("---------------------------------------------------------------");
		System.out.println("bond\t\t"+ "benchmark\t" + "spread_to_benchmark");
		for (CorporateBond corp : listCorporate) {
			String spreadToBenchmark = String.format("%.2f", corp.spreadToBenchmark);
			System.out.println(corp.id + "\t\t" + corp.benchmark + "\t\t" + spreadToBenchmark + "%");
		}
		System.out.println();
	}
	
	/***
	 * Print Spread-To-Curve for Corporate Bond
	 */
	public void printSpreadCurve(){
		System.out.println("---------------------------------------------------------------");
		System.out.println("\t\t Report for Spread Curve");
		System.out.println("---------------------------------------------------------------");
		System.out.println("bond\t\t" + "spread_to_curve");
		for (CorporateBond corp : listCorporate) {
			String spreadCurve = String.format("%.2f", corp.spreadToCurve);
			System.out.println(corp.id + "\t\t" + spreadCurve + "%");
		}
		System.out.println();
	}
	
}
