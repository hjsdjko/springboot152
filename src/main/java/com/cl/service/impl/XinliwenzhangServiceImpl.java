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


import com.cl.dao.XinliwenzhangDao;
import com.cl.entity.XinliwenzhangEntity;
import com.cl.service.XinliwenzhangService;
import com.cl.entity.view.XinliwenzhangView;

@Service("xinliwenzhangService")
public class XinliwenzhangServiceImpl extends ServiceImpl<XinliwenzhangDao, XinliwenzhangEntity> implements XinliwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinliwenzhangEntity> page = this.selectPage(
                new Query<XinliwenzhangEntity>(params).getPage(),
                new EntityWrapper<XinliwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinliwenzhangEntity> wrapper) {
		  Page<XinliwenzhangView> page =new Query<XinliwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XinliwenzhangView> selectListView(Wrapper<XinliwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinliwenzhangView selectView(Wrapper<XinliwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
