package com.example.spring.ecommerce.demo.mapper;

import com.example.spring.ecommerce.demo.model.Brand;
import com.example.spring.ecommerce.demo.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BrandMapper {

    public List<Brand> findAll(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Brand> brandList = session.selectList("findAll");
        session.commit();
        session.close();
        return brandList;
    }

    public Brand findById(int id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Brand brand =  session.selectOne("findById",id);
        return brand;
    }

    public void saveBrand(Brand brand){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("insert", brand);
        session.commit();
        session.close();
    }

    public void deleteBrand(int id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("delete", id);
        session.commit();
        session.close();
    }

    public void updateBrand(Brand brand){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("update", brand);
        session.commit();
        session.close();
    }
}
