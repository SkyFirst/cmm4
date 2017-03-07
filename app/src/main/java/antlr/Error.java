package antlr;

/**
 * Created by lyk on 2016/12/28.
 */
public class Error {
    private int type;
    private String error;
    public final static int ERR = 0;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public final static int WARNING = 1;

    public String getStringType() {
        if(type==0)
            return "error ";
        return "warning ";
    }
}
