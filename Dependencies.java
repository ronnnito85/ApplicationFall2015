package wordGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Dependencies {

	public static HashMap<String, ArrayList<String>> readFile(String FileName)
			throws FileNotFoundException, IOException {

		HashMap<String, ArrayList<String>> mapp = new HashMap<String, ArrayList<String>>();

		try (BufferedReader in = new BufferedReader(new FileReader(FileName))) {

			String str;

			while ((str = in.readLine()) != null) {

				if (str.equals("{") || str.equals("}")) {
					continue;
				}
				// "projectName": "Test0000",
				// backbone": ["jQuery", "underscore"],
				// "lodash": []

				int limit = str.indexOf(":");
				int start = str.indexOf("\"") + 1;
				int end = str.indexOf("\"", start);
				String key = str.substring(start, end);

				ArrayList<String> value = new ArrayList<String>();

				if (!str.contains("]")) {
					int start2 = str.indexOf("\"", limit) + 1;
					int end2 = str.indexOf("\"", start2);
					value.add(str.substring(start2, end2));
				} else {
					int start2 = 0;
					int end2 = 0;
					while ((start2 = str.indexOf("\"", limit)) != -1) {
						end2 = str.indexOf("\"", start2 + 1);
						value.add(str.substring(start2 + 1, end2));
						limit = end2 + 1;
					}
				}
				mapp.put(key, value);
			}

		}
		return mapp;
	}

	public static void InstalleDependencies(ArrayList<String> list,
			HashMap<String, ArrayList<String>> map, ArrayList<String> save) {

		for (String dependency : list) {
			boolean dependencyInstalled = creatDependency(dependency);
			if (!dependencyInstalled && !save.contains(dependency)) {
				save.add(dependency);
				creatDirectory(dependency);
				InstalleDependencies(map.get(dependency), map, save);
				System.out.println("Installing " + dependency);
			}

		}
	}

	private static void creatDirectory(String dependency) {
		File dir = new File("src/wordGame/installed_modules/" + dependency);
		dir.mkdir();
	}

	private static boolean creatDependency(String dependency) {
		File dir = new File("src/wordGame/installed_modules/" + dependency);
		return dir.exists();
	}

	public static void main(String[] args) throws Exception {

		HashMap<String, ArrayList<String>> mapp = readFile("src/wordGame/dependencies.json");

		HashMap<String, ArrayList<String>> mapping = readFile("src/wordGame/all_packages.json");

		ArrayList<String> arrayList = mapp.get("dependencies");
		ArrayList<String> save = new ArrayList<String>();
		InstalleDependencies(arrayList, mapping, save);

	}

}
