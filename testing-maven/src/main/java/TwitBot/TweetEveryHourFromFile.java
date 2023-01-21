package TwitBot;

import java.io.File;
import java.util.Scanner;

import org.json.JSONObject;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TweetEveryHourFromFile {

	private int startHour = 10;
	private int stopHour = 20;
	private int currentHour = 0;
	private int currentMinute = 0;
	private String CONSUMER_KEY = "";
	private String CONSUMER_SECRET = "";
	private String ACCESS_TOKEN = "";
	private String ACCESS_TOKEN_SECRET = "";
	private String file = "Tweets.json";

	public static void main(String[] args) throws Exception {
		new TweetEveryHourFromFile();
	}

	public TweetEveryHourFromFile() throws Exception {

		// Read tweets from JSON file
		JSONObject tweets = readJsonFromFile(file);

		// Twitter object with access tokens
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET));

		// Loop through tweets from 0 to max
		for (int i = 0; i < tweets.length(); i++) {

			// Get current hour
			currentHour = Integer.parseInt(java.time.LocalTime.now().toString().split(":")[0]);
			currentMinute = Integer.parseInt(java.time.LocalTime.now().toString().split(":")[1]);

			// Wait until it's the desired hour
			while (!(startHour <= currentHour && currentHour >= stopHour)) {
				Thread.sleep(60000); // Wait a minute
				currentHour = Integer.parseInt(java.time.LocalTime.now().toString().split(":")[0]);
			}

			// Wait until it's the start of the hour
			while (currentMinute != 0) {
				Thread.sleep(60000);
				currentMinute = Integer.parseInt(java.time.LocalTime.now().toString().split(":")[1]);
			}

			// Get tweet text
			String tweet = tweets.getString(Integer.toString(i));

			// Send tweet
			twitter.updateStatus(tweet);
		}

	}

	private JSONObject readJsonFromFile(String fileName) throws Exception {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);

		String jsonString = "";
		while (scanner.hasNextLine()) {
			jsonString += scanner.nextLine();
		}
		scanner.close();

		return new JSONObject(jsonString);
	}
	
}