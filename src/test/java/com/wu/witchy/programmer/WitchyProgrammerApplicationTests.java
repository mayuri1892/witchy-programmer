package com.wu.witchy.programmer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wu.witchy.programmer.controller.ProgrammerController;
import com.wu.witchy.programmer.vo.Person;

@SpringBootTest
class WitchyProgrammerApplicationTests {
	
	@Autowired
	ProgrammerController programmerController;
	
	@Test
	void contextLoads() {
		assertNotNull(programmerController);
	}
	
	@Test
	void testBreakingLogicValid() {
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person(10, 12);
		Person p2 = new Person(13, 17);
		persons.add(p1);
		persons.add(p2);
		float result = programmerController.breakingWitchLogic(persons);
		assertEquals(result, 4.5f);
	}
	
	@Test
	void testBreakingLogicInValidAge() {
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person(-10, 12);
		Person p2 = new Person(-13, 17);
		persons.add(p1);
		persons.add(p2);
		float result = programmerController.breakingWitchLogic(persons);
		assertEquals(result, -1f);
	}
	
	@Test
	void testBreakingLogicInValidBornYear() {
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person(15, 12);
		Person p2 = new Person(25, 17);
		persons.add(p1);
		persons.add(p2);
		float result = programmerController.breakingWitchLogic(persons);
		assertEquals(result, -1f);
	}
	
	@Test
	void testBreakingLogicAgeZero() {
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person(12, 12);
		Person p2 = new Person(20, 18);
		persons.add(p1);
		persons.add(p2);
		float result = programmerController.breakingWitchLogic(persons);
		assertEquals(result, -1f);
	}

}
