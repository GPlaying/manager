package example.manage.serviceImpl.Repair;

import example.manage.bean.Repair.RepairTable;
import example.manage.repository.RepairTable.RepairTableRepository;
import example.manage.service.Repair.RepairTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class RepairTableServicelmpl implements RepairTableService {

    @Autowired
    private RepairTableRepository repairTableRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addRepairTable(RepairTable repairTable) {
        RepairTable result = repairTableRepository.saveAndFlush(repairTable);//返回一个对象
        Integer id = result.getId();
        return id;
    }

    //从RepairTable数据库中检索出相应状态的报修表序列
    public List<RepairTable> selectRepairTable(Integer status) {
        List<RepairTable> list = new ArrayList<>();//查询集合
        //先读出所有报修表
        List<RepairTable> allRepairTable = repairTableRepository.findAll();
        //查找对应状态的报修表
        for(RepairTable r : allRepairTable) {
            if(r.getStatus() == status){
                list.add(r);
            }
        }
        if(list.size() == 0) {
            System.out.println("没有相应状态的报修表");
        }
        return list;
    }

    //从RepairTable数据库中检索出某个维修工的任务
    public List<RepairTable> searchRepairTable(String workerName) {
        List<RepairTable> list = new ArrayList<>();
        //先读出所有报修表
        List<RepairTable> allRepairTable = repairTableRepository.findAll();
        //查找对应维修工的任务
        for(RepairTable r : allRepairTable){
            if(workerName.equals(r.getWorker_name()))
                list.add(r);
        }
        return list;
    }

}
