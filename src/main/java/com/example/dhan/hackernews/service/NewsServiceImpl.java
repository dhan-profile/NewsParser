package com.example.dhan.hackernews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dhan.hackernews.model.News;
import com.example.dhan.hackernews.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	NewsRepository repository;
	@Override
	public void save(News news) {
		repository.save(news);
	}

	@Override
	public boolean isExist(String newsTitle) {
		List<News> allNews = repository.findAll();
		for (News n: allNews) {
			if (n.getTitle().equals(newsTitle)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<News> getAllNews() {
		return repository.findAll();
	}

}
