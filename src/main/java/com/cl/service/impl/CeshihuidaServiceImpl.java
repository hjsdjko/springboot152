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


import com.cl.dao.CeshihuidaDao;
import com.cl.entity.CeshihuidaEntity;
import com.cl.service.CeshihuidaService;
import com.cl.entity.view.CeshihuidaView;

@Service("ceshihuidaService")
public class CeshihuidaServiceImpl extends ServiceImpl<CeshihuidaDao, CeshihuidaEntity> implements CeshihuidaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CeshihuidaEntity> page = this.selectPage(
                new Query<CeshihuidaEntity>(params).getPage(),
                new EntityWrapper<CeshihuidaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CeshihuidaEntity> wrapper) {
		  Page<CeshihuidaView> page =new Query<CeshihuidaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CeshihuidaView> selectListView(Wrapper<CeshihuidaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CeshihuidaView selectView(Wrapper<CeshihuidaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
