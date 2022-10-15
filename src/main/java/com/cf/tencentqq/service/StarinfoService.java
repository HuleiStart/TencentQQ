package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Starinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Starinfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:48:17
 */
public interface StarinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Starinfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param starinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Starinfo> queryByPage(Starinfo starinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param starinfo 实例对象
     * @return 实例对象
     */
    Starinfo insert(Starinfo starinfo);

    /**
     * 修改数据
     *
     * @param starinfo 实例对象
     * @return 实例对象
     */
    Starinfo update(Starinfo starinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
