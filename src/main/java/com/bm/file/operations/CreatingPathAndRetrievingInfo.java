package com.bm.file.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingPathAndRetrievingInfo {

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("/Users/bhaidasmasule/Personal/Ansible_Examples/ansible-examples-master.zip");
		
		System.out.println("File name is : "+ path.getFileName());
		//System.out.println("File name is : "+ path.getName(4));
		System.out.println("Number of name elements in paths : "+ path.getNameCount());
		System.out.println("Root path is : "+ path.getRoot());
		System.out.println("Parent path is : "+ path.getParent());
		System.out.println("Subpath 2 elements in deep : "+ path.subpath(0, 2));
		//There are lots of utility methods in Files class
		System.out.println("Last modified on : "+ Files.getLastModifiedTime(path));
		System.out.println("File size is : "+ Files.size(path));
		System.out.println("Check if symbolic link : "+ Files.isSymbolicLink(path));
		System.out.println("Check id directory : "+ Files.isDirectory(path));
		System.out.println("Check if readable : "+Files.isReadable(path));
		System.out.println("Files attributes : "+ Files.readAttributes(path, "*"));
	}
}
