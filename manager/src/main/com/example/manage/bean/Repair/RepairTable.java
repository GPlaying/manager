package example.manage.bean.Repair;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity(name = "repairtable")
@Data
@NoArgsConstructor
public class RepairTable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    @Column(name = "owner_name")
    private String owner_name; // 报修人
    @Column(name = "worker_name")
    private String worker_name; //维修人
    @Column(name = "dispatcher_name")
    private String dispatcher_name; //调度员
    @Column(name = "fault_type")
    private int fault_type; //故障类型(故障本身的属性)
    @Column(name = "fault_content")
    private String fault_content; //故障描述(业主对故障的主观描述)
    @Column(name = "launch_route")
    private String launch_route; //微信or电话
    @Column(name = "launch_time")
    private String launch_time; //报修时间
    @Column(name = "working_time")
    private String working_time; //花费工时
    @Column(name = "repair_evaluation")
    private String repair_evaluation; //维修评价
    @Column(name = "status")
    private int status; // 报修状态，0表示未确认，1表示待调度，2表示维修中，3表示维修完成


    public RepairTable(String owner_name,String fault_content,String launch_route,String launch_time){
        //实例化一个报修表
        this.owner_name = owner_name;
        this.fault_content = fault_content;
        this.launch_route = launch_route;
        this.launch_time = launch_time;
        this.status = 0;
        this.worker_name = null;
        this.dispatcher_name = null;
    }

}