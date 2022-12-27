package example.manage.repository.User;

import example.manage.bean.User.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatcherRepository extends JpaRepository<Dispatcher, Integer> {
}
