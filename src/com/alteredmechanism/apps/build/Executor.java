package com.alteredmechanism.apps.build;

import java.io.*;

public class Executor {

    public static void copyLines(InputStream in, PrintStream out) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null)
                break;
            else
                out.println(line);
        }
        out.flush();
    }

    public static void exec(String[] cmd) throws IOException, InterruptedException, ProcessFailureException {
        exec(cmd, System.out, System.err);
    }

    public static void exec(String[] cmd, PrintStream output, PrintStream errors) throws IOException, InterruptedException, ProcessFailureException {
        Process process = Runtime.getRuntime().exec(cmd);
        copyLines(process.getInputStream(), output);
        copyLines(process.getErrorStream(), errors);
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new ProcessFailureException(cmd, exitCode);
        }
    }
}
