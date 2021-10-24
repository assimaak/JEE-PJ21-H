package fil.sra.projet.web.dto;

public class SimpleResponse {
	
	public String message;
	public Status status = Status.OK;
	
	public enum Status {
		OK, ERROR
	}

	public String getMessage() {
		return message;
	}

	public Status getStatus() {
		return status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(Status status) {
		this.status = status;
	};
	

}
