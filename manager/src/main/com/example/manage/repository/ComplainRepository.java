package example.manage.repository;

import example.manage.bean.Complain.Complain;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComplainRepository extends JpaRepository<Complain, Integer> {

}
