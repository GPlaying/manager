package example.manage.serviceImpl.User;

import example.manage.bean.Complain.Complain;
import example.manage.bean.User.Owners;
import example.manage.repository.RepairTable.RepairTableRepository;
import example.manage.repository.User.OwnersRepository;
import example.manage.service.Complain.ComplainService;
import example.manage.service.User.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OwnersServiceImpl implements OwnersService {
    @Autowired
    private RepairTableRepository repairTableRepository;

    @Autowired
    private ComplainService complainService;

    @Autowired
    private OwnersRepository ownersRepository;

    public List<Owners> selectAllOwners(){
        return ownersRepository.findAll();
    }

    @Override
    public int launchComplain(Integer repaire_id, String owners_name, String content, Integer state) {

        Complain newComplain = new Complain(repaire_id, owners_name, content, state);
        Integer id = complainService.addComplain(newComplain);
        return id;

    }

    @Override
    public Complain getComplainByRepair_id(Integer repaire_id) {
        List<Complain> allComplain = complainService.selectAllComplain();
        for (Complain r : allComplain){
            if(r.getRepaire_id() == repaire_id){
                return r;
            }
        }
        System.out.print("未找到repaire_id为"+repaire_id+"的投诉\n");
        return null;
    }


//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void launchRepairTable(String owner_name, String fault_content, String launch_route, String launch_time) {
//        //先创建一份报修表(待确认)
//        Unconfirmed_RepairTable unconfirmed_repairTable = new Unconfirmed_RepairTable(owner_name, fault_content, launch_route, launch_time);
//
//        //将报修表存入待确认列表中
//        unconfirmed_repairTableRepository.saveAndFlush(unconfirmed_repairTable);
//
//    }
}
