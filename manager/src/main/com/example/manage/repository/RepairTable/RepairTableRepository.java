package example.manage.repository.RepairTable;

import example.manage.bean.Repair.RepairTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairTableRepository extends JpaRepository<RepairTable, Integer> {
}
