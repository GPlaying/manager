package example.manage.repository.RepairTable;

import example.manage.bean.Repair.RepairTableRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairTableRecordRepository extends JpaRepository<RepairTableRecord, Integer> {
}
