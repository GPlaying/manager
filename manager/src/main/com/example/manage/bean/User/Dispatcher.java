package example.manage.bean.User;

import lombok.Data;

import javax.persistence.*;


@Entity(name = "dispatcher")
@Data
public class Dispatcher {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    private String name;


}