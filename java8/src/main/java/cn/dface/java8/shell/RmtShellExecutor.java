package cn.dface.java8.shell;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.trilead.ssh2.ChannelCondition;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;

public class RmtShellExecutor {
	private Connection conn;
	private String ip;
	private String usr;
	private String psword;
	private String charset = Charset.defaultCharset().toString();
	private static final int TIME_OUT = 1000 * 5 * 60;

	public RmtShellExecutor(String ip, String usr, String ps) {
		this.ip = ip;
		this.usr = usr;
		this.psword = ps;
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

	public static void main(String[] args) {

		String usr = "dface";
		String password = "hello1234";
		String serverIP = "192.168.1.30";
		String shPath = "~/deploy_sh/go-admin.sh";

		RmtShellExecutor exe = new RmtShellExecutor(serverIP, usr, password);

		String outInf;

		try {
			outInf = exe.exec("sh " + shPath + " xn");
			System.out.println("outInf= " + outInf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
