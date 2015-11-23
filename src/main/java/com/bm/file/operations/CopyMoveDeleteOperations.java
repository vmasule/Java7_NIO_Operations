package com.bm.file.operations;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyMoveDeleteOperations {

	public static void main(String[] args) throws IOException {
		
		//Copy with standard copy option
		Path source = Paths.get("/Users/bhaidasmasule/Desktop/Temp/java/file1.txt");
		Path target = Paths.get("/Users/bhaidasmasule/Desktop/Temp/file1.txt");
		
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		
		if(Files.exists(target)){
			System.out.println("File is copied successfully");
		}
		
		//Delete file, there is another method delete return void
		if(Files.deleteIfExists(target)){
			System.out.println("File is deleted successfully");
		}
		
		//Move files multiple files
		Path source1 = Paths.get("/Users/bhaidasmasule/Desktop/Temp/java/");
		
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(source1, "*.txt")){
			for (Path path : stream) {
				Path target1 = Paths.get("/Users/bhaidasmasule/Desktop/Temp/"+path.getFileName());
			Files.move(path, target1, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);	
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
