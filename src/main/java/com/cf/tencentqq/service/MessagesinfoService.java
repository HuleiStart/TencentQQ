package com.cf.tencentqq.service;

import com.cf.tencentqq.entity.Messagesinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Messagesinfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-06 10:49:06
 */
public interface MessagesinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Messagesinfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param messagesinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Messagesinfo> queryByPage(Messagesinfo messagesinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param messagesinfo 实例对象
     * @return 实例对象
     */
    Messagesinfo insert(Messagesinfo messagesinfo);

    /**
     * 修改数据
     *
     * @param messagesinfo 实例对象
     * @return 实例对象
     */
    Messagesinfo update(Messagesinfo messagesinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
