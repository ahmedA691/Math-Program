import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class deleteMe {
	public static void deleteMe () throws IOException {
		ProcessBuilder build = new ProcessBuilder(
				"cmd.exe", "/c" ,"cd ./lib && deleteMe.bat");
		build.redirectErrorStream(true);
		Process process = build.start();
		BufferedReader buff = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while (true) {
            line = buff.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
	}
}
