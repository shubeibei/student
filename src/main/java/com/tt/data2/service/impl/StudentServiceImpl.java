package com.tt.data2.service.impl;


import com.tt.data2.dao.StudentDao;
import com.tt.data2.dao.StudentDao2;
import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import com.tt.data2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
  *作者：yangshu
  *时间：2018/11/21 10:15
  *描述：学生的业务
  */

@Service("studentService")
public class StudentServiceImpl implements StudentService {
 @Autowired
@Qualifier("studentDao")
    private StudentDao studentDao;


    @Autowired
    @Qualifier("studentDao2")
    private StudentDao2 studentDao2;

    @Transactional
    public void addGrade(Grade grade) {
        studentDao.save(grade);
    }

    @Transactional
    public void deleteGrade(Integer gradeId) {
        studentDao.deleteById(gradeId);
    }

    public List<Grade> findGrade() {
        return (List<Grade>) studentDao.findAll();
    }

   @Transactional
    public int getCount() {
        return (int) studentDao.count();
    }

    public Optional<Grade>  findGradeById(Integer gradeId) {
        return studentDao.findById(gradeId );
    }


    public List<Grade> findGradeSort(Sort sort) {
        return (List<Grade>) studentDao.findAll(sort);
    }


    public Page<Grade>   findGradePage(Pageable pageable) {
       return studentDao.findAll(pageable);
    }


    //根据姓名查询学生信息
    public List<Student> getStuByName(String studentName) {
        return studentDao2.findStudentByStudentName(studentName);
    }

    //根据密码查询学生信息
    public List<Student> getStuByPwd(String loginPwd) {
        return studentDao2.findStudentByLoginPwd(loginPwd);
    }

    //根据密码和学号查询学生信息
    public List<Student> getStuByNoPwd(Integer studentNo, String loginPwd) {
        return studentDao2.findStudentByStudentNoAndLoginPwd(studentNo,loginPwd);

    }

 //根据名称进行模糊查询
    public List<Student> getStuByNameLike(String studentName) {
        return studentDao2.findStudentByStudentNameLike("%"+studentName+"%");
    }
    //根据名称模糊查询，并按照学号降序查询学生信息
    public List<Student> getStuByNameLikeSort(String studentName) {
        return studentDao2.findStudentByStudentNameLikeOrderByStudentNoDesc("%"+studentName+"%");
    }


    public List<Student> getStuByQuery() {
        return studentDao2.getStuByQuery();
    }

 //修改
 @Transactional
    public void updateStuByQuery(Integer studentNo, String studentName, String loginPwd) {
        studentDao2.updateStuByQuery(studentNo,studentName,loginPwd);
    }
//删除
@Transactional
    public void deleteStuByQuery(Integer studentNo) {
        studentDao2.deleteStuByQuery(studentNo);

    }

    public List<Student> getStuByQueryNoPwd(Integer studentNo, String loginPwd) {
        return studentDao2.getStuByQueryNoPwd(studentNo,loginPwd);
    }


}
