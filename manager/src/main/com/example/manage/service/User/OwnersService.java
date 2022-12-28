package example.manage.service.User;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.User.Owners;
import example.manage.bean.Complain.Complain;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface OwnersService {

    List<Owners> selectAllOwners();//查询所有业主

    void launchComplain(String owners_name, String content, String dispatcher_name, String worker_name, String dispatcher_explain,
                        String worker_explain, Integer state, Integer repaire_id);

    Complain getComplainByRepair_id(Integer repaire_id);

//    void launchRepairTable(String owner_name, String fault_content, String launch_route, String launch_time); //申请报修

//    void insertOwners(Owners owner);// 添加业主
//
//    void deleteOwners(Integer id);// 删除业主
//
//    void updateOwners(Owners owner);// 修改业主

//    List<Owners> selectAllOwners();// 查询所有业主
//
//    List<Owners> selectLike(String search);// 模糊查询
}
