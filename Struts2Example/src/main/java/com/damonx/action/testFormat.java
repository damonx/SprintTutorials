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

import java.text.SimpleDateFormat;
import java.util.Date;

public class testFormat {

	public static void main(final String[] args) {
		//
		final String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		System.out.println(date);

	}

}
