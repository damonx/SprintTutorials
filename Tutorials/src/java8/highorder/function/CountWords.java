/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package java8.highorder.function;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class CountWords {

	public static void main(final String[] args) {
		long unitqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get("/Users/damonx/test.txt"), Charset.defaultCharset())) {
			unitqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
			System.out.println("word number: " + unitqueWords);
		} catch (final IOException e) {

		}

	}

}

