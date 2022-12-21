package example.manage.service;

import example.manage.bean.Complain.Complain;

import java.util.List;


public interface ComplainService {

    void insertComplain(Complain complain);// 添加投诉

    void deleteComplain(Integer id);// 删除投诉

    void updateComplain(Complain user);// 修改投诉

    List<Complain> selectAllComplain();// 查询所有投诉

    List<Complain> selectLike(String search);// 模糊查询
}
