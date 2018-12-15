package com.tt.data2.dao;

import com.tt.data2.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao2  extends JpaRepository<Student,Integer>{
    //1.根据名称查询学生信息,getStuByName,参数studentName
    List<Student> findStudentByStudentName(String studentName);
//2.根据密码查询学生信息
    List<Student> findStudentByLoginPwd(String loginPwd);
//3.根据学号和密码
    List<Student> findStudentByStudentNoAndLoginPwd(Integer studentNo, String loginPwd);
    //4.根据姓名进行模糊查询
 //select * from student where studentName like %王%
    List<Student> findStudentByStudentNameLike(String studentName);

    //根据名称模糊查询，并按照学号降序查询学生信息
    List<Student> findStudentByStudentNameLikeOrderByStudentNoDesc(String studentName);
//13.增删改不需要事务处理，需要加注解@Modifying
    @Modifying
    @Query("select s from Student as s")
    List<Student> getStuByQuery();
//修改
@Modifying
    @Query("update Student set studentName=:studentName,loginPwd=:loginPwd where studentNo=:studentNo")
    void updateStuByQuery(@Param("studentNo") Integer studentNo,@Param("studentName") String studentName,@Param("loginPwd") String loginPwd);
//删除
@Modifying
    @Query("delete  from  Student where  studentNo=?1" )
    void deleteStuByQuery(Integer studentNo);
//查找
@Query("select s from  Student  s where  s.studentNo=?1 and s.loginPwd=?2")
    List<Student> getStuByQueryNoPwd(Integer studentNo, String loginPwd);
}
