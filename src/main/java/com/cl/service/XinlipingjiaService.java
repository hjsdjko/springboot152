package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XinlipingjiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinlipingjiaView;


/**
 * 心理评价
 *
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XinlipingjiaService extends IService<XinlipingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinlipingjiaView> selectListView(Wrapper<XinlipingjiaEntity> wrapper);
   	
   	XinlipingjiaView selectView(@Param("ew") Wrapper<XinlipingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinlipingjiaEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XinlipingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XinlipingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XinlipingjiaEntity> wrapper);


    List<Map<String, Object>> xinlipingjiaTypeStat(Map<String, Object> params,Wrapper<XinlipingjiaEntity> wrapper);

}

