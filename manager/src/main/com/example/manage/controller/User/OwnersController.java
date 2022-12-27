package example.manage.controller.User;

import example.manage.bean.Repair.RepairTable;
import example.manage.service.Repair.RepairTableService;
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

    //申请报修
    public void launchRepairTable(String owner_name, String fault_content, String launch_route) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String launch_time = formatter.format(date);

        RepairTable repairTable = new RepairTable(owner_name,fault_content,launch_route,launch_time);

        Integer id = repairTableService.addRepairTable(repairTable);//此ID值以备后用

    }

    //报修评价
    public void commentOnRepair(RepairTable repairTable, String comment){
        //更新维修表
        repairTable.setRepair_evaluation(comment);
        //存回数据库中
        Integer updateStatus = repairTableService.updateRepairTable(repairTable);
    }

//    //投诉申请
//    public void launchComplain(RepairTable repairTable){
//        ownersService.launchComplain(repairTable);
//    }


//    public List query(){
//        List<Owners> list = ownersService.selectAllOwners();
//        System.out.print(list);
//        return list;
//    }

}