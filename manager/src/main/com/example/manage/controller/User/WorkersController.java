package example.manage.controller.User;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.Repair.RepairTableRecord;
import example.manage.bean.User.Workers;
import example.manage.service.Repair.RepairTableRecordService;
import example.manage.service.Repair.RepairTableService;
import example.manage.service.User.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class WorkersController {

    @Autowired
    private WorkersService workersService;

    @Autowired
    private RepairTableService repairTableService;

    @Autowired
    private RepairTableRecordService repairTableRecordService;

    //查询分配给自己的任务
    public List<RepairTable> searchRepairTable(String workerName){
        List<RepairTable> list = repairTableService.searchRepairTable(workerName);
        return list;
    }

    //报修处理:开始维修
    public void working(RepairTable repairTable, Workers worker){
        //此时repairTable的status为2;
        //检查工种是否匹配,若不匹配则将报修表状态改为待调度
        if(repairTable.getFault_type() != worker.getType()){
            repairTable.setStatus(1);
            System.out.println("工种不符,重新调度");
            return;
        }

        //记录开始时间
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String start_time = formatter.format(date);

        //开始维修
        worker.setStatus(1);

        //创建维修记录
        RepairTableRecord repairTableRecord = new RepairTableRecord(repairTable.getId(),worker.getName(),start_time);
        //存入数据库中
        repairTableRecordService.addRepairTableRecord(repairTableRecord);

    }

    //报修处理:结束维修
    public void finished(RepairTableRecord repairTableRecord){
        //记录结束时间
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String end_time = formatter.format(date);

        //更新维修表
        repairTableRecord.setEnd_time(end_time);
        //更新数据
        repairTableRecordService.addRepairTableRecord(repairTableRecord);
    }




//    public List query(){
//        List<Workers> list = workersService.selectAllWorkers();
//        System.out.print(list);
//        return list;
//    }


}