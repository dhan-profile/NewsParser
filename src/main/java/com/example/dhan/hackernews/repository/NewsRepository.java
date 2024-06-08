package com.example.dhan.hackernews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dhan.hackernews.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>{
	News findByTitle(String title);
}
