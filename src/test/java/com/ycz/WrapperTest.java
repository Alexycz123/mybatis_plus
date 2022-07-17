package com.ycz;/*
 @author ycz
 @date 2021-09-08-16:50  
*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycz.mapper.UserMapper;
import com.ycz.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //查询年龄不为空，邮箱不为空，年龄大于12的用户
        wrapper.isNotNull("name").isNotNull("email").ge("age",12);
        userMapper.selectList(wrapper);
    }

    @Test
    public void testSelect2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","ycz222222");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void testSelect3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",100,200);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    @Test
    public void testSelect4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //
        wrapper.notLike("name","l")
                .likeRight("email","a"); //类似于 a%
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void testSelectIn(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id","select id from user where id<8");
        List<Object> user = userMapper.selectObjs(wrapper);
        System.out.println(user);
    }

    @Test
    public void testSelectOrderBy(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //根据id 降序排序
        wrapper.orderByDesc("id");
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
