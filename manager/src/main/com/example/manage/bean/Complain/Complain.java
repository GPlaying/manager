package example.manage.bean.Complain;

import example.manage.bean.User.Dispatcher;
import example.manage.bean.User.Workers;
import lombok.Data;
import example.manage.*;
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
//    @ManyToOne
//    @JoinColumn(name = "dispatcher_id")
//    private Dispatcher dispatcher;//
//    @ManyToOne
//    @JoinColumn(name = "workers_id")
//    private Workers workers;
    private String dispatcher_name; //调度员名字
    private String worker_name; //工人名字
    private String dispatcher_explain; //调度员的解释
    private String worker_explain; //工人的解释
    private int state;//状态 0:打开状态 1:关闭状态
    private int repaire_id;//维修id


    public Complain(String owners_name, String content, String dispatcher_name, String worker_name, String dispatcher_explain,
                    String worker_explain, Integer state, Integer repaire_id) {
        this.owners_name = owners_name;
        this.content = content;
        this.dispatcher_name = dispatcher_name;
        this.worker_name = worker_name;
        this.dispatcher_explain = dispatcher_explain;
        this.worker_explain = worker_explain;
        this.state = state;
        this.repaire_id = repaire_id;
    }
}