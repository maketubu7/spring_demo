package com.make.dao;

import com.make.model.heroDAO;
import com.make.model.heroDAOKey;
import com.make.provider.sqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
public interface heroMybatisMapper {
    String tablename = "make_heros";

    @Delete("delete from " + tablename + " where id = #{key.id} and name = #{key.name}")
    int deleteByKey(@Param("key") heroDAOKey key);

    @Insert("insert into " + tablename + "(name,q,w,e,r) values(#{hero.name},#{hero.q}," +
            "#{hero.w},#{hero.e},#{hero.r})")
    @Options(keyProperty="hero.id",useGeneratedKeys=true)
    int addHero(@Param("hero") heroDAO hero);

    @Insert({
            "<script>",
            "insert into make_heros(name, q,w,e,r) values ",
            "<foreach collection='heros' item='item' index='index' separator=','>",
            "(#{item.name}, #{item.q}, #{item.w},#{item.e},#{item.r})",
            "</foreach>",
            "</script>"
    })
        //多条数据插入
    int batchAddHero(@Param("heros") List<heroDAO> heros);

    @InsertProvider(type = sqlProvider.class,method = "addHero")
    @Options(keyProperty="hero.id",useGeneratedKeys=true)
    int addHeroSelective(heroDAO record);

    @Results(id = "heroResMap",value = {
            @Result(column = "id",property = "id",id=true,jdbcType = JdbcType.INTEGER),
            @Result(column = "name",property = "name",id=true,jdbcType = JdbcType.VARCHAR),
            @Result(column = "q",property = "q",jdbcType = JdbcType.VARCHAR),
            @Result(column = "w",property = "w",jdbcType = JdbcType.VARCHAR),
            @Result(column = "e",property = "e",jdbcType = JdbcType.VARCHAR),
            @Result(column = "r",property = "r",jdbcType = JdbcType.VARCHAR)
    })
    @Select("select id,name, q, w, e, r from " + tablename + " where id = #{id} and name = #{name}")
    heroDAO selectByKey(heroDAOKey key);

    @ResultMap(value = "heroResMap")
    @Select("select id,name, q, w, e, r from " + tablename + " where name = #{name}")
    List<heroDAO> selectByName(String name);

    @Update("update " + tablename + " set q=#{q},e=#{e},w=#{w},r=#{r} where id=#{id} and name=#{name}")
    int updateHero(heroDAO hero);

    @UpdateProvider(type = sqlProvider.class,method = "updateHero")
    int updateHeroSelective(heroDAO hero);

    @ResultMap(value = "heroResMap")
    @Select("select id,name,q,w,e,r from " + tablename)
    List<heroDAO> findAllHero();
}