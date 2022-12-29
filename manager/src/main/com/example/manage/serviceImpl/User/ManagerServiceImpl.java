package example.manage.serviceImpl.User;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.User.Manager;
import example.manage.repository.Complain.ComplainRepository;
import example.manage.repository.RepairTable.RepairTableRepository;
import example.manage.repository.User.ManagerRepository;
import example.manage.service.User.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private RepairTableRepository repairTableRepository;
    @Autowired
    private ComplainRepository complainRepository;

    @Autowired
    private ManagerRepository managerRepository;

    public List<Manager> selectAllManager(){
        return managerRepository.findAll();
    }




    //经过调度员确认的报修表会录入系统，即存入数据库中
//    public void saveRepairTable(Unconfirmed_RepairTable unconfirmed_repairTable) {
//
//        //实例化一个报修表
//        RepairTable repairTable = new RepairTable(unconfirmed_repairTable);
//
//        //改变状态
//        repairTable.setStatus(1);
//
//        //存入数据库
//        repairTableRepository.saveAndFlush(repairTable);
//
//    }
}