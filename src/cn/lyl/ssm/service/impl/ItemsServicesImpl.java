package cn.lyl.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lyl.ssm.mapper.ItemsMapper;
import cn.lyl.ssm.mapper.ItemsMapperCustom;
import cn.lyl.ssm.po.Items;
import cn.lyl.ssm.po.ItemsCustom;
import cn.lyl.ssm.po.ItemsQueryVo;

/**
 * <p>Title:ItemsServicesImpl</p>
 * <p>Description:商品管理 </p>
 * @author 李银龙
 *		2017年8月5日
 *		上午11:14:02
 */

public class ItemsServicesImpl implements ItemsService{

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		//通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer arg) throws Exception {
		//
		Items items = itemsMapper.selectByPrimaryKey(arg);
		//中间对商品进行业务处理
		//......
		//返回ItemsCustom
		ItemsCustom itemsCustom = new ItemsCustom();
		//将items的内容拷贝到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//校验id是否为空，如果为空，抛出异常
		//更新商品信息使用updateByPrimaryKeyWithBLOBS根据id更新items表中的所有字段，包括大文本类型
		//要求必须传入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

	@Override
	public void delete(Integer id) throws Exception {
		itemsMapper.deleteByPrimaryKey(id);
	}
}
