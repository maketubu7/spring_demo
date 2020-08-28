package com.make.provider;

import com.make.model.heroDAO;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/28
 * Description:
 */
public class sqlProvider {
    public String addHero(@Param("hero") heroDAO hero){
        return new SQL() {
            {
                INSERT_INTO("make_heros");
                if (hero.getName() != null) {
                    VALUES("NAME", "#{name}");
                }
                if (hero.getQ() != null) {
                    VALUES("q", "#{q}");
                }
                if (hero.getE() != null) {
                    VALUES("w", "#{w}");
                }
                if (hero.getW() != null) {
                    VALUES("e", "#{e}");
                }
                if (hero.getR() != null) {
                    VALUES("r", "#{r}");
                }
            }
        }.toString();
    }

    public String updateHero(@Param("hero") heroDAO hero) {
        return new SQL(){{
            UPDATE("make_heros");
            if (!StringUtils.isEmpty(hero.getName())) {
                SET("name = #{hero.name,javaType=String,jdbcType=VARCHAR}");
            }
            if (!StringUtils.isEmpty(hero.getQ())) {
                SET("q= #{hero.q,javaType=String,jdbcType=VARCHAR}");
            }
            if (!StringUtils.isEmpty(hero.getE())) {
                SET("w= #{hero.w,javaType=Long,jdbcType=VARCHAR}");
            }
            if (!StringUtils.isEmpty(hero.getW())) {
                SET("e= #{hero.e,javaType=String,jdbcType=VARCHAR}");
            }
            if (!StringUtils.isEmpty(hero.getR())) {
                SET("e= #{hero.r,javaType=String,jdbcType=VARCHAR}");
            }
            WHERE("id = #{hero.id,javaType=Long,jdbcType=BIGINT} and name = #{hero.name,javaType=Long,jdbcType=BIGINT}" );
        }}.toString();
    }
}
