package com.example.dhan.hackernews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dhan.hackernews.model.News;
import com.example.dhan.hackernews.service.NewsService;

@RestController
public class NewsController {
	@Autowired
	NewsService newsService;
	@GetMapping(value="/news")
	public List<News> getNews(){
		return newsService.getAllNews();
	}
//    public String getNews(Model model) {
//        model.addAttribute("newsList", newsService.getAllNews());
//        return "news";
//    }
}
