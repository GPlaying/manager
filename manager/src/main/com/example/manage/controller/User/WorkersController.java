package example.manage.controller.User;

import example.manage.bean.User.Workers;
import example.manage.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class WorkersController {

    @Autowired
    private WorkersService workersService;

    public List query(){
        List<Workers> list = workersService.selectAllWorkers();
        System.out.print(list);
        return list;
    }


}