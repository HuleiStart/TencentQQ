package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Questioninfo;
import com.cf.tencentqq.dao.QuestioninfoDao;
import com.cf.tencentqq.service.QuestioninfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Questioninfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:48:32
 */
@Service("questioninfoService")
public class QuestioninfoServiceImpl implements QuestioninfoService {
    @Resource
    private QuestioninfoDao questioninfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Questioninfo queryById(Integer id) {
        return this.questioninfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param questioninfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Questioninfo> queryByPage(Questioninfo questioninfo, PageRequest pageRequest) {
        long total = this.questioninfoDao.count(questioninfo);
        return new PageImpl<>(this.questioninfoDao.queryAllByLimit(questioninfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param questioninfo 实例对象
     * @return 实例对象
     */
    @Override
    public Questioninfo insert(Questioninfo questioninfo) {
        this.questioninfoDao.insert(questioninfo);
        return questioninfo;
    }

    /**
     * 修改数据
     *
     * @param questioninfo 实例对象
     * @return 实例对象
     */
    @Override
    public Questioninfo update(Questioninfo questioninfo) {
        this.questioninfoDao.update(questioninfo);
        return this.queryById(questioninfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.questioninfoDao.deleteById(id) > 0;
    }
}
