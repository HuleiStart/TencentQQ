package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Friendsinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Friendsinfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:49:27
 */
public interface FriendsinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Friendsinfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param friendsinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Friendsinfo> queryByPage(Friendsinfo friendsinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param friendsinfo 实例对象
     * @return 实例对象
     */
    Friendsinfo insert(Friendsinfo friendsinfo);

    /**
     * 修改数据
     *
     * @param friendsinfo 实例对象
     * @return 实例对象
     */
    Friendsinfo update(Friendsinfo friendsinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
