package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussxinliwenzhangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxinliwenzhangView;


/**
 * 心理文章评论表
 *
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface DiscussxinliwenzhangService extends IService<DiscussxinliwenzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxinliwenzhangView> selectListView(Wrapper<DiscussxinliwenzhangEntity> wrapper);
   	
   	DiscussxinliwenzhangView selectView(@Param("ew") Wrapper<DiscussxinliwenzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxinliwenzhangEntity> wrapper);
   	

}

