import com.xzh.jpa.Application;
import com.xzh.jpa.entity.User;
import com.xzh.jpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = userRepository.save(User.builder().name("XZZ").email("FDG@126.com").metaLogicFlag(1).build());
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }

    @Test
    public void testDelUser() {
        userRepository.delete(User.builder().id(1L).build());
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }
}
