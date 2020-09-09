package io.streamtune.bell.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamGobbler extends Thread {
    InputStream is;
    String type;
    StringBuilder stringBuilder;

    public StreamGobbler(InputStream is, String type) {
        this.is = is;
        this.type = type;
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null)
                stringBuilder.append(line + "\n");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String getContent() {
        return this.stringBuilder.toString();
    }
}