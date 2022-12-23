package example.manage.service.Repair;

import example.manage.bean.Repair.RepairTableRecord;
import org.springframework.stereotype.Service;

@Service
public interface RepairTableRecordService {

    Integer addRepairTableRecord(RepairTableRecord repairTableRecord);// 维修记录
}
