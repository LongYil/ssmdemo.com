package cn.lyl.ssm.controller.converter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * <p>Title:CustomDateConverter</p>
 * <p>Description: 需要实现converter接口</p>
 * @author 李银龙
 *		2017年8月6日
 *		下午9:28:25
 */
public class CustomDateConverter implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		//将日期转成日期类型（根式是yyyy-MM-dd HH:mm:ss）
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果参数绑定失败，返回空
		return null;
	}
    
}
