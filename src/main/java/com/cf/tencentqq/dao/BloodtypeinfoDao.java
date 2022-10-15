package com.cf.tencentqq.dao;

import com.cf.tencentqq.entity.Bloodtypeinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Bloodtypeinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-06 10:49:56
 */
public interface BloodtypeinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Bloodtypeinfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param bloodtypeinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Bloodtypeinfo> queryAllByLimit(Bloodtypeinfo bloodtypeinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param bloodtypeinfo 查询条件
     * @return 总行数
     */
    long count(Bloodtypeinfo bloodtypeinfo);

    /**
     * 新增数据
     *
     * @param bloodtypeinfo 实例对象
     * @return 影响行数
     */
    int insert(Bloodtypeinfo bloodtypeinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Bloodtypeinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Bloodtypeinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Bloodtypeinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Bloodtypeinfo> entities);

    /**
     * 修改数据
     *
     * @param bloodtypeinfo 实例对象
     * @return 影响行数
     */
    int update(Bloodtypeinfo bloodtypeinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

