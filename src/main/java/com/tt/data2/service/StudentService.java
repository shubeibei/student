package com.tt.data2.service;

import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface StudentService {


    void addGrade(Grade grade);

    void deleteGrade(Integer gradeId);

    List<Grade> findGrade();

    int getCount();

    Optional< Grade> findGradeById(Integer gradeId);

    List<Grade> findGradeSort(Sort sort);

    Page<Grade>  findGradePage(Pageable pageable);

    List<Student> getStuByName(String studentName);
    //根据密码查询学生信息
    List<Student> getStuByPwd(String loginPwd);
    //根据密码和学号查询学生信息
    List<Student> getStuByNoPwd(Integer studentNo, String loginPwd);
    ///根据名称进行模糊查询
    List<Student> getStuByNameLike(String studentName);
    //根据名称模糊查询，并按照学号降序查询学生信息
    List<Student> getStuByNameLikeSort(String studentName);

    List<Student> getStuByQuery();
//修改
    void updateStuByQuery(Integer studentNo, String studentName, String loginPwd);
//删除
    void deleteStuByQuery(Integer studentNo);
//查询
    List<Student> getStuByQueryNoPwd(Integer studentNo, String loginPwd);
}
