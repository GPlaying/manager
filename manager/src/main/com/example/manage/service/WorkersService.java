package example.manage.service;

import example.manage.bean.User.Workers;

import java.util.List;


public interface WorkersService {

    void insertWorkers(Workers user);// 添加业主

    void deleteWorkers(Integer uid);// 删除业主

    void updateWorkers(Workers user);// 修改业主

    List<Workers> selectAllWorkers();// 查询所有业主

    List<Workers> selectLike(String search);// 模糊查询
}
