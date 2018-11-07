package com.epam.training;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	 static final Logger rootLogger = LogManager.getRootLogger();
	static final Logger identicalLogger = LogManager
			.getFormatterLogger("Identical");
	static final Logger sameSingerLogger = LogManager
			.getFormatterLogger("SameSinger");

	public static void main(String[] args) {

		String loggerPath = System.getProperty("user.dir")
				+ "\\resources\\log4j2.xml";
		
		System.out.println(loggerPath);
		System.setProperty("log4j.configurationFile", loggerPath);

//		rootLogger.info("Test");
//		identicalLogger.info("TESt");
//
//		sameSingerLogger.info("TESt2");
		List<File> paths = new ArrayList();
		if (args.length > 0) {
			for (String s : args) {

				if (isPath(s)) {
					paths.add(new File(s));
				}
			}
			List<MP3File> mp3Files = new ArrayList<MP3File>();
			for (File dir : paths) {
				mp3Files.addAll(MP3FileUtils.getFilesUnderDir(dir));
			}
			for (MP3File mp3 : mp3Files) {
				System.out.println(mp3.toString());
			}

		}

	}

	private static boolean isPath(String s) {
		return (s.contains("/")) || (s.contains("/")) || (s.contains(":"));
	}

	// private static List<Singer> singerConverter(List<MP3File> mp3files) {
	//
	// List<Singer> singers = new ArrayList<Singer>();
	//
	// for (MP3File mp3File : mp3files) {
	//
	// Singer singer = new Singer(mp3File.getSongPerformer());
	//
	// if (!singers.contains(singer)) {
	// List<String> songs = new ArrayList<String>();
	// songs.add(mp3File.getTitle());
	// singer.getAlbums().put(mp3File.getAlbumName(), songs);
	// }
	// else{
	// singer = singers.get
	//
	// List<String> albumNames =
	// }
	// }
	// return singers;
	// }
}