package com.tech.cglibx;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

public class MyProxyFilter implements CallbackFilter {
	public int accept(final Method arg0) {
		if (!"query".equalsIgnoreCase(arg0.getName())) {
			return 0;
		}
		return 1;
	}
}
