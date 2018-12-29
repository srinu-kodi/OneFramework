package org.oneframework.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileUtility {

    public static File getFile(String fileName) throws IOException {
        if (FileUtility.class.getClassLoader().getResourceAsStream(fileName) != null) {
            InputStream resourceAsStream = FileUtility.class.getClassLoader().getResourceAsStream(fileName);
            File file = File.createTempFile(fileName, "");
            FileUtils.copyInputStreamToFile(resourceAsStream, file);
            return file;
        } else {
            return new File(fileName);
        }
    }

    public static void createDirectoryIfNotExist(File directory) {
        if (!directory.exists()) {
            File dir = new File("./" + directory);
            dir.mkdirs();
        }
    }

    public static void copyFileToDirectory(File file, File directory) throws IOException {
        FileUtils.copyFileToDirectory(file, directory, true);
    }
}
