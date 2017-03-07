package antlr;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.example.lyk.cmm4.R;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by lyk on 2016/12/28.
 */
public class MycmmGrammarVisitor extends cmmGrammarBaseVisitor<Double> {

    private Map<String, MyToken> tokens = new HashMap<String, MyToken>();       //token集合
    private MyToken token;                                        //varstmt中声明的变量
    private int level = 0;                                        //作用域,每次遇到{＋1，}-1
    private String type = null;                                   //类型
    private List<Error> errors = new ArrayList<Error>();              //错误集合
    private String writeValue = null;                             //每次要写入的值
    private Stack<Boolean> isExperReal = new Stack<Boolean>();          //判断表达式是不是浮点型
    private boolean hasBreak = false;                             //是否遇到break
    private List<String> writeStmt = new ArrayList<>();           //统计write语句
    private Context mContext;
    private Stack<Boolean> isHasWhile = new Stack<Boolean>();        //检测break是否在break里面
    private View mParent;
    private Handler mHandler;                                     //线程切换
    private boolean isShow = true;                                  //阻止线程继续执行

    public MycmmGrammarVisitor(Context context, View parent, Handler handler) {
        mContext = context;
        mParent = parent;
        mHandler = handler;
    }

    //获得变量类型
    @Override
    public Double visitType(cmmGrammarParser.TypeContext ctx) {
        type = ctx.getText();
        return super.visitType(ctx);
    }

    //得到错误集合
    public List<Error> getErrors() {
        return errors;
    }

    //遍历（exper）时
    @Override
    public Double visitBraceEx(cmmGrammarParser.BraceExContext ctx) {
        Double value = visit(ctx.exper());
        return value;
    }

    //遍历到FALSE时返回0,0
    @Override
    public Double visitFalseEx(cmmGrammarParser.FalseExContext ctx) {
        return 0.0;
    }

    //遍历到乘除时
    @Override
    public Double visitMulDivEx(cmmGrammarParser.MulDivExContext ctx) {
        cmmGrammarParser.ExperContext left = ctx.exper(0);
        cmmGrammarParser.ExperContext right = ctx.exper(1);
        Double leftFactor = visit(left), rightFactor = visit(right);
        if (leftFactor == null || rightFactor == null)
            return null;
        switch (ctx.op.getType()) {
            case cmmGrammarParser.MUL:
                return leftFactor * rightFactor;
            case cmmGrammarParser.DIV:
                if (!Convey.double2Bool(rightFactor)) {
                    setError(getLineAndCharNum(right.start.getLine(), right.start.getCharPositionInLine()) + "divisor is zero", Error.ERR);
                    return null;
                }
                if (isExperReal.peek()) {
                    return leftFactor / rightFactor;
                }
                leftFactor = (leftFactor / rightFactor);
                return (double) leftFactor.intValue();

            case cmmGrammarParser.MOD:
                return leftFactor % rightFactor;

        }
        return null;
    }

    //遍历到字面实数
    @Override
    public Double visitRealEx(cmmGrammarParser.RealExContext ctx) {
        return Double.valueOf(ctx.LITERAL_REAL().getText());
    }

    //遍历到-exper
    @Override
    public Double visitMinusNumEx(cmmGrammarParser.MinusNumExContext ctx) {
        Double value = visit(ctx.exper());
        if (value == null)
            return null;
        return -1 * value;
    }

    //遍历到字面整数
    @Override
    public Double visitIntEx(cmmGrammarParser.IntExContext ctx) {
        return Double.valueOf(ctx.LITERAL_INT().getText());
    }

    //遍历到读值标识符时
    @Override
    public Double visitValueEx(cmmGrammarParser.ValueExContext ctx) {
        return visit(ctx.value());
    }

    //遍历到TRUE返回1.0
    @Override
    public Double visitTrueEx(cmmGrammarParser.TrueExContext ctx) {
        return 1.0;
    }

    //遍历到加减
    @Override
    public Double visitAddSubEx(cmmGrammarParser.AddSubExContext ctx) {
        cmmGrammarParser.ExperContext left = ctx.exper(0);
        cmmGrammarParser.ExperContext right = ctx.exper(1);
        Double leftFactor = visit(left), rightFactor = visit(right);
        if (leftFactor == null || rightFactor == null)
            return null;
        switch (ctx.op.getType()) {
            case cmmGrammarParser.PLUS:
                return leftFactor + rightFactor;
            case cmmGrammarParser.MINUS:
                return leftFactor - rightFactor;
        }
        return null;
    }

