package CyberWinPHP.Cyber_Structure;

public class Cyber_LocalStoreKeyValue {
    String key = "";
    String value="";
    public Cyber_LocalStoreKeyValue(String _key,String _value){
        this.key=_key;
        this.value=_value;
    }
    public String getKey() {
        return key;
    }
    public void setkey(String value) {
        this.key = key;
    }
    public String getVlaue() {
        return value;
    }
    public void setVlaue(String value) {
        this.value = value;
    }
}
