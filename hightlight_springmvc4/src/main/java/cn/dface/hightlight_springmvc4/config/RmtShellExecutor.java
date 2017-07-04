package cn.dface.hightlight_springmvc4.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.trilead.ssh2.ChannelCondition;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;

@Configuration
@ComponentScan("cn.dface.hightlight_springmvc4.config")
@PropertySource("classpath:properties/test.properties")
public class RmtShellExecutor {
	private Connection conn;
	@Value("${ip}")
	private String ip;
	@Value("${usr}")
	private String usr;
	@Value("${password}")
	private String psword;
	private String charset = Charset.defaultCharset().toString();
	private static final int TIME_OUT = 1000 * 5 * 60;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {

	return new PropertySourcesPlaceholderConfigurer();

	}
	public RmtShellExecutor() {
		
	}

	private boolean login() throws IOException {
		conn = new Connection(ip);
		conn.connect();
		return conn.authenticateWithPassword(usr, psword);
	}

	public String exec(String cmds) throws IOException {
		InputStream stdOut = null;
		InputStream stdErr = null;
		String outStr = "";
		String outErr = "";
		int ret = -1;

		try {
			if (login()) {
				Session session = conn.openSession();
				session.execCommand(cmds);
				stdOut = new StreamGobbler(session.getStdout());
				outStr = processStream(stdOut, charset);
				stdErr = new StreamGobbler(session.getStderr());
				outErr = processStream(stdErr, charset);
				session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
				ret = session.getExitStatus();

			} else {
				throw new IOException("SSH2_ERR");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (stdOut != null)
				stdOut.close();
			if (stdErr != null)
				stdErr.close();
		}

		return outStr;
	}

	private String processStream(InputStream in, String charset) throws IOException {
		byte[] buf = new byte[1024];
		StringBuilder sb = new StringBuilder();
		while (in.read(buf) != -1) {
			sb.append(new String(buf, charset));
		}
		return sb.toString();
	}

}
