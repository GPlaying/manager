package example.manage.serviceImpl.Repair;

import example.manage.bean.Repair.RepairTableRecord;
import example.manage.repository.RepairTable.RepairTableRecordRepository;
import example.manage.service.Repair.RepairTableRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RepairTableRecordServiceImpl implements RepairTableRecordService {
    @Autowired
    private RepairTableRecordRepository repairTableRecordRepository;

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addRepairTableRecord(RepairTableRecord repairTableRecord) {
        RepairTableRecord result = repairTableRecordRepository.saveAndFlush(repairTableRecord);//返回一个对象
        Integer id = result.getId();
        return id;
    }
}