    //数组定义
    @Override
    public Double visitDefarray(cmmGrammarParser.DefarrayContext ctx) {
        if (hasBreak)
            return null;
        int line = ctx.array().ID().getSymbol().getLine();
        int position = ctx.array().ID().getSymbol().getCharPositionInLine();	
        /*
        *	检测是数组是否已定义
		*/
        if (tokens.containsKey(ctx.array().ID().getText() + " " + level)) {
            setError(getLineAndCharNum(line, position) + "the id " + ctx.array().ID() + " has been defined", Error.ERR);
            return null;
        }
        token = new MyToken();
        token.setType(type);
        token.setLevel(level);
        token.setLineNum(line);
        token.setCharNum(position);
        /*
		*
		*检测数组范围
		*数组范围不正确，将范围设定为0
		*/
        isExperReal.push(isExperHasDouble(ctx.array().exper(), level));
        Double d_bound = visit(ctx.array().exper());
        if (d_bound == null) {
            token.setRange(0);
            tokens.put(ctx.array().ID().getText() + " " + level, token);
            return null;
        }
        int bound = d_bound.intValue();
        if (isExperReal.peek()) {
            setError(getLineAndCharNum(line, position) + "the array " + ctx.array().ID().getText() + "'s bounds should be integer", Error.ERR);
            bound = 0;
        }

        if (bound < 0) {
            setError(getLineAndCharNum(line, position) + "the array " + ctx.array().ID().getText() + "'s bounds should >= 0", Error.ERR);
        }
        isExperReal.pop();
        token.setRange((bound = bound < 0 ? 0 : bound));
        cmmGrammarParser.ArrayValueContext arrayValueContext = ctx.arrayValue();
		/*
		*
		*检测数组是否有初值
		*/
        if (arrayValueContext != null) {
            int size = 0;
            if (arrayValueContext.exper(0) != null) {
                size = arrayValueContext.exper().size();
            }
            if (size > token.getRange()) {
                setError(getLineAndCharNum(line, position) + "the array " + ctx.array().ID().getText() + "'s index is out of bounds", Error.ERR);
            }
            int warnCount = 0;
            for (int i = 0; i < token.getRange(); i++) {
                cmmGrammarParser.ExperContext experContext = arrayValueContext.exper(i);
                if (experContext == null)
                    break;
                isExperReal.push(isExperHasDouble(experContext, level));
                Double arrayvalue = visit(experContext);
                if (arrayvalue == null)
                    continue;
                if (warnCount == 0 && token.getType().equals("int") && isExperReal.peek()) {
                    warnCount = 1;
                    setError(getLineAndCharNum(line, position) + "the array " + ctx.array().ID().getText() + " is integer", Error.WARNING);
                }
                if (token.getType().equals("int")) {
                    token.getArrayValue().put(i, arrayvalue.intValue() + "");
                } else
                    token.getArrayValue().put(i, arrayvalue.toString());
                isExperReal.pop();
            }
        }
        tokens.put(ctx.array().ID().getText() + " " + level, token);
        return null;
    }

    private String getLineAndCharNum(int line, int charnum) {
        return "line:" + line + " position:" + charnum + " ";
    }


    //assign:ID ('=' exper)?;
    @Override
    public Double visitAssign(cmmGrammarParser.AssignContext ctx) {
        if (hasBreak)
            return null;
        int line = ctx.ID().getSymbol().getLine();
        int position = ctx.ID().getSymbol().getCharPositionInLine();
        if (tokens.containsKey(ctx.ID().getText() + " " + level)) {
            setError(getLineAndCharNum(line, position) + "the id " + ctx.ID() + " has been defined", Error.ERR);
            return null;
        }
        token = new MyToken();
        token.setType(type);
        token.setLevel(level);
        token.setLineNum(line);
        token.setCharNum(position);
        if (ctx.exper() != null) {

            isExperReal.push(isExperHasDouble(ctx.exper(), level));
            Double value = visit(ctx.exper());
            if (value == null)
                return null;
            if (token.getType().equals("int") && isExperReal.peek()) {
                setError(getLineAndCharNum(line, position) + "the identifier " + ctx.ID().getText() + " is integer", Error.WARNING);
            }
            if (token.getType().equals("int")) {
                token.setValue(value.intValue() + "");
            } else
                token.setValue(value.toString());
            isExperReal.pop();

        }
        tokens.put(ctx.ID().getText() + " " + level, token);
        return null;
    }

