package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Animalyearinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Animalyearinfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:50:09
 */
public interface AnimalyearinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Animalyearinfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param animalyearinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Animalyearinfo> queryByPage(Animalyearinfo animalyearinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param animalyearinfo 实例对象
     * @return 实例对象
     */
    Animalyearinfo insert(Animalyearinfo animalyearinfo);

    /**
     * 修改数据
     *
     * @param animalyearinfo 实例对象
     * @return 实例对象
     */
    Animalyearinfo update(Animalyearinfo animalyearinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
