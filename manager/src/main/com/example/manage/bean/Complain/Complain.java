package example.manage.bean.Complain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Complain")
@Data
public class Complain {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String owners_name; // 业主名字
    private String content; //投诉内容


}