package com.ycz;/*
 @author ycz
 @date 2021-09-08-19:14  
*/


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * 代码自动生成器
 */
public class Test2 {
    public static void main(String[] args) {
        AutoGenerator mpg=new AutoGenerator();
        //全局配置
        GlobalConfig config=new GlobalConfig();
        config.setAuthor("ycz");
        String projectPath = System.getProperty("user.dir");
        config.setOutputDir(projectPath+"/src/main/java");
        config.setOpen(false);//是否自动打开文件夹
        config.setFileOverride(false);//是否覆盖
        config.setIdType(IdType.ID_WORKER);
        config.setServiceName("%sService"); // 去Service的I前缀
        config.setDateType(DateType.ONLY_DATE);
        config.setSwagger2(true);
        mpg.setGlobalConfig(config);

        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/blog_system?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setDbType(DbType.MYSQL);
        mpg.setDataSource(dataSourceConfig);

        PackageConfig pc = new PackageConfig();
     //  pc.setModuleName("blog");
        pc.setParent("com.ycz");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);


        StrategyConfig strategy=new StrategyConfig();
        strategy.setInclude("t_article");// 设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // 自动lombok；
        strategy.setLogicDeleteFieldName("deleted");

        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true); //localhost:8080/hello_id_2
        mpg.setStrategy(strategy);
        mpg.execute(); //执行



    }


}
