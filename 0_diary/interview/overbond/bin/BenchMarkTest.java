package com;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BenchMarkTest {

	private BondManager manager = null;

	private void buildBonds(){
		String id = "C1";
		float term = (float) 8.3;
        float yield = (float) 5.3;
    	CorporateBond corportate = new CorporateBond(id,term,yield);
    	manager.listCorporate.add(corportate);
    	
		id = "C2";
		term = (float) 15.2;
        yield = (float) 8.3;
    	corportate = new CorporateBond(id,term,yield);
    	manager.listCorporate.add(corportate);
    	
		id = "G1";
		term = (float) 9.4;
        yield = (float) 3.7;
    	GovernmentBond government = new GovernmentBond(id,term,yield);
    	manager.listGovernment.add(government);
    	
		id = "G2";
		term = (float) 15.2;
        yield = (float) 4.8;
    	government = new GovernmentBond(id,term,yield);
    	manager.listGovernment.add(government);
   	
		id = "G2";
		term = (float) 15.2;
        yield = (float) 4.8;
    	government = new GovernmentBond(id,term,yield);
    	manager.listGovernment.add(government);
    	
    	manager.maxGovernmentTerm = term;    	
		
	}

	
	@Before
	public void instantiate() throws Exception{
		manager = new BondManager();
		buildBonds();
		
	}
	
	@Test
	public void testAllMethods() throws Exception{
		
		manager.bondBenchMark();
		manager.bondCurve();
		
		manager.printSpreadBenchmark();
		manager.printSpreadCurve();
	}
	
	@Test
	public void testBondBenchMark() throws Exception{
		manager.bondBenchMark();
	}
	
	@Test
	public void testBondCurve() throws Exception{
		manager.bondCurve();
	}
	
	@Test
	public void testSpreadCurve() throws Exception{
		GovernmentBond start = new GovernmentBond("G1",(float)9.4, (float)3.7);
		GovernmentBond end = new GovernmentBond("G2", (float)12.0, (float)4.8);
		CorporateBond c = new CorporateBond("C1", (float)10.3, (float)5.3);
		float actual = manager.spreadCurve(start,end,c);
		float expected = (float) 1.2192307;
		Assert.assertEquals(expected, actual);
	}
	
}
