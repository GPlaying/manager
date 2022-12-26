package example.manage.repository.User;

import example.manage.bean.User.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispatcherRepository extends JpaRepository<Dispatcher, Integer> {
}
