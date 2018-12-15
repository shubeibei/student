package com.tt.data2.dao;


import com.tt.data2.pojo.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;


public interface StudentDao extends JpaRepository<Grade,Integer> {


}
