package com.example.dhan.hackernews.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dhan.hackernews.model.News;

@Service
public interface NewsService {
	public void save(News news);
	public boolean isExist(String newsTitle);
	public List<News> getAllNews();
}
