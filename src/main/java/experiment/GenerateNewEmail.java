package experiment;

import java.util.Date;

public class GenerateNewEmail {
	public static void main(String[] args) {
		System.out.println(generateNewEmail());

	}

	public static String generateNewEmail() {
		Date date = new Date();
		String dateString = date.toString();
		String dateWithoutSpaces = dateString.replaceAll("\\s", "");
		String dateWithoutSacesAndColons = dateWithoutSpaces.replaceAll("\\:", "");
		String newEmail = dateWithoutSacesAndColons + "@gmail.com";
		return newEmail;
	}
}
