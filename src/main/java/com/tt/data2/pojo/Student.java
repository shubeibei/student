package com.tt.data2.pojo;

import javax.persistence.*;
import java.io.Serializable;
/**
  *作者：yangshu
  *时间：2018/11/21 9:13
  *描述：sTUDENT学生类  对应 学生表、
 *
  */
@Entity
@Table(name="students")
public class Student  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer studentNo;
    private   String loginPwd;
    private String  studentName;

    public Student(String loginPwd, String studentName) {
        this.loginPwd = loginPwd;
        this.studentName = studentName;
    }

    public Student() {
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
