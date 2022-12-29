package example.manage.serviceImpl.Repair;

import example.manage.bean.Repair.RepairTable;
import example.manage.bean.User.Dispatcher;
import example.manage.bean.User.Workers;
import example.manage.repository.RepairTable.RepairTableRepository;
import example.manage.repository.User.DispatcherRepository;
import example.manage.repository.User.WorkersRepository;
import example.manage.service.Repair.RepairTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RepairTableServicelmpl implements RepairTableService {

    @Autowired
    private RepairTableRepository repairTableRepository;
    @Autowired
    private WorkersRepository workersRepository;
    @Autowired
    private DispatcherRepository dispatcherRepository;

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addRepairTable(RepairTable repairTable) {
        RepairTable result = repairTableRepository.saveAndFlush(repairTable);//返回一个对象
//        Integer id = repairTableRepository.saveAndFlush(repairTable).getId();
        Integer id = result.getId();
        return id;
    }

    //通过id值检索报修表
    public Optional<RepairTable> findById(Integer id){
        return repairTableRepository.findById(id);
    }

    //从RepairTable数据库中检索出相应状态的报修表序列
    public List<RepairTable> selectRepairTable(Integer status) {
        List<RepairTable> list = new ArrayList<>();//查询集合
        //先读出所有报修表
        List<RepairTable> allRepairTable = repairTableRepository.findAll();
        //查找对应状态的报修表
        for(RepairTable r : allRepairTable) {
            if(r.getStatus() == status){
                list.add(r);
            }
        }
        if(list.size() == 0) {
            System.out.println("没有相应状态的报修表");
        }
        return list;
    }

    //从RepairTable数据库中检索出某个维修工的任务
    public List<RepairTable> searchRepairTable(String workerName) {
        List<RepairTable> list = new ArrayList<>();
        //先读出所有报修表
        List<RepairTable> allRepairTable = repairTableRepository.findAll();
        //查找对应维修工的任务
        for(RepairTable r : allRepairTable){
            if(workerName.equals(r.getWorker_name()))
                list.add(r);
        }
        return list;
    }

    @Override
    public Integer updateRepairTable(RepairTable repairTable) {
        return repairTableRepository.saveAndFlush(repairTable).getId();
    }

    @Override
    public Workers findWorkers(int repair_id) {
        List<RepairTable> list_R = repairTableRepository.findAll();
        RepairTable res = list_R.get(repair_id-1);
        String workers_name = res.getWorker_name();

        List<Workers> list_W = workersRepository.findAll();
        for(Workers workers : list_W){
            if(workers.getName().equals(workers_name)){
                return workers;
            }
        }
        return null;
    }

    @Override
    public Dispatcher findDispatcher(int repair_id) {
        List<RepairTable> list_R = repairTableRepository.findAll();
        RepairTable res = list_R.get(repair_id-1);
        String dispather_name = res.getDispatcher_name();

        List<Dispatcher> list_D = dispatcherRepository.findAll();
        for(Dispatcher dispatcher : list_D){
            if(dispatcher.getName().equals(dispather_name)){
                return dispatcher;
            }
        }
        return null;
    }

    public Integer lastId(){
        List<RepairTable> list = repairTableRepository.findAll();
        RepairTable repairTable = list.get(list.size()-1);
        return repairTable.getId();
    }
}
