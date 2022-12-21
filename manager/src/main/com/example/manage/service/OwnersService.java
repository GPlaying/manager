package example.manage.service;

import example.manage.bean.User.Owners;

import java.util.List;


public interface OwnersService {

    void insertOwners(Owners user);// 添加业主

    void deleteOwners(Integer uid);// 删除业主

    void updateOwners(Owners user);// 修改业主

    List<Owners> selectAllOwners();// 查询所有业主

    List<Owners> selectLike(String search);// 模糊查询
}
