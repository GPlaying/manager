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
    private String owners_name; // 业主名字
    private String content; //投诉内容
    private String dispatcher_name; //调度员名字
    private String worker_name; //工人名字
    private String dispatcher_explain; //调度员的解释
    private String worker_explain; //工人的解释


}
