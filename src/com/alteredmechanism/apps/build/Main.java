package com.alteredmechanism.apps.build;

public class Main {

    // TODO - Read from properties file for src dir, classes dir, java version, etc.
    public static void main(String[] args) {
        try {
            // Compile files in src directory
            String[] cmd = new String[]{"javac", "-d", "classes", "src/*.java"};
            Executor.exec(cmd);  // TODO - Throw exception

            // Jar
            String[] jar = new String[]{"jar", "-d", "classes", "src/*.java"};
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
