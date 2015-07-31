package br.com.hilix.test;

import br.com.hilix.entity.Group;
import br.com.hilix.impl.group.GroupBean;

public class TestGroup {

	public static void main(String[] args) {
		GroupBean groupBean = new GroupBean();
		
		
		Group group = new Group();
		
		group.setNameGroup("ADMIN");
		groupBean.persistGroup(group);
		
	}

}
