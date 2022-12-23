package example.manage.bean.User;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Entity(name = "owners")
@Data
@ToString()
public class Owners {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    private String name;

}