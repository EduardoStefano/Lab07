package it.polito.tdp.poweroutages.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		//System.out.println(model.getNercList());
		System.out.print(model.listaBlackOut);
		model.calcolaSottoInsiemeBlackOut(8, 4, 200);
	}
}
