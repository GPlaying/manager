package example.manage.serviceImpl.Complain;

import example.manage.bean.Complain.Complain;
import example.manage.repository.Complain.ComplainRepository;
import example.manage.service.Complain.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ComplainServiceImpl implements ComplainService {

    @Autowired
    private ComplainRepository complainRepository;

    @Override
    public Integer addComplain(Complain complain) {
        Complain result = complainRepository.saveAndFlush(complain);
        Integer id = result.getId();
        return id;
    }

    @Override
    public void deleteComplain(Integer id) {
//        //直接删除
//        complainRepository.deleteById(id);
        //更改状态
        Complain r = complainRepository.findById(id).get();
        r.setState(1);
        complainRepository.saveAndFlush(r);

    }

    @Override
    public void updateComplain(Complain complain) {

        complainRepository.saveAndFlush(complain);
    }

    @Override
    public List<Complain> selectAllComplain() {
        return complainRepository.findAll();
    }

    @Override
    public List<Complain> selectbyId(Integer id){
        List<Complain> result = new ArrayList<>();
        List<Complain> allcomplain = complainRepository.findAll();
        for (Complain r : allcomplain){
            if(r.getId() == id){
                result.add(r);
            }
        }
        if(result.size() == 0){
            System.out.print("没有ID为："+id+"的投诉记录");
        }
        return result;
    }

    @Override
    public Complain getComplainByRepair_id(Integer repair_id) {
        List<Complain> allComplain = complainRepository.findAll();
        for (Complain r : allComplain){
            if(r.getRepaire_id() == repair_id){
                return r;
            }
        }
        System.out.print("未找到repaire_id为"+repair_id+"的投诉\n");
        return null;
    }

    //
//    @Override
//    public void deleteComplain(Integer id) {
//        complainRepository.deleteById(id);
//    }
//
//    @Override
//    public void updateComplain(Complain complain) {
//        complainRepository.saveAndFlush(complain);
//    }

//    @Override
//    public List<Complain> selectAllComplain() {
//        return complainRepository.findAll();
//    }

    /**
     * 查询优先级：
     * 1.先查询是否为整型，为整型则通过ID主键查询，返回结果，不为整型则模糊查询其他字段
     * 2.模糊查询字段，忽略密码的模糊查询，对用户名和昵称进行模糊查询，返回结果
     * @param search 查询字段
     * @return 查询列表集合
     */
//    @Override
//    public List<Complain> selectLike(String search) {
//        List<Complain> list = new ArrayList<>();// 查询列表集合
//        Complain complain = new Complain();
////        complain.setComplainname(search);
////        complain.setNickname(search);
//        try {
//            Integer uid = Integer.parseInt(search);
//            Optional<Complain> optional = complainRepository.findById(uid);
//            if (!optional.isPresent()) {
//                list = selectVague(complain);
//            } else {
//                list.add(optional.get());
//            }
//        }catch (NumberFormatException e) {
//            // 查询字段不为整型数据，捕获异常
//            list = selectVague(complain);
//        }
//
//        return list;
//    }

    /**
     * 模糊查询
     * @param complain
     * @return
     */
//    private List<Complain> selectVague(Complain complain) {
//        List<Complain> list = null;
//        ExampleMatcher matcher = ExampleMatcher.matchingAny()
//                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("nickname", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withIgnoreCase("uid")
//                .withIgnoreCase("password");
//        Example<Complain> example = Example.of(complain, matcher);
//        list = complainRepository.findAll(example);
//        return list;
//    }
}
