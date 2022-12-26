package example.manage.bean.Repair;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "repairtablerecord")
@Data
@NoArgsConstructor
public class RepairTableRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Column(name = "repairTableId")
    private int repairTableId;//报修任务的id
    @Column(name = "worker_name")
    private String worker_name;//维修工姓名
    @Column(name = "start_time")
    private String start_time;//开始时间
    @Column(name = "end_time")
    private String end_time;//结束时间

    public RepairTableRecord(Integer repairTableId,String worker_name,String start_time){
        this.start_time = start_time;
        this.worker_name = worker_name;
        this.repairTableId = repairTableId;
        this.end_time = null;
    }

}
