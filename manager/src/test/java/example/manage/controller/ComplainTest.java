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
        //用户提交投诉 dispatcher_explain和worker_explain置null, state为0打开状态, 假设投诉repair_id为1
        ownersController.launchComplain("owners1", "content", "dispatcher1", "worker1", null, null, 0, 1);

        //获取用户投诉，进行比对
        Complain complain = ownersController.getComplainByRepair_id(1);

        assertEquals(complain.getRepair_id(), 1, "repair_id不一致");
        assertEquals(complain.getOwners_name(), "owners1", "owners_name不一致");
        assertEquals(complain.getContent(), "content", "content不一致");
        assertEquals(complain.getStatus(), 0, "status不一致");

        //根据维修id,找到相关调度员和维修工人
//        Workers workers = repairTableController.findWorkers(repair_id); //这边先只找一个
//        Dispatcher dispatcher = repairTableController.findDispatcher(repair_id);

        //比对调度员和维修工人，是否正确
//        assertEquals(workers.getName(), "worker_name", "工人name不一致");
//        assertEquals(workers.getType(), 0, "工人type不一致");
//        assertEquals(workers.getStatus(), 0, "工人status不一致");
//        assertEquals(dispatcher.getName(), "dispatcher_name", "调度员name不一致");
        assertEquals(complain.getDispatcher_name(), "dispatcher1", "调度员name不一致");
        assertEquals(complain.getWorker_name(), "worker1", "工人name不一致");

        // 提交情况说明 输入参数complain_id，以及情况说明content
        dispatcherController.launchExplain(complain.getId(), "dispatcher_explain_content");
        workersController.launchExplain(complain.getId(), "worker_explain_content");

        //获取情况说明，查看是否正确提交
        assertEquals(complain.getDispatcher_explain(), "dispatcher_explain_content", "调度员情况说明不一致");
        assertEquals(complain.getWorker_explain(), "worker_explain_content", "工人情况说明不一致");

        //更新投诉表，关闭该投诉，状态置1
        complainController.deleteComplain(complain.getId());

        //检查投诉是否正确关闭
        assertEquals(complain.getStatus(), 1, "投诉未正确关闭");
    }
}
