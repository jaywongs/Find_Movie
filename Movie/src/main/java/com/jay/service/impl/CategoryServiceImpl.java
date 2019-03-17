package com.jay.service.impl;

import com.jay.common.E3Result;
import com.jay.mapper.CategoryMapper;
import com.jay.po.Category;
import com.jay.po.CategoryExample;
import com.jay.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by jaywang on 2019/3/15.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public E3Result getAllCategory() {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        List<Category> list = categoryMapper.selectByExample(categoryExample);

        if (list == null || list.size() == 0) {
            return E3Result.build(400, "分类标签获取失败");
        }
        return E3Result.ok(list);
    }
}
