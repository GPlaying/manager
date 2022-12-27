package example.manage.serviceImpl.Repair;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.Repair.RepairTableRecord;
import example.manage.repository.RepairTable.RepairTableRepository;
import example.manage.repository.RepairTable.RepairTableRecordRepository;
import example.manage.service.Repair.RepairTableRecordService;
import example.manage.service.Repair.RepairTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RepairTableRecordServicelmpl implements RepairTableRecordService {

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



}

