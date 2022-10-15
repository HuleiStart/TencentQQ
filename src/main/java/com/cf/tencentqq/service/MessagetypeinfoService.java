package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Messagetypeinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Messagetypeinfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:48:45
 */
public interface MessagetypeinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Messagetypeinfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param messagetypeinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Messagetypeinfo> queryByPage(Messagetypeinfo messagetypeinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param messagetypeinfo 实例对象
     * @return 实例对象
     */
    Messagetypeinfo insert(Messagetypeinfo messagetypeinfo);

    /**
     * 修改数据
     *
     * @param messagetypeinfo 实例对象
     * @return 实例对象
     */
    Messagetypeinfo update(Messagetypeinfo messagetypeinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
