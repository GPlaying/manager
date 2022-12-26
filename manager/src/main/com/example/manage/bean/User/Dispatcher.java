package example.manage.bean.User;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity(name = "dispatcher")
@Data
@ToString
public class Dispatcher {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    @Column(name = "name")
    private String name;


}