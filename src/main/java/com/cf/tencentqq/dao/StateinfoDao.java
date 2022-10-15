package com.cf.tencentqq.dao;

import com.cf.tencentqq.entity.Stateinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;
/**
 * (Stateinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-06 10:48:01
 */
public interface StateinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Stateinfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param stateinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Stateinfo> queryAllByLimit(Stateinfo stateinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param stateinfo 查询条件
     * @return 总行数
     */
    long count(Stateinfo stateinfo);

    /**
     * 新增数据
     *
     * @param stateinfo 实例对象
     * @return 影响行数
     */
    int insert(Stateinfo stateinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Stateinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Stateinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Stateinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Stateinfo> entities);

    /**
     * 修改数据
     *
     * @param stateinfo 实例对象
     * @return 影响行数
     */
    int update(Stateinfo stateinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询所有状态
     * @return 状态的集合
     */
    @Select("select * from stateinfo")
    List<Stateinfo> selAll();
}