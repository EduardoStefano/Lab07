package it.polito.tdp.poweroutages.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		//System.out.println(model.getNercList());
		System.out.print(model.calcolaSottoInsiemeBlackOut(3, 4, 50));
		
	}
}
