package com.alteredmechanism.apps.build;

public class ProcessFailureException extends Exception {
    public String[] cmd;
    public int exitCode;
    public ProcessFailureException(String[] cmd, int exitCode) {
        super("Process failed with exit code: " + exitCode + ": " + join(" ", cmd));
        this.cmd = cmd;
        this.exitCode = exitCode;
    }

    protected static String join(String separator, String[] items) {
        StringBuffer joined = new StringBuffer();
        for (int i = 0; i < items.length; i++) {
            joined.append(items[i]);
            joined.append(separator);
        }
        joined.setLength(joined.length() - separator.length());
        return joined.toString();
    }
}
