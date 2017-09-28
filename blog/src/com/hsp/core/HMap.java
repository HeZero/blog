package com.hsp.core;

import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class HMap extends HashMap {

	/**
	 * 自动将页面数据放入PageData对象中,当从页面获取数据时 new的时候要传request
	 * request.getParameter(arg0): get(arg0)或getString(arg0)
	 * request.getParameterValues(arg0): getValues(arg0)方法
	 * 本类也可以当做一个普通的Map使用，new的时候不要传参数 
	 */
	private static final long serialVersionUID = 1L;
	Map map = null;
	HttpServletRequest request;

	// 从页面获取数据
	public HMap(HttpServletRequest request){
			map = new HashMap();
			this.request = request;
			Map requestParams = request.getParameterMap();
			Set<Map.Entry> entrySet = requestParams.entrySet();
			for (Map.Entry entry : entrySet) {
				String key = (String) entry.getKey();
				String[] values = (String[]) entry.getValue();
				String value;
				try {
					value = transParamDecode(values[0], "UTF-8");
					map.put(key, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	// 普通的Map
	public HMap() {
			map = new HashMap();
		}

	public Object get(Object key) {
		return map.get(key);
	}

	// 本方法只能用于从页面获取数组，例如相同名字的checkbox
	public String[] getValues(Object key) {
		return request == null ? null : request.getParameterValues((String) key);
	}

	public String getString(Object key) {
		Object o = get(key);
		return o == null ? null : o.toString();
	}

	public String getString(String name, String defaultValue) {
		String value = getString(name);
		return value == null ? defaultValue : value;
	}

	/**
	 * get names
	 * 
	 * @return String[]
	 */
	public String[] getNames() {
		String[] names = (String[]) keySet().toArray(new String[0]);
		Arrays.sort(names);
		return names;
	}

	/**
	 * get int
	 * 
	 * @param name
	 * @return int
	 */
	public int getInt(String name) {
		return getInt(name, 0);
	}

	/**
	 * get int
	 * 
	 * @param name
	 * @param defaultValue
	 * @return int
	 */
	public int getInt(String name, int defaultValue) {
		String value = getString(name, "");
		return "".equals(value) ? defaultValue : Integer.parseInt(value);
	}

	/**
	 * get double
	 * 
	 * @param name
	 * @return double
	 */
	public double getDouble(String name) {
		return getDouble(name, 0);
	}

	/**
	 * get double
	 * 
	 * @param name
	 * @param defaultValue
	 * @return double
	 */
	public double getDouble(String name, double defaultValue) {
		String value = getString(name, "");
		return "".equals(value) ? defaultValue : Double.parseDouble(value);
	}

	/**
	 * get boolean
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean getBoolean(String name) {
		return getBoolean(name, false);
	}

	/**
	 * get boolean
	 * 
	 * @param name
	 * @param defaultValue
	 * @return boolean
	 */
	public boolean getBoolean(String name, boolean defaultValue) {
		String value = getString(name, "");
		return "".equals(value) ? defaultValue : Boolean.valueOf(value).booleanValue();
	}

	@SuppressWarnings("unchecked")
	public Object put(Object key, Object value) {
		return map.put(key, value);
	}

	public Object remove(Object key) {
		return map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {

		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {

		return map.containsValue(value);
	}

	public Set entrySet() {

		return map.entrySet();
	}

	public boolean isEmpty() {

		return map.isEmpty();
	}

	public Set keySet() {

		return map.keySet();
	}

	@SuppressWarnings("unchecked")
	public void putAll(Map t) {

		map.putAll(t);
	}

	public int size() {

		return map.size();
	}

	public Collection values() {

		return map.values();
	}

	private static String transParamDecode(String param, String charset) throws Exception {
		if (param == null) {
			return null;
		}
		return URLDecoder.decode(param, charset);
	}

}
