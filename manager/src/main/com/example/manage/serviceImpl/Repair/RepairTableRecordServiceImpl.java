package example.manage.serviceImpl.Repair;

import example.manage.bean.Repair.RepairTableRecord;
import example.manage.repository.RepairTable.RepairTableRecordRepository;
import example.manage.service.Repair.RepairTableRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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

    public Optional<RepairTableRecord> findById (Integer id){
        return repairTableRecordRepository.findById(id);
    }

    public RepairTableRecord selectById (Integer repair_id){
        List<RepairTableRecord> list = repairTableRecordRepository.findAll();
        for(RepairTableRecord repairTableRecord : list){
            if(repairTableRecord.getRepairTableId() == repair_id)
                return repairTableRecord;
        }
        return null;
    }
}
