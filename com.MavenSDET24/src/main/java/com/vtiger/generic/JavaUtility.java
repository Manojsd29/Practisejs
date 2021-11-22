package com.vtiger.generic;

import java.util.Random;

public class JavaUtility {
	/**
	 * 
	 * @return rannum
	 */
public String getRandomValue() {
	Random r=new Random();
	int rannum=r.nextInt(1000);
	return ""+rannum;
	
}
}
