package CyberWinPHP.Cyber_Structure;

public class Cyber_ReturnMessage {
    String status;
    String message = "";
    String error_code="0";
    String detail="";
    String pram="";

public Cyber_ReturnMessage(String _status,String _message){
    this.status=_status;
    this.message=_message;
}

    public String getStatus() {
        return status;
    }
    public void setStatus(String value) {
        this.status = value;
    }
    public String getError_code() {
        return error_code;
    }
    public void setError_code(String value) {
        this.error_code = value;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String value) {
        this.detail = value;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String value) {
        this.message = value;
    }
}
