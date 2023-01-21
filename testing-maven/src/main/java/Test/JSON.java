package Test;

import java.io.File;
import java.util.Scanner;

import org.json.JSONObject;

public class JSON {

	public String file = "test.json";

	public static void main(String[] args) throws Exception {
		new JSON();
	}

	public JSON() throws Exception {
		JSONObject json = readJson(file);
		System.out.println(json.get("hi"));
	}

	public JSONObject readJson(String fileName) throws Exception {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File does not exists!\nExiting...");
			System.exit(1);
		}
		Scanner scanner = new Scanner(file);
		String jsonString = "";
		while (scanner.hasNextLine()) {
			jsonString += scanner.nextLine();
		}
		scanner.close();
		return new JSONObject(jsonString);
	}

}
