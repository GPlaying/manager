package example.manage.serviceImpl.User;

import example.manage.bean.Complain.Complain;
import example.manage.bean.User.Owners;
import example.manage.repository.RepairTable.RepairTableRepository;
import example.manage.repository.User.OwnersRepository;
import example.manage.service.Complain.ComplainService;
import example.manage.service.User.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OwnersServiceImpl implements OwnersService {
    @Autowired
    private RepairTableRepository repairTableRepository;

    @Autowired
    private OwnersRepository ownersRepository;
    private ComplainService complainService;

    public List<Owners> selectAllOwners(){
        return ownersRepository.findAll();
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


    @Override
    public void launchComplain(String owners_name, String content, String dispatcher_name, String worker_name, String dispatcher_explain,
                               String worker_explain, Integer state, Integer repaire_id) {

        Complain newComplain = new Complain(owners_name, content, dispatcher_name, worker_name, dispatcher_explain,
                worker_explain, state, repaire_id);
        Integer id = complainService.addComplain(newComplain);

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
}
