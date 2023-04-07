package fa.training.entity;

import fa.training.enums.EmployeeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

//@Table(name = "Employee")
@Entity //(name = "Employees")
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "INT CHECK(level >= 1 AND level <= 6)")
    private Integer level; // >= 1 and <= 6

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type")
    private EmployeeType employeeType;

    @OneToOne(mappedBy = "employee",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Account account;

    @ManyToOne
    private Department department;

    @ManyToMany(mappedBy = "members")
    private Set<Project> projects;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeSkill> employeeSkills;
}
