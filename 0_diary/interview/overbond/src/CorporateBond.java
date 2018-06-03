package com;


/***
 * CorporateBond:
 * @param 
 * benchmark: A government bond code for benchmark
 * spreadToBenchmark: Calculated yield spread (between a corporate bond and its government bond benchmark)
 * spreadToCurve : Calculated spread to the government bond curve
 */
public class CorporateBond extends Bond {
	String benchmark;
	float spreadToBenchmark;
	float spreadToCurve;

	CorporateBond(String id, float term, float yield) {
		super(id, term, yield);
	}
}
