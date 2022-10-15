package com.cf.tencentqq.dao;

import com.cf.tencentqq.entity.Friendsinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Friendsinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-06 10:49:27
 */
public interface FriendsinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Friendsinfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param friendsinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Friendsinfo> queryAllByLimit(Friendsinfo friendsinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param friendsinfo 查询条件
     * @return 总行数
     */
    long count(Friendsinfo friendsinfo);

    /**
     * 新增数据
     *
     * @param friendsinfo 实例对象
     * @return 影响行数
     */
    int insert(Friendsinfo friendsinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Friendsinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Friendsinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Friendsinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Friendsinfo> entities);

    /**
     * 修改数据
     *
     * @param friendsinfo 实例对象
     * @return 影响行数
     */
    int update(Friendsinfo friendsinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过本人id查询好友列表
     */
    @Select("select * from friendsinfo where hostid = #{id}")
    List<Friendsinfo> getFriendsById(int id);
}

