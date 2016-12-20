package com.cucumber.driver.wait;

/**
 * 
 * @param <F>
 * 
 *      Wait implementation
 */
public interface Wait<F> {

	<T> T until(Function<? super F, T> isTrue);
}
