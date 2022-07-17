package com.ycz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ycz.mapper.UserMapper;
import com.ycz.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 加了deleted的时候，自动屏蔽了deleted=1的时候
     */
    @Test
    void contextLoads() {
        List<User> userList=userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void testInsert(){
        //
        User user = new User();

        user.setName("java").setAge(123).setEmail("1561651561@qq.com");
//        user.setAge(1231);
//        user.setEmail("asdada@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    void testSelect(){
        User user= userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void testUpdate(){
        User user=new User();
        user.setId(1L).setName("ycz");
        userMapper.updateById(user);
    }
    /**
     * 测试乐观锁
     */
    @Test
    public void testVersion(){

        User user = userMapper.selectById(2L);

        user.setName("ycz");
        user.setEmail("52195955@qq.com");

        userMapper.updateById(user);

    }

    @Test
    public void testVersionError(){
        User user = userMapper.selectById(4L);
        user.setName("ycz222222");
        user.setEmail("521959552222@qq.com");
        User user2 = userMapper.selectById(4L);
        user2.setName("ycz222222");
        user2.setEmail("521959551111@qq.com");
        userMapper.updateById(user2);
        userMapper.updateById(user);

    }

    @Test
    public void testSelectBatch(){

        List<User> userList = userMapper.selectBatchIds(Arrays.asList(4, 5, 6));
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testSelectBatchMap(){
        Map<String,Object> map=new HashMap<>();

        map.put("name","java");

        List<User> userList = userMapper.selectByMap(map);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void Page(){
        //页面大小
        Page<User> page = new Page<>(1,8);
        userMapper.selectPage(page,null);

        for (User pageRecord : page.getRecords()) {
            System.out.println(pageRecord);
        }
    }

    /**
     * 本质是将deleted的值从 0 变成 1 就是更新，不删除
     */
    @Test
    public void deleteById(){
        userMapper.deleteById(5L);
    }

    @Test
    public void deleteBatchById(){
        userMapper.deleteBatchIds(Arrays.asList(10L,11L));
    }

    @Test
    public void deleteByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","ycz");
        userMapper.deleteByMap(map);
    }

}
