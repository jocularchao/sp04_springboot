package top.jocularchao;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

@SpringBootTest
class ApplicationTests {


    @Resource
    JdbcTemplate template;

    @Test
    void contextLoads() {
        Map<String, Object> map = template.queryForMap("select * from user where username = ?", "test");
        System.out.println(map);

    }

    @Test
    void getUserByUsername() {

        int update = template.update("insert into user (username, password)values ('test3','123456');");

        System.out.println(update);
    }





}
