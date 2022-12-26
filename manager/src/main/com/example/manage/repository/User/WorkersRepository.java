package example.manage.repository.User;

import example.manage.bean.User.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Integer> {

}
