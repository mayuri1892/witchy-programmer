package com.wu.witchy.programmer.util;

public class WitcherUtil {
	
	/**
	 * Get an array of deaths each year up to max required year
	 * 1 = 0+1 = 1
	 * 1+[1] = 1+1 = 2
	 * 1+1+[2] = 2+2 =  4
	 * 1+1+2+[3] = 3+4 = 7
	 * 1+1+2+3+[5] = NewDeaths(5) + PreviousYearDeaths(7) = CurrentYearDeaths(12)
	 * Where -> NewDeath(5) = lastYearsNewDeath(3) + lastToLastYearsNewDeath(2);
	 * 
	 * Time complexity - O(n)
	 * Space complexity - O(n)
	 * 
	 * @param lastYear: Last year up to which death number is required
	 * @return Returns Data of death for each year
	 */
	public static int[] getNumberOfDeathEachYear(int lastYear) {
		int[] yearAndDeath = new int[lastYear];
		
		int lastToLastYearsNewDeath = 0;
		int lastYearsNewDeath = 1;
		
		//Initializing first year's data
		yearAndDeath[0] = 0;
		yearAndDeath[1] = 1;

		//Iterate till last required year and calculate each year's death
		for (int i = 2; i < lastYear; i++) {
			//Calculate NewDeaths
			int newDeath = lastToLastYearsNewDeath + lastYearsNewDeath;
			yearAndDeath[i] = newDeath + yearAndDeath[i-1]; 
			
			//Update previous data for next calculations
			lastToLastYearsNewDeath = lastYearsNewDeath;
			lastYearsNewDeath = newDeath;
		}

		return yearAndDeath;
	}
}