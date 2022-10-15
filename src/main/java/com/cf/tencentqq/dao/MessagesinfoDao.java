package com.cf.tencentqq.dao;

import com.cf.tencentqq.entity.Messagesinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Messagesinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-06 10:49:06
 */
public interface MessagesinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Messagesinfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param messagesinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Messagesinfo> queryAllByLimit(Messagesinfo messagesinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param messagesinfo 查询条件
     * @return 总行数
     */
    long count(Messagesinfo messagesinfo);

    /**
     * 新增数据
     *
     * @param messagesinfo 实例对象
     * @return 影响行数
     */
    int insert(Messagesinfo messagesinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Messagesinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Messagesinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Messagesinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Messagesinfo> entities);

    /**
     * 修改数据
     *
     * @param messagesinfo 实例对象
     * @return 影响行数
     */
    int update(Messagesinfo messagesinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    @Select("select * from messagesinfo where fromuserid = #{fromuserid} and touserid = #{touserid} or " +
            "fromuserid = #{touserid} and touserid = #{fromuserid} ")
    List<Messagesinfo> sel(Messagesinfo messagesinfo);

    @Insert("insert into messagesinfo values (null,#{fromuserid},#{touserid},#{message},1,2,now())")
    int addMessage(Messagesinfo messagesinfo);

}

