package com.cl.entity.view;

import com.cl.entity.XianshangzixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 线上咨询
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
@TableName("xianshangzixun")
public class XianshangzixunView  extends XianshangzixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XianshangzixunView(){
	}
 
 	public XianshangzixunView(XianshangzixunEntity xianshangzixunEntity){
 	try {
			BeanUtils.copyProperties(this, xianshangzixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
