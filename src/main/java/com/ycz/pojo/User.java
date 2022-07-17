package com.ycz.pojo;/*
 @author ycz
 @date 2021-09-04-15:19  
*/

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data //get set
@AllArgsConstructor //有参
@NoArgsConstructor // 无参
@Accessors(chain = true)
public class User {
    /**
     * AUTO(0),//数据库ID自增
     *     NONE(1),//该类型为未设置主键类型
     *     INPUT(2),//用户输入ID
     *       		 //该类型可以通过自己注册自动填充插件进行填充
     *
     * //以下3种类型、只有当插入对象ID 为空，才自动填充。
     *     ID_WORKER(3),//全局唯一ID (idWorker)
     *     UUID(4),//全局唯一ID (UUID)
     *     ID_WORKER_STR(5);//字符串全局唯一ID (idWorker 的字符串表示)
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version //乐观锁version注解
    private Integer version;

    //逻辑删除 逻辑删除: 在数据库中没有被移除,而是通过一个变量来让他失效! deleted=0=>deleted=1
    @TableLogic
    private Integer deleted;

}
