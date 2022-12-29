package example.manage.service.Repair;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.User.Dispatcher;
import example.manage.bean.User.Workers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RepairTableService {

    Integer addRepairTable(RepairTable repairTable);// 申请报修

    Optional<RepairTable> findById(Integer id);//通过id值检索报修表

    //从RepairTable数据库中检索相应状态的报修表序列
    List<RepairTable> selectRepairTable(Integer status);

    //从RepairTable数据库中检索出相应维修工的任务
    List<RepairTable> searchRepairTable(String workerName);

    Integer updateRepairTable(RepairTable repairTable);// 更新报修

    Workers findWorkers(int repair_id);

    Dispatcher findDispatcher(int repair_id);

    Integer lastId();

//    void updateRepairTable(RepairTable repairTable);// 修改报修
//
//    void deleteRepairTable(Integer id);// 删除报修

}
