package cn.dface.java8;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
	public String process(BufferedReader r) throws IOException ;
}
