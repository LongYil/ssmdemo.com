package cn.lyl.ssm.service.impl;

import java.util.List;

import cn.lyl.ssm.po.ItemsCustom;
import cn.lyl.ssm.po.ItemsQueryVo;

/**
 * <p>Title:ItemsService</p>
 * <p>Description: 商品管理service</p>
 * @author 李银龙
 *		2017年8月5日
 *		上午11:07:51
 */

public interface ItemsService {
	
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	//id：查询商品的id
	//商品查询（根据id）
	public ItemsCustom findItemsById(Integer id) throws Exception;
	//id：修改商品的id
	//商品修改（根据id）
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
	public void delete(Integer id) throws Exception;
}
