package cn.huangxulin.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 功能描述: 对象克隆工具类
 *
 * @author hxulin
 */
public final class CloneUtils {

	private CloneUtils() {
		
	}
	
	/**
	 * 深度克隆对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deepClone(T t) throws IOException, ClassNotFoundException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(t);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
		return (T) ois.readObject();
	}

}
