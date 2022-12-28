package example.manage.controller.User;

import example.manage.bean.Complain.Complain;
import example.manage.bean.Repair.RepairTable;
import example.manage.service.Repair.RepairTableService;
import example.manage.service.Complain.ComplainService;
import example.manage.service.User.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class OwnersController {

    @Autowired
    private OwnersService ownersService;

    @Autowired
    private RepairTableService repairTableService;
    private ComplainService complainService;

    //申请报修
    public void launchRepairTable(String owner_name, String fault_content, String launch_route) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String launch_time = formatter.format(date);

        RepairTable repairTable = new RepairTable(owner_name,fault_content,launch_route,launch_time);

        Integer id = repairTableService.addRepairTable(repairTable);//此ID值以备后用

    }

    //投诉申请
    public void launchComplain(String owners_name, String content, String dispatcher_name, String worker_name, String dispatcher_explain,
                               String worker_explain, Integer state, Integer repaire_id){
//        Complain complain = new Complain(owners_name, content, dispatcher_name, worker_name, dispatcher_explain,
//                worker_explain, state, repaire_id);
//        Integer id = complainService.addComplain(complain);
        ownersService.launchComplain(owners_name, content, dispatcher_name, worker_name, dispatcher_explain, worker_explain, state, repaire_id);
    }

    //获取用户投诉
    public Complain getComplainByRepair_id(Integer repair_id){
        return ownersService.getComplainByRepair_id(repair_id);
    }


}


//    public List query(){
//        List<Owners> list = ownersService.selectAllOwners();
//        System.out.print(list);
//        return list;
//    }
