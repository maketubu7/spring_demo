package com.make.dao;

import com.make.model.heroDAO;
import com.make.model.heroDAOKey;
import com.make.provider.sqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.jdbc.core.SqlProvider;

import java.util.List;

public interface heroMybatisMapper {
    String tablename = "make_heros";

    @Delete("delete from " + tablename + " where id = #{key.id} and name = #{key.name}")
    int deleteByKey(@Param("key") heroDAOKey key);

    @Insert("insert into " + tablename + " values(null,#{hero.name},#{hero.q}," +
            "#{hero.w},#{hero.e},#{hero.r})")
    @Options(keyProperty="hero.id",useGeneratedKeys=true)
    int addHero(@Param("hero") heroDAO hero);

    @InsertProvider(type = sqlProvider.class,method = "addHero")
    @Options(keyProperty="hero.id",useGeneratedKeys=true)
    int addHeroSelective(heroDAO record);

    @Select("select * from " + tablename + " where name = #{name}")
    heroDAO selectByName(@Param("name") String name);

    @Update("update " + tablename + " set q = #{hero.1},e=#{hero.e},w=#{hero.w}," +
            "r=#{hero.r} where id=#{hero.id} and name=#{hero.name}")
    int updateHero(heroDAO hero);

    @UpdateProvider(type = sqlProvider.class,method = "updateHero")
    int updateHeroSelective(heroDAO hero);

    @Select("select * from " + tablename)
    List<heroDAO> findAllHero();
}