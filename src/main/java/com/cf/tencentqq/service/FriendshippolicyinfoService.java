package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Friendshippolicyinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Friendshippolicyinfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:49:44
 */
public interface FriendshippolicyinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Friendshippolicyinfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param friendshippolicyinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Friendshippolicyinfo> queryByPage(Friendshippolicyinfo friendshippolicyinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param friendshippolicyinfo 实例对象
     * @return 实例对象
     */
    Friendshippolicyinfo insert(Friendshippolicyinfo friendshippolicyinfo);

    /**
     * 修改数据
     *
     * @param friendshippolicyinfo 实例对象
     * @return 实例对象
     */
    Friendshippolicyinfo update(Friendshippolicyinfo friendshippolicyinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
