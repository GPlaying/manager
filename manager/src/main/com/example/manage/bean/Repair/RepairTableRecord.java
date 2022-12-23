package example.manage.bean.Repair;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "repairtablerecord")
@Data
@NoArgsConstructor
public class RepairTableRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    private int repairTableId;//报修任务的id
    private String worker_name;//维修工姓名
    private String start_time;//开始时间
    private String end_time;//结束时间

    public RepairTableRecord(Integer repairTableId,String worker_name,String start_time){
        this.start_time = start_time;
        this.worker_name = worker_name;
        this.repairTableId = repairTableId;
        this.end_time = null;
    }

}
