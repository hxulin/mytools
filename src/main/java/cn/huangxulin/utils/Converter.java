package cn.huangxulin.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: JavaBean转换工具类
 *
 * @author hxulin
 */
public final class Converter {

	private Converter() {

	}

	/**
	 * 将Map转换为JavaBean
	 * 
	 * @param map 待转换的Map对象
	 * @param clazz 需要转换对象的字节码类型
	 * @return 转换后的JavaBean对象
	 */
	public static Object map2Object(Map<String, Object> map, Class<?> clazz) {
		if (map == null) {
			return null;
		}
		try {
			Object obj = clazz.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				Method setter = pd.getWriteMethod();
				if (setter != null) {
					setter.invoke(obj, map.get(pd.getName()));
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将JavaBean转换为Map
	 * 
	 * @param obj 待转换的JavaBean对象
	 * @return 转换后的Map对象
	 */
	public static Map<String, Object> object2Map(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				String key = pd.getName();
				Method getter = pd.getReadMethod();
				Object value = getter != null ? getter.invoke(obj) : null;
				map.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
