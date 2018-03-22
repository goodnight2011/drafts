package pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Accessors(chain = true)
public class DepartmentName {
    private String firstName;
    private String secondName;
}
