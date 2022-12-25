package example.manage.service.User;

import example.manage.bean.User.Dispatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerService {

    List<Manager> selectAllManager();//查询所有调度员(但系统只有一个调度员)


//    void saveRepairTable(Unconfirmed_RepairTable unconfirmed_repairTable);
}