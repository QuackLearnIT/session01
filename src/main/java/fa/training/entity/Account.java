package fa.training.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Getter
@Setter
public class Account {
    @Id
    private String empAccount;

    @Column(nullable = false)
    private String password;

    @OneToOne(optional = false)
    @JoinColumn(name = "employee_id")
    @ToString.Exclude
    private Employee employee; // variable name + "_" + employee_pk_field_name

}
