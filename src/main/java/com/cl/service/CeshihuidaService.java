package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CeshihuidaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CeshihuidaView;


/**
 * 测试回答
 *
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface CeshihuidaService extends IService<CeshihuidaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CeshihuidaView> selectListView(Wrapper<CeshihuidaEntity> wrapper);
   	
   	CeshihuidaView selectView(@Param("ew") Wrapper<CeshihuidaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CeshihuidaEntity> wrapper);
   	

}

