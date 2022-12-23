package example.manage.service.User;

import example.manage.bean.User.Workers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkersService {

    List<Workers> selectIdleWorkers();//查询空闲维修工

//    void insertWorkers(Workers user);// 添加维修工
//
//    void deleteWorkers(Integer uid);// 删除维修工
//
//    void updateWorkers(Workers user);// 修改维修工

//    List<Workers> selectAllWorkers();// 查询所有维修工
//
//    List<Workers> selectLike(String search);// 模糊查询
}
