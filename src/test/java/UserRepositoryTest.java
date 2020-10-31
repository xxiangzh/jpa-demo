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
        User user = userRepository.save(User.builder().name("ee").email("asfs@126.com").build());
        Assert.assertNotNull(user);
        List<User> users = userRepository.findAll();
        System.out.println(users);
        Assert.assertNotNull(users);
    }
}
