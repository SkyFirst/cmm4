package antlr;

/**
 * Created by 曾晖 on 2016/12/26.
 * 类型转换工具类
 */
public class Convey {

    /**
     * double 转 boolean
     * @param value
     * @return 布尔值
     */
    public static boolean double2Bool(double value){
        if(value-0.0<0.00001&&value-0.0>-0.00001) {
            return false;
        }
        return true;
    };
    public static  Double bool2Double(boolean value)
    {
        if(value)
            return 1.0;
        return 0.0;
    }



}
