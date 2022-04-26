package com.myfin.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Zihang Gao, Yuzhuo Ma
 */
public class MybatisUtils {
    static SqlSessionFactory sqlSessionFactory = null;
    
    static {
        try {
            {
                // get the config file
                String config = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(config);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * open the session that communicate with database
     * 
     * @return the session of the database
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (sqlSessionFactory != null){
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }
}
