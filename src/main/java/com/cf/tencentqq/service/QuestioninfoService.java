package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Questioninfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Questioninfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:48:32
 */
public interface QuestioninfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Questioninfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param questioninfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Questioninfo> queryByPage(Questioninfo questioninfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param questioninfo 实例对象
     * @return 实例对象
     */
    Questioninfo insert(Questioninfo questioninfo);

    /**
     * 修改数据
     *
     * @param questioninfo 实例对象
     * @return 实例对象
     */
    Questioninfo update(Questioninfo questioninfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
