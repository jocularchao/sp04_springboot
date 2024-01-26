package top.jocularchao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.jocularchao.entity.User;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/9 17:19
 * @Description
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username};")
    User findUserByUsername(String username);

}
