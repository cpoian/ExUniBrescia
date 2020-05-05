package it.unibs.ing.fp.cuorisolitari;

public class CuoreSolitario {
	
	private String pseudonimo;
	private Sesso sesso;
	private int eta;
	private String segnoProprio;
	private String segnoIdeale;
	private static final int SOGLIA_ETA = 10;
	
	/****************************************************************************************************
	 * @isAffine																						*
	 * controlla l'affinità in base a 4 criteri:														*
	 * 1. @sesso 		---> deve essere diverso														*			
	 * 2. @eta   		---> la differenza in valore assoluto deve essere inferiore alla @SOGLIA_ETA	*
	 * 3. @segnoProprio ---> deve essere lo stesso del @segnoIdeale del altro @CuoreSolitario			*
	 * 4. @segnoIdeale  ---> deve essere lo stesso del @segnoProprio del altro @CuoreSolitario			*
	 * Devono essere tutte e 4 true per che l'affinità sia true											*		
	 ****************************************************************************************************/
	
	public boolean isAffine(CuoreSolitario pers) {
		
		if ((this.getSesso() != pers.getSesso()) && 
			(Math.abs(this.getEta() - pers.getEta()) <= SOGLIA_ETA) && 
			this.getSegnoProprio().equals(pers.getSegnoIdeale()) && 
			this.getSegnoIdeale().equals(pers.getSegnoProprio())) 
				return true;
		else
			return false;
	}
	
	

	public String toString(CuoreSolitario pers) {
		if (this.isAffine(pers))
			return this.getPseudonimo() + " è affine a " + pers.getPseudonimo();
		else
			return this.getPseudonimo() + " non è affine a " + pers.getPseudonimo();
	}

	/************************************************
	 * 						GETTERS					*
	 ************************************************/
	
	public String getPseudonimo() {
		return pseudonimo;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public int getEta() {
		return eta;
	}
	
	public String getSegnoProprio() {
		return segnoProprio;
	}


	public String getSegnoIdeale() {
		return segnoIdeale;
	}
	
	/************************************************
	 *						SETTERS					*
	 ************************************************/


	public void setPseudonimo(String _pseudonimo) {
		this.pseudonimo = _pseudonimo;
	}


	public void setSesso(Sesso _sesso) {
		this.sesso = _sesso;
	}


	public void setEta(int _eta) {
		this.eta = _eta;
	}


	public void setSegnoProprio(String _segnoProprio) {
		this.segnoProprio = _segnoProprio;
	}


	public void setSegnoIdeale(String _segnoIdeale) {
		this.segnoIdeale = _segnoIdeale;
	}
	

}
