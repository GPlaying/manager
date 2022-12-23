package example.manage.service.User;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.User.Owners;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnersService {

    List<Owners> selectAllOwners();//查询所有业主

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
