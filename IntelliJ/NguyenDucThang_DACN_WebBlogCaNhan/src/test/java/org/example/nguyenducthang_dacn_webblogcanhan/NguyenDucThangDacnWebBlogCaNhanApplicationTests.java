package org.example.nguyenducthang_dacn_webblogcanhan;

import org.example.nguyenducthang_dacn_webblogcanhan.models.User;
import org.example.nguyenducthang_dacn_webblogcanhan.services.interfaces.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class NguyenDucThangDacnWebBlogCaNhanApplicationTests {
    @Autowired
    private IUserRepository userRepository;
    @Test
    public void testAddNew(){

        LocalDate date = LocalDate.now();
        Date currDate = Date.valueOf(date);

        User user = new User();
        user.setUsername("test04");
        user.setPassword("test");
        user.setAvatar("avatarUser.png");
        user.setCreated_at(currDate);
        user.setRole_id(1);
        user.setStatus(true);

        User save = userRepository.save(user);

        assertThat(save).isNotNull();
        assertThat(save.getId()).isGreaterThan(0);
    }

}
