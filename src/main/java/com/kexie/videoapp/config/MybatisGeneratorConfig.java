package com.kexie.videoapp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 欲隐君。 on 2020/6/9
 */

@Configuration
@MapperScan({"com.kexie.videoapp.mbg.mapper","com.kexie.videoapp.dao"})
public class MybatisGeneratorConfig {
}
