package com.company;

public enum State {
	CLEAN,		//unoccupied
	DIRTY,		//occupied
	RESERVED,	//reserved
	OUT,		//out of order
	PICKUP,		//just checked out, ready to be cleaned. moved to clean after
}
