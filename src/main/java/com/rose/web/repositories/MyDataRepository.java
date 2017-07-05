package com.rose.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rose.web.MyData;

public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
