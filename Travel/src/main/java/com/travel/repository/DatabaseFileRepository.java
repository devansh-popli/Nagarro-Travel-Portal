package com.travel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travel.model.Image;


@Repository
@Transactional
public interface DatabaseFileRepository extends JpaRepository<Image, String> {

}