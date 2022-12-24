package example.manage.controller;

import example.manage.bean.Complain.Complain;
import example.manage.bean.User.Dispatcher;
import example.manage.bean.User.Workers;
import example.manage.controller.Complain.ComplainController;
import example.manage.controller.Repair.RepairTableController;
import example.manage.controller.User.DispatcherController;
import example.manage.controller.User.OwnersController;
import example.manage.controller.User.WorkersController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.DataInput;

public class ComplainTest {

    OwnersController ownersController = new OwnersController();
    DispatcherController dispatcherController = new DispatcherController();
    WorkersController workersController = new WorkersController();
    ComplainController complainController = new ComplainController();
    RepairTableController repairTableController = new RepairTableController();


    @Test
    void complain1() {
        //用户提交投诉 (投诉表需新增字段repair_id以及status)
        ownersController.launchComplain(repair_id, owners_name, content, status);

        //获取用户投诉，进行比对
        Complain complain = ownersController.getComplain(repair_id);

        assertEquals(complain.getRepair_id(), repair_id, "repair_id不一致");
        assertEquals(complain.getOwners_name(), owners_name, "owners_name不一致");
        assertEquals(complain.getContent(), content, "content不一致");
        assertEquals(complain.getStatus(), status, "status不一致");

        //根据维修id,找到相关调度员和维修工人
        Workers workers = repairTableController.findWorkers(repair_id); //这边先只找一个
        Dispatcher dispatcher = repairTableController.findDispatcher(repair_id);

        //比对调度员和维修工人，是否正确
        assertEquals(workers.getName(), "name", "工人name不一致");
        assertEquals(workers.getType(), 0, "工人type不一致");
        assertEquals(workers.getStatus(), 0, "工人status不一致");
        assertEquals(dispatcher.getName(), "name", "调度员name不一致");

        // 提交情况说明
        dispatcherController.launchExplain();
        workersController.launchExplain();

        //获取情况说明，查看是否正确提交

        情况说明写在哪张表里？

        //更新投诉表，关闭该投诉
        complainController.deleteComplain(complain_id);

        //检查投诉是否正确关闭
        Complain complain2 = ownersController.getComplain(repair_id);
        assertEquals(complain.getStatus(), 0, "投诉未正确关闭");
    }
}
