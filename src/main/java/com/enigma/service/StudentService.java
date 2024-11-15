package com.enigma.service;

import com.enigma.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
  List<Student> getStudents();
  Map<String, Double> getPassPercentages();
}