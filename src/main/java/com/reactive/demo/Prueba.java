package com.reactive.demo;

import java.util.Arrays;

public class Prueba {
	public static void main(String args[]) {
		Arrays.asList("Giovany", "Esteba", "Ferney", "Khate", "Damaso", "Cristian")
		.stream().sorted().forEach(System.out::println);
	}
}
