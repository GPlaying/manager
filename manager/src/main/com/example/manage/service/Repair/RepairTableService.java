package example.manage.service.Repair;

import example.manage.bean.Repair.RepairTable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface RepairTableService {

    Integer addRepairTable(RepairTable repairTable);// 申请报修

    RepairTable selectById(Integer id);//通过id值检索报修表

    //从RepairTable数据库中检索相应状态的报修表序列
    List<RepairTable> selectRepairTable(Integer status);

    //从RepairTable数据库中检索出相应维修工的任务
    List<RepairTable> searchRepairTable(String workerName);

//    void updateRepairTable(RepairTable repairTable);// 修改报修
//
//    void deleteRepairTable(Integer id);// 删除报修

}
