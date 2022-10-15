package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Anam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Anam)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:50:21
 */
public interface AnamService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Anam queryById(Integer id);

    /**
     * 分页查询
     *
     * @param anam 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Anam> queryByPage(Anam anam, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param anam 实例对象
     * @return 实例对象
     */
    Anam insert(Anam anam);

    /**
     * 修改数据
     *
     * @param anam 实例对象
     * @return 实例对象
     */
    Anam update(Anam anam);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
