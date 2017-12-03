package joandev.fitforecast

import org.junit.Assert.assertEquals


/**
 * Created by Joan on 03/12/2017.
 */
infix fun <E> E.shouldBe(expected: E) = assertEquals(expected, this@shouldBe)
