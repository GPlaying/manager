package example.manage.bean.Complain;

import lombok.Data;

import javax.persistence.*;


@Entity(name = "complain")
@Data
public class Complain {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    private int repair_id;
    private String owners_name; // 业主名字
    private String content; //投诉内容
    private int status;
}