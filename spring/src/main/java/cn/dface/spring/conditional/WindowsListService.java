package cn.dface.spring.conditional;

public class WindowsListService implements ListService {

	@Override
	public String showListCmd() {
		
		return "dir";
	}

}
