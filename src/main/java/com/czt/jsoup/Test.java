package com.czt.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Test {
	public static void main(String arg[]) throws IOException{
//	String html = "<html><head><title>First parse</title></head>"
//			  + "<body><p>Parsed HTML into a doc.</p></body></html>";
//			Document doc = Jsoup.parse(html);
//			System.out.println(doc.text());
		
//		String html = "<div><p>Lorem ipsum.</p>";
//		Document doc = Jsoup.parseBodyFragment(html);
//		Element body = doc.body();
//		System.out.println(body.text());
		
		Document doc = Jsoup.connect("http://www.baidu.com/")
				  .data("query", "Java")
				  .userAgent("Mozilla")
				  .cookie("auth", "token")
				  .timeout(3000)
				  .get();
		String title = doc.title();
		
		System.out.println(title);
	}

}
