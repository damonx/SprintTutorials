package com.mkyong.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.beans.BulkBean;
import net.sf.cglib.beans.ImmutableBean;
import net.sf.cglib.core.KeyFactory;

public class CglibTest {   
	@Test
	public void testBeanGenerator() throws Exception {
		BeanGenerator beanGenerator = new BeanGenerator();
		beanGenerator.addProperty("value", String.class);
		Object myBean = beanGenerator.create();

		Method setter = myBean.getClass().getMethod("setValue", String.class);
		setter.invoke(myBean, "Hello cglib!");
		Method getter = myBean.getClass().getMethod("getValue");
		assertThat(getter.invoke(myBean)).isEqualTo("Hello cglib!");
   
	}

	@Test(expected = IllegalStateException.class)
	public void testImmutableBean() throws Exception {
		SampleBean bean = new SampleBean();
		bean.setValue("Hello world!");
		SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean);
		assertEquals("Hello world!", immutableBean.getValue());
		bean.setValue("Hello world, again!");
		assertEquals("Hello world, again!", immutableBean.getValue());
		immutableBean.setValue("Hello cglib!"); // Causes exception.
	}

	@Test
	public void testBeanCopier() throws Exception {
		BeanCopier copier = BeanCopier.create(SampleBean.class, OtherSampleBean.class, false);
		SampleBean bean = new SampleBean();
		bean.setValue("Hello cglib!");
		OtherSampleBean otherBean = new OtherSampleBean();
		copier.copy(bean, otherBean, null);
		assertEquals("Hello cglib!", otherBean.getValue());
	}

	@Test
	public void testBulkBean() throws Exception {
		BulkBean bulkBean = BulkBean.create(SampleBean.class, new String[] { "getValue" }, new String[] { "setValue" },
				new Class[] { String.class });
		SampleBean bean = new SampleBean();
		bean.setValue("Hello world!");
		assertEquals(1, bulkBean.getPropertyValues(bean).length);
		assertEquals("Hello world!", bulkBean.getPropertyValues(bean)[0]);
		bulkBean.setPropertyValues(bean, new Object[] { "Hello cglib!" });
		assertEquals("Hello cglib!", bean.getValue());
	}

	@Test
	public void testBeanGeneratorMap() throws Exception {
		SampleBean bean = new SampleBean();
		BeanMap map = BeanMap.create(bean);
		bean.setValue("Hello cglib");
		assertEquals("Hello cglib", map.get("value"));
	}

	@Ignore("WIP")
	@Test
	public void testKeyFactory() throws Exception {
		SampleKeyFactory keyFactory = (SampleKeyFactory) KeyFactory.create(Key.class);
		Object key = keyFactory.newInstance("foo", 42);
		Map<Object, String> map = new HashMap<Object, String>();
		map.put(key, "Hello cglib!");
		assertEquals("Hello cglib!", map.get(keyFactory.newInstance("foo", 42)));
	}

}
