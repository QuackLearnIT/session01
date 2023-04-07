package fa.training.entity;

import fa.training.dto.DepartmentSummaryDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@SqlResultSetMapping(
        name = "DepartmentSummaryDtoMapping",
        classes = @ConstructorResult(
                targetClass = DepartmentSummaryDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "totalEmployee", type = Long.class),
                }
        )
)
@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
