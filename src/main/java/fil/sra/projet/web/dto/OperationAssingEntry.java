package fil.sra.projet.web.dto;

public class OperationAssingEntry {

	Long opId;
	long prodId;
	int value;

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

	public  int getValue(){
		return value;
	}

	public int setValue(int value){
		return this.value=value;
	}

}
