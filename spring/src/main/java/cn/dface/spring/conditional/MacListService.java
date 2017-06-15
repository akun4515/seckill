package cn.dface.spring.conditional;

public class MacListService implements ListService {

	@Override
	public String showListCmd() {
		return "ls";
	}

}
