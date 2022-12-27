package com.example.manage;

import example.manage.ManageApplication;
import example.manage.bean.Repair.RepairTable;
import example.manage.bean.User.Owners;
import example.manage.bean.User.Workers;
import example.manage.controller.Repair.RepairTableController;
import example.manage.controller.User.DispatcherController;
import example.manage.controller.User.OwnersController;
import example.manage.controller.User.WorkersController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageApplication.class)
public class Repairtest {
    @Autowired
    OwnersController ownersController;
    @Autowired
    RepairTableController repairTableController;
    @Autowired
    DispatcherController dispatcherController;
    @Autowired
    WorkersController workersController;



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

        //申请管理:将待确认的报修表状态转待调度,填写调度员名字,设置故障类型,最后更新到数据库中
        dispatcherController.confirmRepairTable(1, "zhangsan", repairTable);
        Assert.assertEquals(repairTable.getStatus(),1);
        Assert.assertEquals(repairTable.getDispatcher_name(), "zhangsan");
        Assert.assertEquals(repairTable.getFault_type(), 1);

        //进行调度
        dispatcherController.dispatherRepairTable(repairTable);
        Assert.assertEquals(repairTable.getStatus(), 2);
        public String workername;
        workersController.searchRepairTable(workername);



    }


}