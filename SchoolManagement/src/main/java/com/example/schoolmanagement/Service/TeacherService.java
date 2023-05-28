package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiException.ApiException;
import com.example.schoolmanagement.ApiResponse.ApiResponse;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import java.util.List;Service



@AllArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public void add(Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            throw new ApiException(errors.getFieldError().getDefaultMessage());
        }
        teacherRepository.save(teacher);
    }

    public void update(int id, Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            throw new ApiException(errors.getFieldError().getDefaultMessage());
        }
        Teacher findTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ApiException("Teacher not found with id"));

        findTeacher.setName(teacher.getName());
        findTeacher.setEmail(teacher.getEmail());
        findTeacher.setAge(teacher.getAge());
        findTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(findTeacher);
    }

    public void delete(int id) {
        Teacher findTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ApiException("Teacher not found with id: " + id));

        teacherRepository.delete(findTeacher);
    }
}