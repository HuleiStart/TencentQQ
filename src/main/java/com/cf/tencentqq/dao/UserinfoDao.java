package com.cf.tencentqq.dao;

import com.cf.tencentqq.entity.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Userinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-06 10:45:46
 */
public interface UserinfoDao {

    /**
     * 登录功能
     * @param userinfo 用户对象参数
     * @return 返回查询到的对象
     */
    Userinfo login(Userinfo userinfo);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Userinfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param userinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Userinfo> queryAllByLimit(Userinfo userinfo, @Param("pageable") Pageable pageable);

    /**
     * 通过昵称模糊查询用户
     * @param nickName 昵称
     * @return
     */

    @Select("select * from userinfo where nickname LIKE CONCAT('%',#{nickName},'%')")
    List<Userinfo> searchUserinfosBYNickName(String nickName);



    /**
     * 统计总行数
     *
     * @param userinfo 查询条件
     * @return 总行数
     */
    long count(Userinfo userinfo);


    /**
     * 新增数据
     *
     * @param userinfo 实例对象
     * @return 影响行数
     */
    int insert(Userinfo userinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Userinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Userinfo> entities);

    /**
     * 修改数据
     *
     * @param userinfo 实例对象
     * @return 影响行数
     */
    int update(Userinfo userinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int add(Userinfo userinfo);
}

