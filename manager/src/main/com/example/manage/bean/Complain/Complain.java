package example.manage.bean.Complain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity(name = "complain")
@Data
public class Complain {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    @Column(name = "owner_name")
    private String owner_name; // 业主名字
    @Column(name = "content")
    private String content; //投诉内容


}