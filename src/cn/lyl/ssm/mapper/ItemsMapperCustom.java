package cn.lyl.ssm.mapper;

import java.util.List;

import cn.lyl.ssm.po.ItemsCustom;
import cn.lyl.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	//商品列表查询
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
}