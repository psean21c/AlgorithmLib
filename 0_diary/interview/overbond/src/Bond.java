package com;

abstract class Bond {
	String id;
	float term;
	float yield;

	Bond(String id, float term, float yield) {
		this.id = id;
		this.term = term;
		this.yield = yield;
	}
}

