package cn.dface.java8.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
	public static void main(String[] args) {
		ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfo = threadMxBean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo2 : threadInfo) {
			System.out.println("线程ID："+threadInfo2.getThreadId()+"线程名称："+threadInfo2.getThreadName());
		}
		
	}
}
