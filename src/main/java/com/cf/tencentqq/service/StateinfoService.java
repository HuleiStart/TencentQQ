package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Stateinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Stateinfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:48:01
 */
public interface StateinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Stateinfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param stateinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Stateinfo> queryByPage(Stateinfo stateinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param stateinfo 实例对象
     * @return 实例对象
     */
    Stateinfo insert(Stateinfo stateinfo);

    /**
     * 修改数据
     *
     * @param stateinfo 实例对象
     * @return 实例对象
     */
    Stateinfo update(Stateinfo stateinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
