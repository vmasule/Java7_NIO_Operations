package com.bm.file.operations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReadingAndWritingData {


	public static void main(String[] args) {

		Path path = Paths.get("/Users/bhaidasmasule/Desktop/Temp/file2.txt");

		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

			// Reading from file
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			// Other way of reading from file
			List<String> lines = Files.readAllLines(path);
			for (String strline : lines) {
				System.out.println(strline);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		//There are lot of Standard open options to explore
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);) {

			// Writing to file
			writer.write("Hello from NIO!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
