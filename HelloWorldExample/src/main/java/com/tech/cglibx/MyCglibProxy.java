package com.tech.cglibx;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyCglibProxy implements MethodInterceptor {
	private final Logger log = Logger.getLogger(MyCglibProxy.class);
	public Enhancer enhancer = new Enhancer();
	private final String name;

	public MyCglibProxy(final String name) {
		this.name = name;
	}

	public Object intercept(final Object object, final Method method, final Object[] args,
			final MethodProxy methodProxy) throws Throwable {
		this.log.info("调用的方法是：" + method.getName());
		// 用户进行判断
		if (!"boss".equals(this.name)) {
			System.out.println("你没有权限！");
			return null;
		}
		final Object result = methodProxy.invokeSuper(object, args);

		return result;
	}

	/**
	 * 根据class对象创建该对象的代理对象 1、设置父类；2、设置回调 本质：动态创建了一个class对象的子类
	 *
	 * @param cls
	 * @return
	 */
	// public Object getDaoBean(final Class cls) {
	// this.enhancer.setSuperclass(cls);
	// this.enhancer.setCallback(this);
	// return this.enhancer.create();
	// }

}
