package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Bloodtypeinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Bloodtypeinfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:49:56
 */
public interface BloodtypeinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Bloodtypeinfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param bloodtypeinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Bloodtypeinfo> queryByPage(Bloodtypeinfo bloodtypeinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param bloodtypeinfo 实例对象
     * @return 实例对象
     */
    Bloodtypeinfo insert(Bloodtypeinfo bloodtypeinfo);

    /**
     * 修改数据
     *
     * @param bloodtypeinfo 实例对象
     * @return 实例对象
     */
    Bloodtypeinfo update(Bloodtypeinfo bloodtypeinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
