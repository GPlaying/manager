package example.manage.bean.User;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity(name = "owners")
@Data
@ToString
public class Owners {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    @Column(name = "name")
    private String name;

}