package example.manage.bean.User;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity(name = "workers")
@Data
@ToString
public class Workers {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private int type; //工种
    @Column(name = "status")
    private int status; //0表示空闲，1表示忙碌

}