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


import com.cl.dao.XinlipingjiaDao;
import com.cl.entity.XinlipingjiaEntity;
import com.cl.service.XinlipingjiaService;
import com.cl.entity.view.XinlipingjiaView;

@Service("xinlipingjiaService")
public class XinlipingjiaServiceImpl extends ServiceImpl<XinlipingjiaDao, XinlipingjiaEntity> implements XinlipingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinlipingjiaEntity> page = this.selectPage(
                new Query<XinlipingjiaEntity>(params).getPage(),
                new EntityWrapper<XinlipingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinlipingjiaEntity> wrapper) {
		  Page<XinlipingjiaView> page =new Query<XinlipingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XinlipingjiaView> selectListView(Wrapper<XinlipingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinlipingjiaView selectView(Wrapper<XinlipingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<XinlipingjiaEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<XinlipingjiaEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<XinlipingjiaEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }


    @Override
    public List<Map<String, Object>> xinlipingjiaTypeStat(Map<String, Object> params, Wrapper<XinlipingjiaEntity> wrapper) {
        return baseMapper.xinlipingjiaTypeStat(params, wrapper);
    }


}
