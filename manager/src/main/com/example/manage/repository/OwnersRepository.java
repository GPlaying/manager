package example.manage.repository;

import example.manage.bean.User.Owners;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OwnersRepository extends JpaRepository<Owners, Integer> {

}
