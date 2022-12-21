package example.manage.controller.User;

import example.manage.bean.User.Owners;
import example.manage.service.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class OwnersController {

    @Autowired
    private OwnersService ownersService;

    public List query(){
        List<Owners> list = ownersService.selectAllOwners();
        System.out.print(list);
        return list;
    }


}