    /*
    *
    *关系运算
    */
    @Override
    public Double visitCompareEx(cmmGrammarParser.CompareExContext ctx) {

        cmmGrammarParser.ExperContext left = ctx.exper(0);
        cmmGrammarParser.ExperContext right = ctx.exper(1);
        Double leftFactor = visit(left), rightFactor = visit(right);
        if (leftFactor == null || rightFactor == null)
            return null;
        switch (ctx.op.getType()) {
            case cmmGrammarParser.GT:
                return Convey.bool2Double(leftFactor.doubleValue() > rightFactor.doubleValue());
            case cmmGrammarParser.GET:
                return Convey.bool2Double(leftFactor.doubleValue() >= rightFactor.doubleValue());
            case cmmGrammarParser.LT:
                return Convey.bool2Double(leftFactor.doubleValue() < rightFactor.doubleValue());
            case cmmGrammarParser.LET:
                return Convey.bool2Double(leftFactor.doubleValue() <= rightFactor.doubleValue());
            case cmmGrammarParser.EQ:
                return Convey.bool2Double(leftFactor.doubleValue() == rightFactor.doubleValue());
            case cmmGrammarParser.NEQ:
                return Convey.bool2Double(leftFactor.doubleValue() != rightFactor.doubleValue());
        }
        return null;
    }

    /*
    *读值
    */
    @Override
    public Double visitValue(cmmGrammarParser.ValueContext ctx) {
        TerminalNode id;
        int lev;
        int line;
        int position;
        if (ctx.ID() != null) {
            id = ctx.ID();
            lev = isHasToken(id.getText(), level);
            line = id.getSymbol().getLine();
            position = id.getSymbol().getCharPositionInLine();
            if (lev >= 0) {
                String value = tokens.get(id.getText() + " " + lev).getValue();
                if (value == null)
                    return null;
                return Double.valueOf(value);
            } else {
                setError(getLineAndCharNum(line, position) + "the id " + id.getText() + " has not be defined", Error.ERR);
            }
            return null;
        }
        id = ctx.array().ID();
        lev = isHasToken(id.getText(), level);
        line = id.getSymbol().getLine();
        position = id.getSymbol().getCharPositionInLine();
        if (lev >= 0) {
            if (isExperHasDouble(ctx.array().exper(), level)) {
                setError(getLineAndCharNum(line, position) + "the array " + id.getText() + "'s index should be integer", Error.ERR);
                return null;
            } else {
                isExperReal.push(isExperHasDouble(ctx.array().exper(), level));
                int index = arrayIndexError(id.getText(), visit(ctx.array().exper()), line, position, tokens.get(id.getText() + " " + lev).getRange());
                isExperReal.pop();
                if (index >= 0) {
                    String value = (tokens.get(id.getText() + " " + lev).getArrayValue().get(index));
                    if (value == null)
                        return null;
                    return Double.valueOf(value);
                }
            }
        } else {
            setError(getLineAndCharNum(line, position) + "the array " + ctx.array().ID().getText() + " has not be defined", Error.ERR);
        }
        return null;
    }

