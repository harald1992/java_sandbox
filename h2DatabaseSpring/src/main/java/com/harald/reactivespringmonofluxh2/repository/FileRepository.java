package com.harald.reactivespringmonofluxh2.repository;

import com.harald.reactivespringmonofluxh2.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

    List<FileEntity> findByTitleContaining(String title); // custom method that returns all MyFileEntities that contains the title

}
