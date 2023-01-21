import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Webscrapper {

	private static List<String> title = new ArrayList<String>();
	private static List<String> price = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		System.out.println("Scraping...");
		for (int i = 1; i <= 50; i++) {
			page(i);
		}
		System.out.println("Scraped, saving to file...");
		
		File file = new File("output.txt");
		FileWriter writer = new FileWriter(file);
		writer.write(title.toString() + "\n" + price.toString());
		writer.close();
		
		System.out.println("Saved...");
		System.out.println(title);
		System.out.println(price);
	}

	private static void page(int page) throws Exception {
		System.out.println("http://books.toscrape.com/catalogue/page-" + String.valueOf(page) + ".html");
		for (String element : title(page)) {
			title.add(element);
		}
		for (String element : title(page)) {
			title.add(element);
		}
		for (String element : price(page)) {
			title.add(element);
		}
		for (String element : price(page)) {
			price.add(element);
		}
	}

	private static List<String> title(int page) throws Exception {
		Document doc = Jsoup.connect("http://books.toscrape.com/catalogue/page-" + String.valueOf(page) + ".html").get();
		Elements elements = doc.select("h3");
		List<String> titles = new ArrayList<>();
		for (Element element : elements) {
			titles.add(element.getElementsByAttribute("title").attr("title"));
		}
		return titles;
	}

	private static List<String> price(int page) throws Exception {
		Document doc = Jsoup.connect("http://books.toscrape.com/catalogue/page-" + String.valueOf(page) + ".html").get();
		Elements elements = doc.select(".price_color");
		List<String> titles = new ArrayList<>();
		for (Element element : elements) {
			titles.add(element.getElementsByAttributeValue("class", "price_color").text());
		}
		return titles;
	}

}
