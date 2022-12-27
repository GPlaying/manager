package example.manage.service.Repair;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.Repair.RepairTableRecord;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RepairTableRecordService {

    Integer addRepairTableRecord(RepairTableRecord repairTableRecord);// 维修记录

    Optional<RepairTableRecord> findById(Integer id);
}
