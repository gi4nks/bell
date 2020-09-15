package io.streamtune.bell.utils;


import io.quarkus.arc.config.ConfigProperties;

import java.io.File;

@ConfigProperties(prefix = "bell")
public class BellConfiguration {

    private String repositoryDirectory = "~/.bell";
    private String repositoryFile = "bell.db";
    private int lastCountDefault = 10;

    public String getRepositoryDirectory() {
        return repositoryDirectory;
    }

    public String getRepositoryFile() {
        return repositoryFile;
    }

    public int getLastCountDefault() {
        return lastCountDefault;
    }

    public void setRepositoryDirectory(String repositoryDirectory) {
        this.repositoryDirectory = repositoryDirectory;
    }

    public void setRepositoryFile(String repositoryFile) {
        this.repositoryFile = repositoryFile;
    }

    public void setLastCountDefault(int lastCountDefault) {
        this.lastCountDefault = lastCountDefault;
    }

    public String getFullRepositoryName() {
        return this.repositoryDirectory + File.separator + this.repositoryFile;
    }

    @Override
    public String toString() {
        return "bellConfiguration{" +
                "repositoryDirectory='" + repositoryDirectory + '\'' +
                ", repositoryFile='" + repositoryFile + '\'' +
                ", lastCountDefault=" + lastCountDefault +
                '}';
    }
}
