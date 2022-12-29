package example.manage.service.Complain;

import example.manage.bean.Complain.Complain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComplainService {

    Integer  addComplain(Complain complain);// 添加投诉

    void deleteComplain(Integer id);// 删除投诉

    void updateComplain(Complain user);// 修改投诉

    List<Complain> selectAllComplain();// 查询所有投诉

    List<Complain> selectbyId(Integer id);//ID查询

    Complain getComplainByRepair_id(Integer repair_id);//根据repair_id查询

//    List<Complain> selectLike(String search);// 模糊查询
}
