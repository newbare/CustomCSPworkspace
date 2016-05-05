package com.vishwa.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestReadFile {

	@SuppressWarnings("unused")
	public static void main(String args[]) {

		String fileName = "d:/uploaded/lines.txt";
		 int count=0;
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			
			//stream.forEach(System.out::println);
			
			long coundt=stream.filter(line->line.contains("line1")).count();
			System.out.println(coundt);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}