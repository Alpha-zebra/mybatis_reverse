package com.alpha;

import com.alpha.mapper.CategoryMapper;
import com.alpha.pojo.Category;
import com.alpha.pojo.CategoryExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws IOException {

        String resource="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        CategoryExample example=new CategoryExample();
        example.createCriteria().andNameLike("%9%");
        CategoryMapper mapper=session.getMapper(CategoryMapper.class);
        List<Category> cs=mapper.selectByExample(example);

        cs.forEach(category -> {
            System.out.println(category.getName());
        });

    }
}
