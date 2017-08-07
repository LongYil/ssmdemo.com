package cn.lyl.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.lyl.ssm.po.ItemsCustom;
import cn.lyl.ssm.po.ItemsQueryVo;
import cn.lyl.ssm.service.impl.ItemsService;

/**
 * <p>Title:ItemsController</p>
 * <p>Description: 商品的controller</p>
 * @author 李银龙
 *		2017年8月5日
 *		下午9:24:40
 */
@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：商品列表：//items/queryItems.action
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	//商品查询列表
	//@RequestMapping实现方法和url进行映射
	//一般建议url和方法名写成一样，queryItems可以加action后缀
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{

		//调用service查询数据库，查询商品列表，这里使用静态数据模拟
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		//相当于request的setAttribute方法
		modelAndView.addObject("itemsList", itemsList);
		//指定视图
		modelAndView.setViewName("itemsList");
		return modelAndView;		
	}

	
	//商品信息修改页面显示
//	@RequestMapping("/editItems")
	//限制http请求方法
//	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editItems() throws Exception{
//		
//		//调用service根据id查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(4);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		//将商品信息放到model中
//		modelAndView.addObject("itemsCustom", itemsCustom);
//		//指定视图
//		modelAndView.setViewName("items/editItems");
//		return modelAndView;		
//	}
	//@RequestParam(value="id"),里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	public String editItems(Model model,HttpServletRequest request,@RequestParam(value="id",required=true)Integer items_id) throws Exception{
		
		//调用service根据id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		
		//通过形参中的model将model数据传到页面
		//此方法和modelandview方法相当
		model.addAttribute("itemsCustom",itemsCustom);
		return "editItems";
	}
	
	//商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom) throws Exception{
		
		//调用service更新商品信息，页面需要将商品信息传到此方法
		//重定向
		itemsService.updateItems(id, itemsCustom);
//		return "redirect:queryItems.action";
		return "success";
	}
	//批量删除商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		//调用service批量删除商品
		
		for (Integer integer : items_id) {
			itemsService.delete(integer);
		}
		
		return "success";
	}
	
}
