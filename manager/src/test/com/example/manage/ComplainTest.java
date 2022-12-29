package com.example.manage;

import example.manage.ManageApplication;
import example.manage.bean.Complain.Complain;
import example.manage.bean.User.Dispatcher;
import example.manage.bean.User.Workers;
import example.manage.controller.Complain.ComplainController;
import example.manage.controller.Repair.RepairTableController;
import example.manage.controller.User.DispatcherController;
import example.manage.controller.User.OwnersController;
import example.manage.controller.User.WorkersController;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.DataInput;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageApplication.class)
public class ComplainTest {

    @Autowired
    OwnersController ownersController;
    @Autowired
    DispatcherController dispatcherController;
    @Autowired
    WorkersController workersController;
    @Autowired
    ComplainController complainController;
    @Autowired
    RepairTableController repairTableController;


    @Test
    public void complain1() {
        //用户提交投诉
        String owners_name = "o_1";
        String content = "修理的不好";
        Integer state = 0;

        Integer repair_id = repairTableController.lastId();


        Integer complain_id = ownersController.launchComplain(repair_id, owners_name, content, state);

        //获取用户投诉，进行比对
        Complain complain = ownersController.getComplainByRepair_id(repair_id);

        assertEquals(complain.getRepaire_id(), repair_id, "repair_id不一致");
        assertEquals(complain.getOwner_name(), owners_name, "owners_name不一致");
        assertEquals(complain.getContent(), content, "content不一致");
        assertEquals(complain.getState(), state, "status不一致");

        //根据维修id,找到相关调度员和维修工人
        Workers workers = repairTableController.findWorkers(repair_id); //这边先只找一个
        Dispatcher dispatcher = repairTableController.findDispatcher(repair_id);

        //比对调度员和维修工人，是否正确
        assertEquals(workers.getName(), "w_1", "工人name不一致");
        assertEquals(workers.getType(), 1, "工人type不一致");
        assertEquals(workers.getStatus(), 0, "工人status不一致");
        assertEquals(dispatcher.getName(), "d", "调度员name不一致");

        // 提交情况说明
        dispatcherController.launchExplain(complain, "在调度员时出现疏忽");
        workersController.launchExplain(complain, "维修时出现疏忽");

        //获取情况说明，查看是否正确提交
        Complain complain_ = ownersController.getComplainByRepair_id(repair_id);
        assertEquals(complain_.getDispatcher_explain(), "在调度员时出现疏忽", "调度员explain不一致");
        assertEquals(complain_.getWorker_explain(), "维修时出现疏忽", "维修工explain不一致");


        //更新投诉表，关闭该投诉
        complainController.deleteComplain(complain_.getId());

        //检查投诉是否正确关闭
        Complain complain2 = ownersController.getComplainByRepair_id(repair_id);
        assertEquals(complain.getState(), 0, "投诉未正确关闭");
    }
}
