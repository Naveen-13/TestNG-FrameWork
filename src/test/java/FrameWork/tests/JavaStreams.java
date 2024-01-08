package FrameWork.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {
	@Test
	public void method1() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Naveen");
		names.add("Abhi");
		names.add("sahil");
		names.add("rahul");
		names.add("Abhal");
		names.add("Alex");
		
		Long count = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(count);
		
		//Filter used to filter out the data
		names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
		//Limit function limits the output
		names.stream().filter(s->s.length()>4).limit(3).forEach(s->System.out.println(s));
		//map is used to manupulate  data
		names.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		
		//We can also convert Array into the list
		List<String> names1 = Arrays.asList("Anand", "sheena", "Axel", "lifer");
		
		//Concatenating two streams
		Stream<String> concatStream = Stream.concat(names.stream(), names1.stream());
		
		//anymatch will return the boolean
		Boolean conReult = concatStream.anyMatch(s->s.equalsIgnoreCase("naveen"));
		Assert.assertTrue(conReult);
		
		//Collect method will return the stream manipulation back to the List,set,map
		names.stream().filter(s->s.endsWith("s")).map(s->s.toUpperCase()).collect(Collectors.toList());
		
		// Problem, print the unique number from the array and sort it
		List<Integer> integerList = Arrays.asList(1, 45, 3, 3, 7, 66, 9, 66,33);
		integerList.stream().distinct().sorted().forEach(s->System.out.println(s));
		
		
		
		
		
		
		
		
	}

}
