package example.manage.controller.User;

import example.manage.bean.Complain.Complain;
import example.manage.bean.Repair.RepairTable;
import example.manage.bean.User.Owners;
import example.manage.service.Complain.ComplainService;
import example.manage.service.Repair.RepairTableService;
import example.manage.service.User.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class OwnersController {

    @Autowired
    private OwnersService ownersService;

    @Autowired
    private RepairTableService repairTableService;
    @Autowired
    private ComplainService complainService;


    //查找业主
    public List<Owners> selectAllOwners(){
        return ownersService.selectAllOwners();
    }

    //申请报修
    public Integer launchRepairTable(String owner_name, String fault_content, String launch_route) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String launch_time = formatter.format(date);

        RepairTable repairTable = new RepairTable(owner_name,fault_content,launch_route,launch_time);

        Integer id = repairTableService.addRepairTable(repairTable);

        return id;

    };

    //投诉申请
    public int launchComplain(Integer repair_id, String owners_name, String content,Integer state ){
        return ownersService.launchComplain(repair_id, owners_name, content, state);
    }

    //获取用户投诉
    public Complain getComplainByRepair_id(Integer repair_id){
        return complainService.getComplainByRepair_id(repair_id);
    }

    //报修评价
    public void commentOnRepair(RepairTable repairTable, String comment){
        //更新维修表
        repairTable.setRepair_evaluation(comment);
        //存回数据库中
        Integer updateStatus = repairTableService.updateRepairTable(repairTable);
    }


//    public List query(){
//        List<Owners> list = ownersService.selectAllOwners();
//        System.out.print(list);
//        return list;
//    }

}