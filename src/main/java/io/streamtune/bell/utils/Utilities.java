package io.streamtune.bell.utils;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.UUID;

public final class Utilities {
    final static int SHORT_ID_LENGTH = 8;

    public static String newUUID() {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }

    public static String currentDirectoryUsingSystemProperties() {
        return System.getProperty("user.dir");
    }

    public static String currentDirectoryUsingPaths() {
        return Paths.get("")
                .toAbsolutePath()
                .toString();
    }

    public static String currentDirectoryUsingFileSystems() {
        return FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
    }

    public static String currentDirectoryUsingFile() {
        return new File("").getAbsolutePath();
    }

    public static String getOperatingSystem() {
        String os = System.getProperty("os.name");
        System.out.println("Using System Property: " + os);
        return os;
    }

    public static String getOperatingSystemSystemUtils() {
        String os = SystemUtils.OS_NAME;
        System.out.println("Using SystemUtils: " + os);
        return os;
    }

    public static boolean isWindows() {
        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");

        return isWindows;
    }

}
