package pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Department")
@Data
@NoArgsConstructor
public class Department {

    @Id
    private Integer id;

    @NonNull
    private DepartmentName name;

    private boolean active;

}
