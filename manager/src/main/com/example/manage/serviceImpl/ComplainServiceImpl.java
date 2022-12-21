package example.manage.serviceImpl;

import example.manage.bean.Complain.Complain;
import example.manage.repository.ComplainRepository;
import example.manage.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ComplainServiceImpl implements ComplainService {

    @Autowired
    private ComplainRepository complainRepository;

    @Override
    public void insertComplain(Complain user) {
        complainRepository.save(user);
    }

    @Override
    public void deleteComplain(Integer uid) {
        complainRepository.deleteById(uid);
    }

    @Override
    public void updateComplain(Complain user) {
        complainRepository.saveAndFlush(user);
    }

    @Override
    public List<Complain> selectAllComplain() {
        return complainRepository.findAll();
    }

    /**
     * 查询优先级：
     * 1.先查询是否为整型，为整型则通过ID主键查询，返回结果，不为整型则模糊查询其他字段
     * 2.模糊查询字段，忽略密码的模糊查询，对用户名和昵称进行模糊查询，返回结果
     * @param search 查询字段
     * @return 查询列表集合
     */
    @Override
    public List<Complain> selectLike(String search) {
        List<Complain> list = new ArrayList<>();// 查询列表集合
        Complain complain = new Complain();
//        complain.setComplainname(search);
//        complain.setNickname(search);
        try {
            Integer uid = Integer.parseInt(search);
            Optional<Complain> optional = complainRepository.findById(uid);
            if (!optional.isPresent()) {
                list = selectVague(complain);
            } else {
                list.add(optional.get());
            }
        }catch (NumberFormatException e) {
            // 查询字段不为整型数据，捕获异常
            list = selectVague(complain);
        }

        return list;
    }

    /**
     * 模糊查询
     * @param complain
     * @return
     */
    private List<Complain> selectVague(Complain complain) {
        List<Complain> list = null;
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("nickname", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnoreCase("uid")
                .withIgnoreCase("password");
        Example<Complain> example = Example.of(complain, matcher);
        list = complainRepository.findAll(example);
        return list;
    }
}
