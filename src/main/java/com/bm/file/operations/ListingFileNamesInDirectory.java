package com.bm.file.operations;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListingFileNamesInDirectory {

	public static void main(String[] args) {
		
		Path path = Paths.get("/Users/bhaidasmasule/Personal/");
		
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.pdf")) {
			
			for (Path entry : stream) {
				
				System.out.println(entry.getFileName());
			}
			
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
