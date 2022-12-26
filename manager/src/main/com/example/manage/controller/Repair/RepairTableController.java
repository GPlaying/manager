package example.manage.controller.Repair;

import example.manage.bean.Repair.RepairTable;
import example.manage.service.Repair.RepairTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class RepairTableController {

    @Autowired
    private RepairTableService repairTableService;

    public Optional<RepairTable> findById(Integer id){
        return repairTableService.findById(id);
    }
//
//    public void deleteRepairTable(Integer id) {
//        repairTableService.deleteRepairTable(id);
//    }
//
    public void addRepairTable(RepairTable repairTable) {
        repairTableService.addRepairTable(repairTable);
    }
//
//    public void updateRepairTable(RepairTable repairTable) {
//        repairTableService.updateRepairTable(repairTable);
//    }

}
