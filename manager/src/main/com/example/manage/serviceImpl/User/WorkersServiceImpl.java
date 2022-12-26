package example.manage.serviceImpl.User;

import example.manage.bean.User.Workers;
import example.manage.repository.User.WorkersRepository;
import example.manage.service.User.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class WorkersServiceImpl implements WorkersService {
    @Autowired
    private WorkersRepository workersRepository;

    //查阅空闲维修工
    public List<Workers> selectIdleWorkers(){
        List<Workers> list = new ArrayList<>();//查询集合
        //先读出所有维修工列表
        List<Workers> allWorkers = workersRepository.findAll();

        //查阅状态空闲的维修工
        for(Workers w : allWorkers){
            if (w.getStatus() == 0){
                list.add(w);
            }
        }
        return list;

    }
}
