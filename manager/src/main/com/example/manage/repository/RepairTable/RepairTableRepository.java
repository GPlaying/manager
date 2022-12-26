package example.manage.repository.RepairTable;

import example.manage.bean.Repair.RepairTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairTableRepository extends JpaRepository<RepairTable, Integer> {
}
