package com.bm.file.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import static java.nio.file.attribute.PosixFilePermission.*;

public class FilePermissionOperations {

	public static void main(String[] args) {
		
		try {
			
			Path path = Paths.get("/Users/bhaidasmasule/Desktop/Temp/file1.txt");
			PosixFileAttributes attrs = Files.readAttributes(path, PosixFileAttributes.class);
			Set<PosixFilePermission> posixFilePermissions = attrs.permissions();
			posixFilePermissions.clear();
			
			String owner = attrs.owner().getName();
			String perms = PosixFilePermissions.toString(posixFilePermissions);
			
			System.out.format("%s %s%n", owner, perms);
			
			posixFilePermissions.add(OWNER_READ);
			posixFilePermissions.add(OWNER_WRITE);
			posixFilePermissions.add(OWNER_EXECUTE);
			posixFilePermissions.add(GROUP_READ);
			posixFilePermissions.add(GROUP_WRITE);
			posixFilePermissions.add(GROUP_EXECUTE);
			posixFilePermissions.add(OTHERS_READ);
			posixFilePermissions.add(OTHERS_WRITE);
			posixFilePermissions.add(OTHERS_EXECUTE);
			
			//Set the permissions of file
			Files.setPosixFilePermissions(path, posixFilePermissions);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
