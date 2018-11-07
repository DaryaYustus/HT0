package com.epam.training;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MP3FileUtils {

	private static String MP3_EXTENSION = "mp3";

	static List getFilesUnderDir(File dir) {
		File[] listFiles = dir.listFiles();
		List<MP3File> mp3Files = new ArrayList<MP3File>();
		for (File f : listFiles) {
			if (f.isDirectory()) {
				mp3Files.addAll(getFilesUnderDir(f));
			} else {
				if (checkFileForExtentions(f)) {
					mp3Files.add(mp3FileConverter(f));
				}
			}
		}
		return mp3Files;
	}

	// Проверяем расширение файла на соответствие расширения вайла переданого из
	// консоли
	static boolean checkFileForExtentions(File f) {
		int i = f.getName().lastIndexOf('.');
		if (i >= 0) {
			String ext = f.getName().substring(i + 1);

			if (MP3_EXTENSION.equalsIgnoreCase(ext)) {
				return true;
			}
		}
		return false;
	}

	private static MP3File mp3FileConverter(File file) {
		MP3File mp3file = new MP3File();
		try {

			InputStream input = new FileInputStream(file);
			ContentHandler handler = new DefaultHandler();
			Metadata metadata = new Metadata();
			Parser parser = new Mp3Parser();
			ParseContext parseCtx = new ParseContext();
			parser.parse(input, handler, metadata, parseCtx);
			input.close();
			mp3file.setAlbumName(metadata.get("xmpDM:album"));
			mp3file.setPath(file.getAbsolutePath());
			mp3file.setSongPerformer(metadata.get("xmpDM:artist"));
			mp3file.setTitle(metadata.get("title"));
			String duration = metadata.get("xmpDM:duration");
			if (duration != null) {
				mp3file.setSongDuration(Double.parseDouble(duration));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		}

		return mp3file;

	}
}
