package FrameWork.TestNG1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaStreams {
	@Test
	public void method1() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Naveen");
		names.add("Abhi");
		names.add("sahil");
		names.add("rahul");
		names.add("Abhay");
		names.add("Alex");
		
		Long count = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(count);
		
		names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
		
		names.stream().filter(s->s.length()>4).limit(3).forEach(s->System.out.println(s));
		
		names.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		
		//We can also convert Array into the list
		List<String> names1 = Arrays.asList("Anand", "sheena", "Axel", "lifer");
		
		//Concatenating two streams
		Stream.concat(names.stream(), names1.stream());
	}

}
