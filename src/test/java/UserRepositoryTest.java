import com.xzh.jpa.Application;
import com.xzh.jpa.entity.User;
import com.xzh.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = userRepository.save(User.builder().username("XZZ").password("123456").deleteFlag(1).build());
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }

    @Test
    public void testDelUser() {
        Optional<User> optional = userRepository.findById(11L);
        User user = optional.get();
        userRepository.delete(user);
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }

    @Test
    public void find() {
        User user = new User();
        user.setPassword("123456");
        Example<User> example = Example.of(user);
        List<User> list = userRepository.findAll(example);
        list.forEach(System.out::println);
    }

    @Test
    public void findByUsername() {

        System.out.println("-----1-----");
        User user1 = userRepository.findByUsername("x");
        System.out.println(user1);

        System.out.println("-----2-----");
        User user2 = userRepository.findFirstByUsername("xzh");
        System.out.println(user2);

        System.out.println("-----3-----");
        User user3 = userRepository.findByQuery("x");
        System.out.println(user3);

        System.out.println("-----4-----");
        User user4 = userRepository.findByUsernameWithJpql("x");
        System.out.println(user4);

        System.out.println("-----5-----");
        User user5 = userRepository.findByUsernameWithSql("x");
        System.out.println(user5);

        System.out.println("-----6-----");
        User user6 = userRepository.findByUsernameWithSqlNo("x");
        System.out.println(user6);

        System.out.println("-----7----");
        List<User> users = userRepository.findByEntityWithSql(User.builder().username("xzh").deleteFlag(1).build());
        for (User user7 : users) {
            System.out.println(user7);
        }
    }
}
