package example.manage.controller.User;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.Complain.Complain;
import example.manage.bean.User.Workers;
import example.manage.bean.User.Dispatcher;
import example.manage.bean.User.Manager;
import example.manage.service.Repair.RepairTableService;
import example.manage.service.Complain.ComplainService;
import example.manage.service.User.DispatcherService;
import example.manage.service.User.WorkersService;
import example.manage.service.User.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private RepairTableService repairTableService;

    @Autowired
    private ComplainService complainService;

    @Autowired
    private DispatcherService dispatcherService;

    @Autowired
    private WorkersService workersService;

    //查询待完成的投诉
    public List<Complain> findComplain(){
        //检索状态为待完成的投诉表
        List<Complain> res = null;
        List<Complain> list = complainService.selectAllComplain();
        for(Complain complain : list){
            if(complain.getState() == 0)
                res.add(complain);
        }
        return res;
    }

    //添加worker_explain
    public void addworker_explain(String worker_expl,Complain complain){
        complain.setWorker_explain(worker_expl);
        complainService.updateComplain(complain);//更新表中的这个complain
    }

    //添加dispatcher_explain
    public void adddispatcher_explain(String dispatcher_expl,Complain complain){
        complain.setDispatcher_explain(dispatcher_expl);
        complainService.updateComplain(complain);//更新表中的这个complain
    }

    //添加worker_explain和dispatcher_explain
    public void addexplain(String dispatcher_expl,String worker_expl,Complain complain){
        complain.setDispatcher_explain(dispatcher_expl);
        complain.setWorker_explain(worker_expl);
        complainService.updateComplain(complain);//更新表中的这个complain
    }

    //查看调度员解释和工人解释是否已经填写，若已经填写，将待处理的投诉状态转为处理完毕,最后更新到数据库中
    public void finishComplain(Complain complain){
        String dispatcher_expl, worker_expl_expl;
        dispatcher_expl = complain.getDispatcher_explain();
        String worker_expl = complain.getWorker_explain();
        if(!dispatcher_expl.isEmpty() && !worker_expl.isEmpty()){
            complain.setState(0);
            System.out.println("投诉处理完成");}
        complainService.updateComplain(complain);//更新表中的这个complain

    }

//    //finishComplain的重载，参数为complain_id
//    public void finishComplain(int complain_id){
//        List<Complain> all_complains = complainService.selectAllComplain();
////        String dispatcher_expl;
////        String worker_expl_expl;
//
//        for(Complain i : all_complains){
//            if(i.getId() == complain_id) {
//                String dispatcher_expl = i.getDispatcher_explain();
//                String worker_expl = i.getWorker_explain();
//                if (!dispatcher_expl.isEmpty() && !worker_expl.isEmpty()) {
//                    i.setState(0);
//                    System.out.println("投诉处理完成");
//                }
//            }
//        }
//        complainService.updateComplain(complain);//更新表中的这个complain
//
//    }

}