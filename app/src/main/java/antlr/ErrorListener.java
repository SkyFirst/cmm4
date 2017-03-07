package antlr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2016/11/17.
 */
public class ErrorListener extends BaseErrorListener {
    private List<Error> errors=new ArrayList<>();

    public List<Error> getErrors() {
        return errors;
    }

    @Override public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        super.syntaxError(recognizer,offendingSymbol,line,charPositionInLine,msg,e);
        Error error=new Error();
        error.setError("line:"+line+" position:"+charPositionInLine+" "+msg);
        error.setType(Error.ERR);
        errors.add(error);

    }

}
