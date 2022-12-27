package example.manage.bean.User;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Entity(name = "workers")
@Data
@ToString()
public class Workers {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    private String name;
    private int type; //工种
    private int status; //0表示空闲，1表示忙碌

}