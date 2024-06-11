package crm.backend.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomErrorResponse {
	private int status;
	private String message;
	private String datetime;

	public CustomErrorResponse() {
	}

	public CustomErrorResponse(int status, String message, String datetime) {
		this.status = status;
		this.message = message;
		this.datetime = datetime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public static String now(String pattern) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
	}

	@Override
	public String toString() {
		return "StudentErrorResponse [status=" + status + ", message=" + message + ", datetime=" + datetime + "]";
	}
}