    /*
      *  读值
      *  如果在命令行实现很简单
      *  但是android的话需要开线程
    */
    @Override
    public Double visitReadstmt(cmmGrammarParser.ReadstmtContext ctx) {

        if (hasBreak)
            return null;
        visit(ctx.writeValue());
        if (writeValue != null) {
            final MyToken myToken = tokens.get(writeValue);
            final int line = ctx.writeValue().start.getLine();
            final int position = ctx.writeValue().start.getCharPositionInLine();
            final List<Integer> arrayIndex = new ArrayList<>();
            if (ctx.writeValue().array() != null) {
                isExperReal.push(isExperHasDouble(ctx.writeValue().array().exper(), level));
                int index = arrayIndexError(ctx.writeValue().array().ID().getText(), visit(ctx.writeValue().array().exper()), line, position, myToken.getRange());
                isExperReal.pop();
                if (index < 0)
                    return null;
                arrayIndex.add(index);
            }
            isShow = true;
            final String writeText = arrayIndex.size() == 0 ? ctx.writeValue().ID().getText() : ctx.writeValue().array().ID().getText();
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    LayoutInflater layoutInflater = LayoutInflater.from(mContext);
                    final View contentView = layoutInflater.inflate(R.layout.popup_read, null);
                    final PopupWindow popupWindow = new PopupWindow(contentView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
                    popupWindow.setAnimationStyle(R.style.readPop);
                    popupWindow.setOutsideTouchable(false);
                    popupWindow.showAtLocation(mParent, Gravity.BOTTOM, 0, 0);
                    contentView.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String input = ((EditText) contentView.findViewById(R.id.read)).getText().toString();
                            if (myToken.getType().equals("int")) {
                                try {
                                    Integer.parseInt(input);
                                    if (arrayIndex.size() != 0)
                                        myToken.getArrayValue().put(arrayIndex.get(0), input);
                                    else
                                        myToken.setValue(input);
                                } catch (Exception e) {
                                    setError(getLineAndCharNum(line, position) + "the id " + writeText + " is integer", Error.ERR);
                                }
                            } else {
                                try {
                                    Double.parseDouble(input);
                                    if (arrayIndex.size() != 0)
                                        myToken.getArrayValue().put(arrayIndex.get(0), input);
                                    else
                                        myToken.setValue(input);
                                } catch (Exception e) {
                                    setError(getLineAndCharNum(line, position) + "the id " + writeText + " is real", Error.ERR);
                                }
                            }
                            popupWindow.dismiss();
                            isShow = false;
                        }
                    });
                }
            });
            while (isShow) ;

        }
        return null;
    }


    //获得输出值
    public List<String> getWriteStmt() {
        return writeStmt;
    }

    //遍历write语句
    @Override
    public Double visitWritestmt(cmmGrammarParser.WritestmtContext ctx) {
        if (hasBreak)
            return null;
        isExperReal.push(isExperHasDouble(ctx.exper(), level));
        Double value = visit(ctx.exper());
        if (value == null)
            return null;
        //判断输出语句是int or real
        if (isExperReal.peek()) {
            writeStmt.add(value.toString());

        } else
            writeStmt.add(value.intValue() + "");
        isExperReal.pop();
        return null;
    }

    //遍历write标识符看write标识符是否合法以及定义
    @Override
    public Double visitWriteValue(cmmGrammarParser.WriteValueContext ctx) {
        writeValue = null;
        if (ctx.array() != null) {
            cmmGrammarParser.ArrayContext arrayContext = ctx.array();
            int line = arrayContext.ID().getSymbol().getLine();
            int position = arrayContext.ID().getSymbol().getCharPositionInLine();
            int lev = isHasToken(arrayContext.ID().getText(), level);
            if (lev >= 0) {
                if (isExperHasDouble(arrayContext.exper(), level)) {
                    setError(getLineAndCharNum(line, position) + "the array " + arrayContext.ID().getText() + "'s index should be integer", Error.ERR);
                    return null;
                } else
                    writeValue = (arrayContext.ID().getText() + " " + lev);
            } else {
                setError(getLineAndCharNum(arrayContext.ID().getSymbol().getLine(), arrayContext.ID().getSymbol().getCharPositionInLine()) + "the array " + arrayContext.ID().getText() + " has not be defined", Error.ERR);
            }
        } else if (ctx.ID() != null) {
            int line = ctx.ID().getSymbol().getLine();
            int position = ctx.ID().getSymbol().getCharPositionInLine();
            int lev = isHasToken(ctx.ID().getText(), level);
            if (lev >= 0) {
                writeValue = (ctx.ID().getText() + " " + lev);
            } else {
                setError(getLineAndCharNum(ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine()) + "the id " + ctx.ID().getText() + " has not be defined", Error.ERR);
            }
        }
        return null;

    }

    //遍历赋值语句
    @Override
    public Double visitAssignstmt(cmmGrammarParser.AssignstmtContext ctx) {
        if (hasBreak)
            return null;
        //检测id的合法性
        visit(ctx.writeValue());
        if (writeValue != null) {
            if (ctx.writeValue().array() != null) {
                cmmGrammarParser.ArrayContext arrayContext = ctx.writeValue().array();
                int line = arrayContext.ID().getSymbol().getLine();
                int position = arrayContext.ID().getSymbol().getCharPositionInLine();
                MyToken current = tokens.get(writeValue);
                isExperReal.push(isExperHasDouble(arrayContext.exper(), level));
                int index = arrayIndexError(arrayContext.ID().getText(), visit(arrayContext.exper()), line, position, current.getRange());
                isExperReal.pop();
                if (index >= 0) {
                    isExperReal.push(isExperHasDouble(ctx.exper(), level));
                    Double value = visit(ctx.exper());
                    isExperReal.pop();
                    if (value == null)
                        return null;
                    if (current.getType().equals("int") && isExperHasDouble(ctx.exper(), level)) {
                        setError(getLineAndCharNum(line, position) + "the array " + arrayContext.ID().getText() + " is integer", Error.WARNING);
                        current.getArrayValue().put(index, value.intValue() + "");
                    } else if (current.getType().equals("int")) {
                        current.getArrayValue().put(index, value.intValue() + "");
                    } else
                        current.getArrayValue().put(index, value.toString());

                }
            } else {
                int line = ctx.writeValue().ID().getSymbol().getLine();
                int position = ctx.writeValue().ID().getSymbol().getCharPositionInLine();
                MyToken current = tokens.get(writeValue);
                isExperReal.push(isExperHasDouble(ctx.exper(), level));
                Double value = visit(ctx.exper());
                isExperReal.pop();
                if (value == null)
                    return null;
                if (current.getType().equals("int") && isExperHasDouble(ctx.exper(), level)) {
                    setError(getLineAndCharNum(line, position) + "the array " + ctx.writeValue().ID().getText() + " is integer", Error.WARNING);
                    current.setValue(value.intValue() + "");
                } else if (current.getType().equals("int")) {
                    current.setValue(value.intValue() + "");
                } else
                    current.setValue(value.toString());

            }

        }

        return null;
    }

    //遇到}level-1
    @Override
    public Double visitRbrace(cmmGrammarParser.RbraceContext ctx) {
        level--;
        return super.visitRbrace(ctx);
    }

    //遇到{level+1
    @Override
    public Double visitLbrace(cmmGrammarParser.LbraceContext ctx) {
        level++;
        return super.visitLbrace(ctx);
    }

    //用来判断是否含有token
    private int isHasToken(String token, int level) {
        while (level >= 0) {
            if (tokens.containsKey(token + " " + level))
                return level;
            level--;
        }
        return level;
    }

    //检测数组索引是否正确如越界以及是否小于0
    private int arrayIndexError(String text, Double index, int line, int position, int bouns) {
        if (index == null)
            return -1;
        int index2 = index.intValue();
        if (index2 < 0) {
            setError(getLineAndCharNum(line, position) + "the array " + text + "'s index should >=0", Error.ERR);
            return index2;
        }
        if (index2 >= bouns) {
            setError(getLineAndCharNum(line, position) + "the array " + text + "'s index is out of bounds", Error.ERR);
            return -1;
        }
        return index2;
    }

    /*
    *
    *
    *检测表达式是否是real类型
    *使用了递归
    *
    *
    * */
    private boolean isExperHasDouble(cmmGrammarParser.ExperContext ctx, int level) {
        if (ctx.getText().contains("."))
            return true;
        boolean has = false;
        try {
            if (ctx.getChildCount() == 1) {
                if (ctx.getChild(0).getClass().getName().equals(cmmGrammarParser.ValueContext.class.getName())) {
                    TerminalNode value = null;
                    if (((cmmGrammarParser.ValueContext) ctx.getChild(0)).array() != null) {
                        value = ((cmmGrammarParser.ValueContext) ctx.getChild(0)).array().ID();
                    } else {
                        value = ((cmmGrammarParser.ValueContext) ctx.getChild(0)).ID();
                    }
                    int index = isHasToken(value.getText(), level);
                    if (index >= 0) {
                        if (tokens.get(value.getText() + " " + index).getType().equals("real")) {
                            return true;
                        }
                    }

                } else if (ctx.getChild(0).getClass().getName().equals(cmmGrammarParser.ExperContext.class.getName())) {
                    has = isExperHasDouble((cmmGrammarParser.ExperContext) ctx.getChild(0), level);
                    if (has)
                        return has;
                }
            } else {
                has = isExperHasDouble((cmmGrammarParser.ExperContext) ctx.getChild(0), level);
                if (has)
                    return has;
                has = isExperHasDouble((cmmGrammarParser.ExperContext) ctx.getChild(2), level);
                if (has)
                    return has;
            }
        } catch (Exception e) {

        }

        return has;

    }

    private void setError(String err, int type) {
        Error error = new Error();
        error.setType(type);
        error.setError(err);
        errors.add(error);
    }

    //遍历break语句
    @Override
    public Double visitBreakstmt(cmmGrammarParser.BreakstmtContext ctx) {
        //break语句必须在white中
        if (isHasWhile.size() == 0) {
            setError(getLineAndCharNum(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()) + "break must be in while", Error.ERR);
            return null;
        }
        hasBreak = true;
        return super.visitBreakstmt(ctx);
    }

    //遍历while语句
    @Override
    public Double visitWhilestmt(cmmGrammarParser.WhilestmtContext ctx) {
        //检测是否有break
        if (hasBreak)
            return null;
        /*
        * 条件判断
        * 是否有{}
        * 清除while块中的变量
        *
        * */
        isExperReal.push(isExperHasDouble(ctx.exper(), level));
        Double condition = visit(ctx.exper());
        isExperReal.pop();
        if (condition == null)
            return null;
        boolean hasBlock = ctx.stmt().stmtblock() != null;
        if (!hasBlock)
            level++;
        while (Convey.double2Bool(condition)) {
            Object[] keyset = tokens.keySet().toArray();
            for (int j = 0; j < keyset.length; j++) {
                if (!hasBlock) {
                    if (tokens.get(keyset[j]).getLevel() >= level)
                        tokens.remove(keyset[j]);
                } else {
                    if (tokens.get(keyset[j]).getLevel() >= (level + 1))
                        tokens.remove(keyset[j]);
                }

            }
            isHasWhile.push(true);
            visit(ctx.stmt());
            isHasWhile.pop();
            if (hasBreak) {
                hasBreak = false;
                break;
            }
            isExperReal.add(isExperHasDouble(ctx.exper(), level));
            condition = visit(ctx.exper());
            isExperReal.pop();
            if (condition == null)
                break;

        }
        if (!hasBlock)
            level--;
        return null;
    }

    /*
    *
    *遍历if语句
    *
    *
    */

    @Override
    public Double visitIfstmt(cmmGrammarParser.IfstmtContext ctx) {
        //检测是否有break
        if (hasBreak)
            return null;
        int conditionSize = ctx.LPARENT().size();
        Double condition;
        boolean requirement = false;
        /*
        * 选择true的条件执行
        * 注意是否有{}
        * 执行结束之后清除存储的变量
        *
        * */
        for (int i = 0; i < conditionSize; i++) {
            isExperReal.push(isExperHasDouble(ctx.exper(i), level));
            condition = visit(ctx.exper(i));
            isExperReal.pop();
            if (condition == null)
                continue;
            requirement = Convey.double2Bool(condition);
            if (requirement) {
                if (ctx.stmt(i).stmtblock() == null) {
                    level++;
                }
                visit(ctx.stmt(i));
                Object[] keyset = tokens.keySet().toArray();
                for (int j = 0; j < keyset.length; j++) {
                    if (ctx.stmt(i).stmtblock() == null) {
                        if (tokens.get(keyset[j]).getLevel() >= level)
                            tokens.remove(keyset[j]);
                    } else {
                        if (tokens.get(keyset[j]).getLevel() >= (level + 1))
                            tokens.remove(keyset[j]);
                    }

                }
                if (ctx.stmt(i).stmtblock() == null) {
                    level--;
                }
                return null;
            }

        }
        //else 语句的执行
        if (ctx.stmt(conditionSize) != null) {
            if (ctx.stmt(conditionSize).stmtblock() == null) {
                level++;
            }
            visit(ctx.stmt(conditionSize));
            Object[] keyset = tokens.keySet().toArray();
            for (int j = 0; j < keyset.length; j++) {
                if (ctx.stmt(conditionSize).stmtblock() == null) {
                    if (tokens.get(keyset[j]).getLevel() >= level)
                        tokens.remove(keyset[j]);
                } else {
                    if (tokens.get(keyset[j]).getLevel() >= (level + 1))
                        tokens.remove(keyset[j]);
                }

            }
            if (ctx.stmt(conditionSize).stmtblock() == null) {
                level--;
            }
        }
        return null;
    }
}
