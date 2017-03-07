package antlr;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 曾晖 on 2016/12/26.
 */
public class MyToken {
    private String type;//类型
    private String value;//值（Double\布尔等用包装类转换）
    private int level;//嵌套级别
    private boolean isDefined;//是否被定义
    private int lineNum;//行号
    private int charNum;
    private Map<Integer,String> arrayValue=new HashMap<Integer, String>();
    private int range;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Map<Integer, String> getArrayValue() {

        return arrayValue;
    }

    public int getCharNum() {

        return charNum;
    }

    public void setCharNum(int charNum) {
        this.charNum = charNum;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isDefined() {
        return isDefined;
    }

    public void setDefined(boolean isDefined) {
        this.isDefined = isDefined;
    }


}
