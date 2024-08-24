package com.cl.entity.view;

import com.cl.entity.XinliwenzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 心理文章
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
@TableName("xinliwenzhang")
public class XinliwenzhangView  extends XinliwenzhangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XinliwenzhangView(){
	}
 
 	public XinliwenzhangView(XinliwenzhangEntity xinliwenzhangEntity){
 	try {
			BeanUtils.copyProperties(this, xinliwenzhangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
