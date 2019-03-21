package com.jay.service.impl;

import com.jay.mapper.BrowseMapper;
import com.jay.po.Browse;
import com.jay.po.BrowseExample;
import com.jay.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by jaywang on 2019/3/19.
 */
@Service
public class BrowseServiceImpl implements BrowseService {

    @Autowired
    BrowseMapper browseMapper;

    @Override
    public Browse getBrowseByUserid(Integer userid) {
        BrowseExample example = new BrowseExample();
        BrowseExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Browse> browseList = browseMapper.selectByExample(example);
        if (browseList != null && browseList.size() != 0)
            return browseList.get(0);
        else
            return null;
    }
}
