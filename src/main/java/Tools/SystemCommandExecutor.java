package Tools;

import java.io.File;
import java.io.IOException;

public class SystemCommandExecutor {

    static void KillBrowserInWindows(String driver)
    {
        Runtime run;
        Process process = null;
        run = Runtime.getRuntime();

        try {
            final String command = "taskkill /f /im "+ driver +" & ver > nul";
            process = run.exec(command,null);
            process.waitFor();
        } catch (final InterruptedException | IOException exception) {
            exception.printStackTrace();
            System.out.println(ConstantsAndConfig.getAnsiRed() + "Error executing command"
                    + ConstantsAndConfig.getAnsiReset());
        } finally {
            process.destroy();
        }
    }

    static void KillBrowserInLinux(String driver)
    {
        Runtime run;
        Process process = null;
        run = Runtime.getRuntime();

        try {
            final String command = "killall -KILL " + driver;
            process = run.exec(command,null);
            process.waitFor();
        } catch (final InterruptedException | IOException exception) {
            exception.printStackTrace();
            System.out.println(ConstantsAndConfig.getAnsiRed() + "Error executing command"
                    + ConstantsAndConfig.getAnsiReset());
        } finally {
            process.destroy();
        }
    }

    static void makeDriverExecutable(String driverPath)
    {
        Runtime run;
        Process process = null;
        run = Runtime.getRuntime();

        try {
            final String command = "chmod a+x " + driverPath.split("/")[driverPath.split("/").length - 1];
            process = run.exec(command,null,new File(driverPath.substring(0, driverPath.lastIndexOf("/"))));
            process.waitFor();
        } catch (final InterruptedException | IOException exception) {
            exception.printStackTrace();
            System.out.println(ConstantsAndConfig.getAnsiRed() + "Error executing command"
                    + ConstantsAndConfig.getAnsiReset());
        } finally {
            process.destroy();
        }
    }
}
