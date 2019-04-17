package it.polito.tdp.poweroutages.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {
	
	private List<BlackOut> best;

	PowerOutageDAO podao;
	public List<BlackOut> listaBlackOut;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<BlackOut> calcolaSottoInsiemeBlackOut(int nerc, int maxYears, int maxHours){
		listaBlackOut = podao.ritornaBlackOut(nerc);
		best=null;
		List<BlackOut> parziale = new LinkedList<>();
		cerca(parziale, 0, maxYears, maxHours);
		return best;
	}
	
	public void cerca(List<BlackOut> parziale, int L, int maxYears, long maxHours) {
		
		if(numeroTotPersone(parziale)>numeroTotPersone(best)) {
			best = new LinkedList<BlackOut>(parziale);
			//return;
		}
		
		//algoritmo
		for(int i=L; i<=listaBlackOut.size(); i++) {
			if(parziale.size()==0) {
				parziale.add(listaBlackOut.get(i));
				cerca(parziale, L+1, maxYears, maxHours);
				parziale.remove(i-1);
			}
			else {
				if((durataParzialeOre(parziale))<maxHours) {
					if((parziale.get(0).getAnno()-listaBlackOut.get(i).getAnno())<=maxYears) {
						if(verifica(parziale, best)) {
							parziale.add(listaBlackOut.get(i));
							cerca(parziale, L+1, maxYears, maxHours);
							parziale.remove(i-1);	
						}
					}
				}
			}
		}
	}

	public int numeroTotPersone(List<BlackOut> lista){
		if(lista==null)
			return 0;
		if(lista.size()==0)
			return 0;
		int personeCoinvolte=0;
		for(BlackOut btemp:lista) {
			personeCoinvolte+=btemp.getCustomerAffected();
		}
		return personeCoinvolte;
	}
	
	public int durataParzialeOre(List<BlackOut> parziale) {
		if(parziale==null)
			return 0;
		int somma=0;
		if(parziale.size()==0)
			return 0;
		for(BlackOut btemp:parziale) {
			somma+=btemp.ritornaDurata();
		}
		return somma;
	}
	
	public boolean verifica(List<BlackOut> parziale, List<BlackOut> best) {
		if(parziale==null || best==null)
			return true;
		for(int i=0; i<parziale.size(); i++) {
			
		}
		return true;
	}
	

}
