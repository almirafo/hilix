package br.com.hilix.test;

import br.com.hilix.entity.Module;
import br.com.hilix.service.module.ModuleService;

public class TestGroup {

	public static void main(String[] args) {

		Module module =  new Module();
		module.setNameModule("Grupo1");
		ModuleService moduleBean = new ModuleService();
		moduleBean.save(module);
		
		Module module1 = moduleBean.find(1);
		System.out.println(module1.getNameModule());
	}

}
