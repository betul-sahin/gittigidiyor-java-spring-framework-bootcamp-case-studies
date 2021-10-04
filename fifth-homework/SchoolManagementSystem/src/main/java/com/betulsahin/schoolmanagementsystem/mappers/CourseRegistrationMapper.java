package com.betulsahin.schoolmanagementsystem.mappers;

import com.betulsahin.schoolmanagementsystem.dtos.CourseRegistrationDto;
import com.betulsahin.schoolmanagementsystem.models.CourseRegistration;
import com.betulsahin.schoolmanagementsystem.repositories.CourseRepository;
import com.betulsahin.schoolmanagementsystem.repositories.StudentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CourseRegistrationMapper {
    @Autowired
    protected StudentRepository studentRepositorye;
    @Autowired
    protected CourseRepository courseRepository;

    @Mapping(target = "student", expression = "java(studentRepositorye.findById(courseRegistrationDto.getStudentId()).get())")
    @Mapping(target = "course", expression = "java(courseRepository.findById(courseRegistrationDto.getCourseId()).get())")
    public abstract CourseRegistration map(CourseRegistrationDto courseRegistrationDto);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "courseId", source = "course.id")
    public abstract CourseRegistrationDto mapToDto(CourseRegistration courseRegistration);
}
