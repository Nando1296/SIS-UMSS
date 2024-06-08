package org.umss.SIS_UMSS.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.umss.SIS_UMSS.DTOs.SubjectDTO;

import java.util.List;

@Entity
public class Professor {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true, length = 36)
    private String uuid;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(length = 8)
    private int phone;
    @Email
    private String email;
    @ManyToMany
    @JoinTable(
            name = "professor_subject",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;
}
