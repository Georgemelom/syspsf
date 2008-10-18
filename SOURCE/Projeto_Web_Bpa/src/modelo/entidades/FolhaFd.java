package modelo.entidades;


public class FolhaFd {
 
	private String foId;
	 
	private String foData;

	public synchronized String getFoId() {
		return foId;
	}

	public synchronized void setFoId(String foId) {
		this.foId = foId;
	}

	public synchronized String getFoData() {
		return foData;
	}

	public synchronized void setFoData(String foData) {
		this.foData = foData;
	}
	 
	
}
 
