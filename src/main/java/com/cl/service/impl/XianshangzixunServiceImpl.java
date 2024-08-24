package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.XianshangzixunDao;
import com.cl.entity.XianshangzixunEntity;
import com.cl.service.XianshangzixunService;
import com.cl.entity.view.XianshangzixunView;

@Service("xianshangzixunService")
public class XianshangzixunServiceImpl extends ServiceImpl<XianshangzixunDao, XianshangzixunEntity> implements XianshangzixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianshangzixunEntity> page = this.selectPage(
                new Query<XianshangzixunEntity>(params).getPage(),
                new EntityWrapper<XianshangzixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianshangzixunEntity> wrapper) {
		  Page<XianshangzixunView> page =new Query<XianshangzixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XianshangzixunView> selectListView(Wrapper<XianshangzixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianshangzixunView selectView(Wrapper<XianshangzixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
