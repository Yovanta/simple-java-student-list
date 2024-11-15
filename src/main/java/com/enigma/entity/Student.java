package com.enigma.entity;

public class Student {
  private String studentId;
  private String studentName;
  private String department;
  private Integer mark;

  public Student(String studentId, String studentName, String department, Integer mark) {
    this.studentId = studentId;
    this.studentName = studentName;
    this.department = department;
    this.mark = mark;
  }

  public Student() {
  }

  public String getStudentId() {
    return studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public String getDepartment() {
    return department;
  }

  public Integer getMark() {
    return mark;
  }
}
