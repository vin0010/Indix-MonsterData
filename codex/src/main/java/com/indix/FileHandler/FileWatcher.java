package com.indix.FileHandler;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileWatcher {

	public static void watchDirectoryPath(Path path) {
		try {
			Boolean isFolder = (Boolean) Files.getAttribute(path, "basic:isDirectory", NOFOLLOW_LINKS);
			if (!isFolder) {
				throw new IllegalArgumentException(path + " is not a folder");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		FileSystem fs = path.getFileSystem();

		try (WatchService service = fs.newWatchService()) {

			path.register(service, ENTRY_CREATE);

			WatchKey key = null;
			while (true) {
				key = service.take();

				Kind<?> k = null;
				for (WatchEvent<?> watchEvent : key.pollEvents()) {
					k = watchEvent.kind();
					if (OVERFLOW == k) {
						continue; // loop
					} else if (ENTRY_CREATE == k) {
						Path newfile = ((WatchEvent<Path>) watchEvent).context();
						System.out.println("New file created: " + newfile);
						//Event getting initiated to process CSV file chunk by chunk 
						//OpenCSVParserExample csvParserExample = new OpenCSVParserExample();
						//csvParserExample.
					}
				}

				if (!key.reset()) {
					break; // loop
				}
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// Folder we are going to watch
		Path folder = Paths.get(System.getProperty("user.home"));
		watchDirectoryPath(folder);
	}
}