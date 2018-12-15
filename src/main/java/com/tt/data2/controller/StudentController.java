package com.tt.data2.controller;


import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import com.tt.data2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
  *作者：yangshu
  *时间：2018/11/21 20:07
  *描述：学生的控制器，负责学生相关的增删改查
  */
@Controller
public class StudentController {
    //写一个添加Student信息的方法，名字叫studentService
    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    //添加年级信息的方法


    @RequestMapping("/addGrade")
    public String addGrade() {
        Grade grade =new Grade();
        grade.setGradeName("第四学期");
        studentService.addGrade(grade);
        return  "ok";
    }

//删除  http://localhost:8080/deleteGrade?gradeId=2
    @RequestMapping("/deleteGrade")
    public String  deleteGrade(@RequestParam Integer gradeId) {

        studentService.deleteGrade(gradeId);
        return  "ok";
    }

    @RequestMapping("/findGrade")
    @ResponseBody
    public  Object  findGrade() {
        List<Grade> list =studentService.findGrade();
        return list;
    }
    //查看，个数，返回json数据


    @RequestMapping("/getCount")
    @ResponseBody
    public Object getCount() {
        int count = studentService.getCount();
        return count;
    }
    //根据ID
    //http://localhost:8080/findGradeById?gradeId=3
    @RequestMapping("/findGradeById")
    @ResponseBody
    public Object  findGradeById(@RequestParam Integer gradeId) {

       Optional<Grade> grade= studentService.findGradeById(gradeId);
        return  grade;
    }

   //根据ID进行查询排序
    @RequestMapping("/findGradeSort")
    @ResponseBody
    public Object  findGradeSort() {
        //指定排序的条件和排序的描述，即根据什么排序，打算怎么排（升，将）
       Sort sort =new Sort(Sort.Direction.ASC,"gradeID");
        List<Grade> list = studentService.findGradeSort(sort);
        return  list;
    }
    //分页
    //http://localhost:8080/findGradePage?pageIndex=1
    @RequestMapping("/findGradePage")
    @ResponseBody
    public Object  findGradePage(@RequestParam Integer pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex-1,2);
        Page<Grade> page = studentService.findGradePage(pageable);
        System.out.println("查询的总页数"+page.getTotalPages());
        System.out.println("查询的总条数"+page.getTotalElements());
        System.out.println("当前是第几页"+(page.getNumber()+1));
        List<Grade> list = page.getContent();
        return  list;
    }

     //根据名称查询学生信息,getStuByName,参数studentName


  @RequestMapping("/getStuByName")
  @ResponseBody
    public Object getStuByName(@RequestParam String studentName) {
        List<Student> list = studentService.getStuByName(studentName);
        return list;
    }


    //根据密码查询学生信息,getStuByName,参数studentName

    //http://localhost:8080/getStuByPwd?
    @RequestMapping("/getStuByPwd")
    @ResponseBody
    public Object getStuByPwd(@RequestParam String loginPwd) {
        List<Student> list = studentService.getStuByPwd(loginPwd);
        return list;
    }

    //根据密码和学号查询学生信息,getStuByName,参数studentName????
    @RequestMapping("/getStuByNoPwd")
    @ResponseBody
    public Object getStuByNoPwd(@RequestParam Integer studentNo,@RequestParam String loginPwd) {
        List<Student> list = studentService.getStuByNoPwd(studentNo,loginPwd);
        return list;
    }

    //根据名称进行模糊查询
    @RequestMapping("/getStuByNameLike")
    @ResponseBody
    public Object getStuByNameLike(@RequestParam String studentName) {
        List<Student> list = studentService.getStuByNameLike(studentName);
        return list;
    }

    //根据名称模糊查询，并按照学号降序查询学生信息
    @RequestMapping("/getStuByNameLikeSort")
    @ResponseBody
    public Object getStuByNameLikeSort(@RequestParam String studentName) {
        List<Student> list = studentService.getStuByNameLikeSort(studentName);
        return list;

    }
  //13.使用JpaRepository 的jQuery注解方式实现查询所有信息
    //http://localhost:8080/getStuByQuery

    @RequestMapping("getStuByQuery")
    @ResponseBody
    public List<Student> getStuByQuery() {
        List<Student> list = studentService.getStuByQuery();
        return  list;
    }
    //14.修改
    @RequestMapping("updateStuByQuery")
    public String updateStuByQuery() {
        Integer studentNo =1;
        String studentName="王一";
        String loginPwd ="123";
       studentService.updateStuByQuery(studentNo,studentName,loginPwd);
        return  "ok";
    }
//15,实现删除
@RequestMapping("deleteStuByQuery")
public String deleteStuByQuery(@RequestParam Integer studentNo) {
    studentService.deleteStuByQuery(studentNo);
    return  "ok";
     }
     //16、根据学号和密码查询

    @RequestMapping("/getStuByQueryNoPwd")
    @ResponseBody
    public Object getStuByQueryNoPwd(@RequestParam Integer studentNo,@RequestParam String loginPwd) {
        List<Student> list = studentService.getStuByQueryNoPwd(studentNo,loginPwd);
        return list;
    }
  }
