package example.manage.controller.User;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.User.Owners;
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

    }}