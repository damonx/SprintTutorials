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
package com.damonx.action;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.opensymphony.xwork2.Action;

public class UserActionTest {
	private UserAction userAction;

	@Before
	public void setUp() {
		this.userAction = new UserAction();
	}

	@Test
	public void testExcute() {
		final String result = this.userAction.execute();
		assertThat(result).isEqualTo(Action.SUCCESS);
	}

}
