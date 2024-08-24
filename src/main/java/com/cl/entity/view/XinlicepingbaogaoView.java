package com.cl.entity.view;

import com.cl.entity.XinlicepingbaogaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 心理测评报告
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
@TableName("xinlicepingbaogao")
public class XinlicepingbaogaoView  extends XinlicepingbaogaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XinlicepingbaogaoView(){
	}
 
 	public XinlicepingbaogaoView(XinlicepingbaogaoEntity xinlicepingbaogaoEntity){
 	try {
			BeanUtils.copyProperties(this, xinlicepingbaogaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
