package example.manage.controller.Complain;

import example.manage.bean.Complain.Complain;
import example.manage.service.Complain.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class ComplainController {

//    @Autowired
//    private ComplainService complainService;
//
//    public void deleteComplain(Integer id) {
//        complainService.deleteComplain(id);
//    }
//
//    public void addComplain(Complain complain) {
//        complainService.addComplain(complain);
//    }
//
//    public void updateComplain(Complain complain) {
//        complainService.updateComplain(complain);
//    }

//        public List selectLike(String search) {
//        List<Complain> list = complainService.selectLike(search);
//        System.out.print(list);
//        return list;
//    }

//    @GetMapping(value = "/select")
//    public ModelAndView selectLike(String search) {
//        ModelAndView view = new ModelAndView("index::userTable");
//        view.addObject("user_list", complainService.selectLike(search));
//        return view;
//    }

//    @PostMapping(value = "/delete")
//    public ModelAndView deleteUser(Integer id) {
//        complainService.deleteUser(id);
//        ModelAndView view = new ModelAndView("index::userTable");
//        view.addObject("user_list", complainService.selectAllUser());
//        return view;
//    }

//    @PostMapping(value = "/insert")
//    public ModelAndView insertUser(User user) {
//        // 插入数据
//        complainService.insertUser(user);
//        // 回传代码片段
//        ModelAndView view = new ModelAndView("index::userTable");
//        view.addObject("user_list", complainService.selectAllUser());
//        return view;
//    }

//    @PostMapping(value = "update")
//    public ModelAndView updateUser(User user) {
//        complainService.updateUser(user);
//        ModelAndView view = new ModelAndView("index::userTable");
//        view.addObject("user_list", complainService.selectAllUser());
//        return view;
//    }
}
