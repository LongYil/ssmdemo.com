package cn.lyl.ssm.po;

/**
 * <p>Title:ItemsQueryVo</p>
 * <p>Description: 商品包装对象（包装了查询条件）</p>
 * @author 李银龙
 *		2017年8月5日
 *		上午10:46:35
 */
public class ItemsQueryVo {
	//商品信息
	private Items items;
	
	//为了系统可扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}


}
