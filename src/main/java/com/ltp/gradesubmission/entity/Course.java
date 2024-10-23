package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Subject cannot be blank")
    @NonNull
    @Column(name = "subject",nullable = false)
    private String subject;

    @NotBlank(message = "Course code cannot be blank")
    @NonNull
    @Column(name = "code",nullable = false,unique = true)
    private String code;

    @NotBlank(message = "Description cannot be blank")
    @NonNull
    @Column(name = "description",nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Grade> grades;


}
