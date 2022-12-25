package example.manage.controller.User;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.User.Dispatcher;
import example.manage.bean.User.Workers;
import example.manage.service.Repair.RepairTableService;
import example.manage.service.User.DispatcherService;
import example.manage.service.User.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DispatcherController {

    @Autowired
    private DispatcherService dispatcherService;

    @Autowired
    private RepairTableService repairTableService;

    @Autowired
    private WorkersService workersService;

    //查找调度员
    public List<Dispatcher> selectAllDispather(){
        return dispatcherService.selectAllDispather();
    }

    //申请管理:将待确认的报修表状态转为待调度,填写调度员名字,设置故障类型,最后更新到数据库中
    public void confirmRepairTable(Integer type, String dispatcher_name,RepairTable repairTable){
        repairTable.setStatus(1);
        repairTable.setFault_type(type);
        repairTable.setDispatcher_name(dispatcher_name);
        repairTableService.addRepairTable(repairTable);

    }

//    //申请管理:将待确认的报修表状态转为待调度,填写调度员名字,设置故障类型,最后更新到数据库中
//    public void confirmRepairTable(Integer type, String dispatcher_name){
//        //查找状态为待确认的报修表
//        List<RepairTable> list = repairTableService.selectRepairTable(0);
//
//        //改变状态,设置类型,并更新到数据库中
//        for(RepairTable r : list){
//            r.setStatus(1);
//            r.setFault_type(type);
//            r.setDispatcher_name(dispatcher_name);
//            repairTableService.addRepairTable(r);
//        }
//    };


    //查询待调度的报修任务
    public List<RepairTable> findDispather(){
        //检索状态为待调度的报修表
        List<RepairTable> list = repairTableService.selectRepairTable(1);
        return list;
    }

    //任务调度:将空闲且类型匹配的Worker名字赋给repairTable的Worker_name字段
    public void dispatherRepairTable(RepairTable repairTable){
        List<Workers> idleWorkers = workersService.selectIdleWorkers();

        if(idleWorkers.size() != 0){
            Integer type = repairTable.getFault_type();
            for(Workers w : idleWorkers){
                if(w.getType() == type){
                    //将第一位工种匹配的Worker名字赋给repairTable
                    repairTable.setWorker_name(w.getName());
                    repairTable.setStatus(2);
                    repairTableService.addRepairTable(repairTable); //更新
                    System.out.println("维修任务调度完成");
                }
            }
        }else{
            System.out.println("暂无空闲维修工,请稍后再试试");
        }
    }

}
