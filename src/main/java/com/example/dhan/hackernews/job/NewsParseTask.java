package com.example.dhan.hackernews.job;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.dhan.hackernews.model.News;
import com.example.dhan.hackernews.service.NewsService;

@Component
public class NewsParseTask {
	@Autowired
	NewsService newsService;
	
	@Scheduled(fixedDelay = 10000)
	public void parseNews() {
        String url = "https://news.ycombinator.com/";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();
            Elements newsItems = doc.select("tr.athing");
            for (Element item : newsItems) {
                Element titleElement = item.select("td.title > span.titleline > a").first();
                if (titleElement != null) {
                    String title = titleElement.text();
                    if (!newsService.isExist(title)) {
                        News news = new News();
                        news.setTitle(title);
                        newsService.save(news);
                    }
                }
            }
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
