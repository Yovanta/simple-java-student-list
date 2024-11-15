package com.enigma.repository;

import com.enigma.entity.Student;

import java.util.Arrays;
import java.util.List;

public class StudentRepository {
  private final List<Student> students = Arrays.asList(
          new Student("S1", "Agus", "Dep 1", 35),
          new Student("S2", "Budi", "Dep 1", 70),
          new Student("S3", "Agung", "Dep 1", 60),
          new Student("S4", "Abdul", "Dep 1", 90),
          new Student("S5", "Bambang", "Dep 2", 30),
          new Student("S6", "Teguh", "Dep 3", 32),
          new Student("S7", "Tono", "Dep 3", 70),
          new Student("S8", "Adi", "Dep 3", 20)
  );

  public List<Student> getAllStudents() {
    return students;
  }
}
