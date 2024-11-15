package com.enigma.service.impl;

import com.enigma.entity.Student;
import com.enigma.repository.StudentRepository;
import com.enigma.service.StudentService;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
  private final StudentRepository studentRepository;

  public StudentServiceImpl() {
    this.studentRepository = new StudentRepository();
  }

  @Override
  public List<Student> getStudents() {
    return studentRepository.getAllStudents();
  }

  @Override
  public Map<String, Double> getPassPercentages() {
    List<Student> students = studentRepository.getAllStudents();
    Map<String, Integer> departmentCount = new HashMap<>();
    Map<String, Integer> departmentPassCount = new HashMap<>();

    for (Student student : students) {
      String department = student.getDepartment();
      departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
      if (student.getMark() >= 40) {
        departmentPassCount.put(department, departmentPassCount.getOrDefault(department, 0) + 1);
      }
    }

    Map<String, Double> passPercentages = new HashMap<>();
    DecimalFormat decimalFormat = new DecimalFormat("#.00");  // Format to 2 decimal places

    for (String department : departmentCount.keySet()) {
      double passPercentage = (departmentPassCount.getOrDefault(department, 0) * 100.0) /
              departmentCount.get(department);

      String formattedPercentage = decimalFormat.format(passPercentage);
      passPercentages.put(department, Double.parseDouble(formattedPercentage));
    }

    return passPercentages;
  }
}