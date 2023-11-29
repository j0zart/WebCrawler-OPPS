package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebCrawler {
    public static void main(String[] args) {
        // Starting URL for Web Crawler
        String url = "https://www.apple.com/";

        // Start crawling from level 1 with the initial URL and an empty list of visited URLs
        crawl(1, url, new ArrayList<String>());
    }

    // Recursive method to crawl web pages up to a specified depth
    private static void crawl(int level, String url, ArrayList<String> visitedUrls) {
        // Check if the current crawling level is within the specified limit (5)
        if (level <= 5) {
            // Make an HTTP request to the current URL and retrieve the HTML document
            Document doc = request(url, visitedUrls);

            // Check if the document was successfully retrieved
            if (doc != null) {
                // Extracts and processes links from the HTML document
                for (Element link : doc.select("a[href]")) {
                    // Get the absolute URL from the href attribute of the current anchor element
                    String next_link = link.absUrl("href");

                    // Check if the next URL has not been visited before
                    if (!visitedUrls.contains(next_link)) {
                        // Recursively crawl the next URL with an incremented level
                        crawl(++level, next_link, visitedUrls);
                    }
                }
            }
        }
    }

    // Method to make an HTTP request and retrieve the HTML document
    private static Document request(String url, ArrayList<String> visited) {
        try {
            // Establish a connection to the specified URL
            Connection con = Jsoup.connect(url);

            // Retrieve the HTML document from the connection
            Document doc = con.get();

            // Check if the HTTP response code indicates a successful request (status code 200)
            if (con.response().statusCode() == 200) {
                // Print the URL and title of the visited page
                System.out.println("Link: " + url);
                System.out.println("Title: " + doc.title());

                // Add the current URL to the list of visited URLs
                visited.add(url);

                // Return the HTML document
                return doc;
            }
        } catch (IOException e) {
            // Handle IOException if something goes wrong with the HTTP request
            Logger.getGlobal().log(Level.WARNING, "ERROR Something went wrong!");
        }

        // Return null to indicate an unsuccessful request
        return null;
    }
}
