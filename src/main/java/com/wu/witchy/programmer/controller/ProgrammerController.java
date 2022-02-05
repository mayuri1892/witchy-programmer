package com.wu.witchy.programmer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.witchy.programmer.util.WitcherUtil;
import com.wu.witchy.programmer.vo.Person;

@RestController
@RequestMapping("/prgorammer")
public class ProgrammerController {

	/**
	 * To find breaking logic of Witch's killing sequence
	 * Time complexity: O(n+k)
	 * Space complexity: O(n+k)
	 * Where 'n' is number of person and 'k' is max number of years found 
	 * 
	 * @param persons: An array of each person's age and year of death
	 * @return Number of people the witch killed on year of birth of given people
	 */
	@PostMapping("/")
	public float breakingWitchLogic(@RequestBody List<Person> persons) {
		int totalPersons = persons.size();
		int max = 0;
		int[] years = new int[totalPersons];
		
		//Find max required year by differentiation of yearOfDeath and ageOfDeath
		for(int i=0;i<totalPersons;i++) {
			years[i] = persons.get(i).getYearOfDeath() - persons.get(i).getAgeOfDeath();
			//Negative or zero year not allowed, Negative age not allowed, Born year can not be zero or negative
			if(persons.get(i).getYearOfDeath() <= 0 || persons.get(i).getAgeOfDeath() < 0 || years[i] <= 0) {
				return -1;
			}
			if(years[i] > max) {
				max = years[i];
			}
		}
		
		//Get number of deaths of each year till max required year's data, O(k) & O(k)
		int[] yearsDeath = WitcherUtil.getNumberOfDeathEachYear(max+1);
		
		int totalDeath = 0;
		for(int i=0;i<years.length;i++) {
			totalDeath += yearsDeath[years[i]];
		}
		
		return (float)totalDeath/years.length;
	}
	
}
