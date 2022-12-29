package example.manage.bean.Complain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity(name = "complain")
@Data
@NoArgsConstructor
public class Complain {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    @Column(name = "owner_name")
    private String owner_name; // 业主名字
    @Column(name = "content")
    private String content; //投诉内容
    @Column(name = "dispatcher_name")
    private String dispatcher_name; //调度员名字
    @Column(name = "worker_name")
    private String worker_name; //工人名字
    @Column(name = "dispatcher_explain")
    private String dispatcher_explain; //调度员的解释
    @Column(name = "worker_explain")
    private String worker_explain; //工人的解释
    @Column(name = "state")
    private int state;//状态 0:打开状态 1:关闭状态
    @Column(name = "repaire_id")
    private int repaire_id;//维修id

//    public Complain(String owners_name, String content, String dispatcher_name, String worker_name, String dispatcher_explain,
//                    String worker_explain, Integer state, Integer repaire_id) {
//        this.owner_name = owners_name;
//        this.content = content;
//        this.dispatcher_name = dispatcher_name;
//        this.worker_name = worker_name;
//        this.dispatcher_explain = dispatcher_explain;
//        this.worker_explain = worker_explain;
//        this.state = state;
//        this.repaire_id = repaire_id;
//    }

    public Complain(Integer repaire_id, String owners_name, String content, Integer state){
        this.repaire_id = repaire_id;
        this.owner_name = owners_name;
        this.content = content;
        this.state = state;
    }


}