package com.alteredmechanism.apps.build;

public class ProcessFailureException extends Exception {
    public String[] cmd;
    public int exitCode;
    public ProcessFailureException(String[] cmd, int exitCode) {
        super("Process failed with exit code " + exitCode);
        this.cmd = cmd;
        this.exitCode = exitCode;
    }
}
