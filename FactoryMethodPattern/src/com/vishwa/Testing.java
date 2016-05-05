package com.vishwa;

abstract class Test {
	int rate;
	abstract void getRate(int rate);
}
class Testing extends Test
{
	public void getRate(int r)
	{
		rate=r;
	}
	
}
