package com.example.manage;

import example.manage.ManageApplication;
import example.manage.bean.Repair.RepairTable;
import example.manage.bean.Repair.RepairTableRecord;
import example.manage.bean.User.Owners;
import example.manage.bean.User.Workers;
import example.manage.controller.Repair.RepairTableController;
import example.manage.controller.Repair.RepairTableRecordController;
import example.manage.controller.User.DispatcherController;
import example.manage.controller.User.OwnersController;
import example.manage.controller.User.WorkersController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.springframework.test.context.junit4.SpringRunner;
import example.manage.service.User.WorkersService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageApplication.class)
public class Repairtest {

    private WorkersService workersService;
    @Autowired
    OwnersController ownersController;
    @Autowired
    RepairTableController repairTableController;
    @Autowired
    DispatcherController dispatcherController;
    @Autowired
    WorkersController workersController;
    @Autowired
    RepairTableRecordController repairTableRecordController;



    /**
     * 测试业主报修申请是否成功
     */
    @Test
    public void repair1(){
        //获取第一位业主的信息
        List<Owners> list = ownersController.selectAllOwners();
        Owners Owner = list.get(0);

        String fault_content = "电梯故障";
        String launch_route = "微信";

        Integer repairId = ownersController.launchRepairTable(Owner.getName(),fault_content,launch_route);

        RepairTable repairTable = repairTableController.findById(repairId).get();

        //判断初始化的报修是否正确写入数据库中
        Assert.assertEquals(repairTable.getFault_content(), fault_content);
        Assert.assertEquals(repairTable.getLaunch_route(), launch_route);
        Assert.assertEquals(repairTable.getOwner_name(), Owner.getName());
        Assert.assertEquals(repairTable.getStatus(), 0);

        //申请管理:将待确认的报修表状态转为待调度,填写调度员名字,设置故障类型,最后更新到数据库中
        dispatcherController.confirmRepairTable(1, "zhangsan", repairTable);
        Assert.assertEquals(repairTable.getStatus(),1);
        Assert.assertEquals(repairTable.getDispatcher_name(), "zhangsan");
        Assert.assertEquals(repairTable.getFault_type(), 1);

        //进行调度
        dispatcherController.dispatherRepairTable(repairTable);
        Assert.assertEquals(repairTable.getStatus(), 2);
        Assert.assertEquals(repairTable.getWorker_name(), "workername");
        //获得选择的工人
        List<Workers> idleWorkers = workersService.selectIdleWorkers();


        if(idleWorkers.size() != 0){

            for(Workers w : idleWorkers){
                if(w.getName() == repairTable.getWorker_name()){
                    //将第一位工种匹配的Worker名字赋给repairTable
                    workersController.working(repairTable, w);
                    Assert.assertEquals(w.getStatus(), 1);

                }
            }
    }
        //进行维修


        RepairTableRecord repairTableRecord = repairTableRecordController.findById(repairId).get();
        Assert.assertEquals(repairTableRecord.getWorker_name(), "work1");

        //结束维修
        workersController.finished(repairTableRecord);




}}