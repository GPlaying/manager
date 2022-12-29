package example.manage.controller.Repair;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.Repair.RepairTableRecord;
import example.manage.service.Repair.RepairTableRecordService;
import example.manage.service.Repair.RepairTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class RepairTableRecordController {

    @Autowired
    private RepairTableRecordService repairTableRecordService;

    public Optional<RepairTableRecord> findById(Integer id){
        return repairTableRecordService.findById(id);
    }

    public RepairTableRecord selectById(Integer repair_id){
        return repairTableRecordService.selectById(repair_id);
    }
    //
//    public void deleteRepairTable(Integer id) {
//        repairTableService.deleteRepairTable(id);
//    }
//

//
//    public void updateRepairTable(RepairTable repairTable) {
//        repairTableService.updateRepairTable(repairTable);
//    }

}