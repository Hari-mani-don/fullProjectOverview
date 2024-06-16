package com.fullProjectOverview.fullProjectOverview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullProjectOverview.fullProjectOverview.dao.FileDao;

@Repository
public interface FileRepository extends JpaRepository<FileDao, Integer> {

}
