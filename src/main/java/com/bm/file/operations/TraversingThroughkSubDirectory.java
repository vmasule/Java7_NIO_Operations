package com.bm.file.operations;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class TraversingThroughkSubDirectory {

	public static void main(String[] args) {
		
		Path path = Paths.get("/Users/bhaidasmasule/Personal/");
		try {
			Files.walkFileTree(path, new FinaJavaVisitor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class FinaJavaVisitor extends SimpleFileVisitor<Path> {

//	@Override
//	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//		System.out.println("In preVisitDirectory");
//		return super.preVisitDirectory(dir, attrs);
//	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		//System.out.println("In visitFile");
		if(file.toString().endsWith(".pdf")){
			System.out.println(file.getFileName());
		}
		return FileVisitResult.CONTINUE;
	}

//	@Override
//	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//		System.out.println("In visitFileFailed");
//		return super.visitFileFailed(file, exc);
//	}
//
//	@Override
//	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//		System.out.println("In postVisitDirectory");
//		return super.postVisitDirectory(dir, exc);
//	}
	
}