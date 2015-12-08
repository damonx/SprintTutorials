/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2015).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package com.tech.cglibx;

public class Client {

	public static void main(final String[] args) {
		final BookServiceBean service = BookServiceFactory.getInstance();
		doMethod(service);
		System.out.println("-----");
		doProxyMethod();
		System.out.println("-----");
		doProxyFilterMethod();
	}

	public static void doMethod(final BookServiceBean service) {
		service.create();
		service.update();
		service.query();
		service.delete();
	}

	public static void doProxyMethod() {
		final BookServiceBean service = BookServiceFactory.getProxyInstance(new MyCglibProxy("boss"));
		service.create();
		final BookServiceBean service2 = BookServiceFactory.getProxyInstance(new MyCglibProxy("john"));
		service2.create();
	}

	public static void doProxyFilterMethod() {
		final BookServiceBean service = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("damon"));
		service.create();
		final BookServiceBean service2 = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("damon"));
		service2.query();
	}
}
