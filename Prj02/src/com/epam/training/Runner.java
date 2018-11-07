package com.epam.training;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	// add root logger
	static final Logger rootLogger = LogManager.getRootLogger();
	// add logger to the output of identical sings
	static final Logger identicalLogger = LogManager
			.getFormatterLogger("Identical");
	// add logger to the output of sings with same singer
	static final Logger sameSingerLogger = LogManager
			.getFormatterLogger("SameSinger");

	public static void main(String[] args) {

		// set log4j2 file location
		String loggerPath = System.getProperty("user.dir")
				+ "\\resources\\log4j2.xml";

		System.out.println(loggerPath);
		// set enviroment variable
		System.setProperty("log4j.configurationFile", loggerPath);

		rootLogger.info("Test");
		identicalLogger.info("Test");

		sameSingerLogger.info("Test");

		// getting list of files from console input
		List<File> paths = new ArrayList();
		if (args.length > 0) {
			for (String s : args) {

				if (isPath(s)) {
					paths.add(new File(s));
				}
			}

			// getting the list ofmp3 files
			List<MP3File> mp3Files = new ArrayList<MP3File>();
			for (File dir : paths) {
				mp3Files.addAll(MP3FileUtils.getFilesUnderDir(dir));
			}

			// print to html file
			printToHtml(mp3Files);

		}

	}

	// check is the input string is the path
	private static boolean isPath(String s) {
		return (s.contains("/")) || (s.contains("/")) || (s.contains(":"));
	}

	// print list of mp3 to html file
	static void printToHtml(List<MP3File> mp3Files) {
		String html = "";
		for (MP3File mp3 : mp3Files) {
			html += mp3.getTitle() + " - " + mp3.getSongPerformer()
					+ "( <a href=\"" + mp3.getPath() + "\">" + mp3.getPath()
					+ "</a>)<br/>";
		}
		try {
			File file = new File(System.getProperty("user.dir")
					+ "\\resources\\result.html");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(html);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
