package com.example.lyk.cmm4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import antlr.Error;
import antlr.ErrorListener;
import antlr.LexerError;
import antlr.MycmmGrammarVisitor;
import antlr.cmmGrammarLexer;
import antlr.cmmGrammarParser;

import static com.example.lyk.cmm4.R.id.result;
import static com.example.lyk.cmm4.R.id.toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private EditText mContent;
    private View mDivider;
    private View mNavigation;
    private ScrollView mScrollView;
    private TextView mLine;
    private final static int REQUEST_FILE = 1;
    private String path = null;
    private final int COLOR_KEY = R.color.colorPrimary;
    private Handler mHandler = new Handler();
    private int lineCount = 0;
    private boolean endAnimation = true;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(charSequence.toString().length()==0)
                return;
            mContent.removeTextChangedListener(textWatcher);
            char ch;
            if(charSequence.length()==i)
            {
                ch=charSequence.toString().charAt(i-1);
            }else
                ch =charSequence.toString().charAt(i);
            if ((ch=='['||ch=='{')&& i2 != 0) {
                StringBuffer stringBuffer=new StringBuffer(charSequence);
                if(stringBuffer.length()-1==i) {
                    if(ch=='[')
                        stringBuffer.append(']');
                    else
                        stringBuffer.append('}');
                }
                else {
                    if(ch=='[')
                        stringBuffer.insert(i + 1, ']');
                    else
                        stringBuffer.insert(i+1,'}');
                }
                changeTextColor(stringBuffer.toString(), i + i2);
            } else changeTextColor(charSequence.toString(), i + i2);
            if (lineCount != mContent.getLineCount()) {
                lineCount = mContent.getLineCount();
                setLine(lineCount);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(toolbar);
        mToolbar.setLogo(R.mipmap.logo2);
        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/cmm";
        File file = new File(path);
        if (!file.exists())
            file.mkdirs();
        mToolbar.setTitle(" " + path);
        setSupportActionBar(mToolbar);
        int screenHeight = getWindowManager().getDefaultDisplay().getHeight() - Setting.dip2px(this, 160);
        mContent = (EditText) findViewById(R.id.content);
        mContent.addTextChangedListener(textWatcher);
        mContent.setMinHeight(screenHeight);
        mScrollView = (ScrollView) findViewById(R.id.scroll);
        mLine = (TextView) findViewById(R.id.line);
        mLine.setMinHeight(screenHeight);
        mDivider = findViewById(R.id.divider);
        setLine(lineCount);
        findViewById(R.id.newFile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContent.setText("");
                path = Environment.getExternalStorageDirectory() + "/cmm";
                mToolbar.setTitle(" " + path);
            }
        });
        findViewById(R.id.saveFile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
        findViewById(R.id.complieFile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                complie();
            }
        });
        findViewById(R.id.openFile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFile();
            }
        });
        findViewById(R.id.setFile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set();
            }
        });
        mNavigation = findViewById(R.id.navigation);
       /* findViewById(R.id.layoutListner).addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                if (i7 != 0 && i3 != 0 && (i7 - i3 > 1000)) {
                    if (((LinearLayout)view).getChildCount()==2) {
                        (((LinearLayout)view)).removeViewAt(1);
                    }
                } else if (i7 != 0 && i3 != 0 && (i3 - i7 > 1000)) {
                    if (((LinearLayout)view).getChildCount()==1) {
                        (((LinearLayout)view)).addView(mNavigation);
                    }
                }
            }
        });*/
        //mTimer.schedule(new MyTask(),0,10);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (NoSuchMethodException e) {
                } catch (Exception e) {
                }
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.complier, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.file:
                openFile();
                break;
            case R.id.complie:
                complie();
                break;
            case R.id.newFile:
                mContent.setText("");
                break;
            case R.id.setting:
                set();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");//设置类型，
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_FILE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            path = uri.getPath();
            if (path == null) {
                Toast.makeText(MainActivity.this, "打开文件失败", Toast.LENGTH_SHORT).show();
            } else {
                String content = getFileContent();
                if (content != null) {
                    mContent.setText(content);
                }
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private String getFileContent() {
        try {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
            int size = fileInputStream.available();
            char[] con = new char[size];
            inputStreamReader.read(con);
            String content = new String(con, 0, con.length);
            inputStreamReader.close();
            fileInputStream.close();
            mToolbar.setTitle(" " + path);
            return content;
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "打开文件失败", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    private Error parseComment(String content) {
        boolean error = false;
        int errLine = 1, errPos = 0, position = 0, line = 1;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '\n') {
                line++;
                position = 0;
                continue;
            }
            if (i < content.length() - 1 && content.charAt(i) == '/' && content.charAt(i + 1) == '*') {
                errLine = line;
                errPos = position;
                error = true;

            }
            if (error) {
                if ((i < content.length() - 1 && content.charAt(i) == '*' && content.charAt(i + 1) == '/') && content.charAt(i - 1) != '/') {
                    error = false;
                }
            }
            position++;
        }
        if (error) {
            Error err = new Error();
            err.setType(Error.ERR);
            err.setError("line:" + errLine + " position:" + errPos + " /* must be matched with */");
            return err;
        }
        return null;
    }

    private void complie() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ANTLRInputStream input = new ANTLRInputStream(mContent.getText().toString());
                cmmGrammarLexer lexer = new cmmGrammarLexer(input);
                LexerError lexerError = new LexerError();
                lexer.removeErrorListeners();
                lexer.addErrorListener(lexerError);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                cmmGrammarParser parser = new cmmGrammarParser(tokens);
                parser.removeErrorListeners();
                final ErrorListener errorListener = new ErrorListener();
                parser.addErrorListener(errorListener);
                ParseTree tree = parser.prog();
                Error commentError = parseComment(mContent.getText().toString());
                final List<Error> allErrors = new ArrayList<>();
                allErrors.addAll(lexerError.getErrors());
                if (commentError != null)
                    allErrors.add(commentError);
                allErrors.addAll(errorListener.getErrors());
                if (!allErrors.isEmpty()) {
                    mScrollView.scrollTo(mScrollView.getScrollX(), (int) mScrollView.getY());
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            showResult(allErrors);
                        }
                    });
                    return;
                }
                MycmmGrammarVisitor mycmmGrammarVisitor = new MycmmGrammarVisitor(MainActivity.this, mScrollView, mHandler);
                mycmmGrammarVisitor.visit(tree);
                final List<Error> errors = mycmmGrammarVisitor.getErrors();
                if (errors.size() != 0) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            showResult(errors);
                        }
                    });

                } else {
                    final List<String> writestmt = mycmmGrammarVisitor.getWriteStmt();
                    final int size = writestmt.size();
                    if (size == 0)
                        return;
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            String result = "";
                            for (int i = 0; i < size; i++) {
                                result = result + (writestmt.get(i) + "\n");
                            }
                            showTrueReuslt(result);
                        }
                    });

                }
            }
        }).start();


    }


    private void changeTextColor(String content, int pos) {
        String[] keywords = new String[]{"int", "real", "while", "if", "else", "break", "read", "write"};
        SpannableString spannableString = new SpannableString(content);
        int fromIndex = 0;
        while (true) {
            int index = -1;//关键字索引值
            int temp = -1;
            //起始查找位置
            int keywordsIndex = 0;
            for (int i = 0; i < keywords.length; i++) {
                if ((temp = content.indexOf(keywords[i], fromIndex)) != -1) {
                    boolean front = (temp >= 1 && isKey(content.charAt(temp - 1))) || temp == 0;
                    boolean back = (temp + keywords[i].length() - 1 <= content.length() - 2 && isKey(content.charAt(temp + keywords[i].length()))) || temp == content.length() - 1;
                    if (front && back && (index == -1 || temp < index)) {
                        index = temp;
                        keywordsIndex = i;
                    }
                }
            }
            if (index != -1) {
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(COLOR_KEY)), index, index + keywords[keywordsIndex].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                fromIndex = index + keywords[keywordsIndex].length();
                if (fromIndex == content.length())
                    break;
            } else
                break;

        }
        mContent.setText(spannableString);
        mContent.setSelection(pos);
        mContent.addTextChangedListener(textWatcher);
    }

    private boolean isKey(char front) {
        if (front == '_' || (front >= '0' && front <= '9') || (front >= 'a' && front <= 'z') || (front >= 'A' && front <= 'Z'))
            return false;
        return true;
    }

    private void setLine(int count) {
        if (count == 0)
            return;
        String content = "";
        for (int i = 1; i <= count; i++) {
            content = content + i + "\n";
        }
        mLine.setText(content.substring(0, content.length() - 1));
    }

    private void set() {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    private void save() {
        String dirpath = Environment.getExternalStorageDirectory() + "/cmm";
        String path = dirpath + "/" + System.currentTimeMillis() + ".cmm";
        File dir = new File(dirpath);
        if (!dir.exists())
            dir.mkdirs();
        File outfile = new File(path);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outfile);
            fileOutputStream.write(mContent.getText().toString().getBytes("gbk"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "保存成功,文件路径 " + path, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */

        switch (Setting.getScreenOriention(MainActivity.this)) {
            case 0:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            case 1:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
        }
        int color = getResources().getColor(Setting.themes[Setting.getTheme(MainActivity.this)]);
        mContent.setBackgroundColor(color);
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, Setting.getTextSize(MainActivity.this));
        mLine.setBackgroundColor(color);
        mScrollView.setBackgroundColor(color);
        mLine.setTextSize(TypedValue.COMPLEX_UNIT_SP, Setting.getTextSize(MainActivity.this));
        mDivider.setBackgroundColor(getResources().getColor(Setting.themes[Setting.getDivider(MainActivity.this)]));
        super.onResume();
    }

    private void showResult(final List<Error> errors) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.complie_result, null);
        view.findViewById(R.id.error_select).setVisibility(View.VISIBLE);
        final Button button = (Button) view.findViewById(R.id.level);
        button.setTag(2);
        final TextView res = ((TextView) view.findViewById(result));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!endAnimation)
                    return;
                endAnimation = false;
                int index = (Integer) view.getTag();
                int type = 2;
                ObjectAnimator objectAnimator = null;
                switch (index) {
                    case 0:
                    case 1:
                        objectAnimator = ObjectAnimator.ofFloat(view, "x", view.getX() + view.getWidth());
                        view.setTag((Integer) view.getTag() + 1);
                        if (index == 0)
                            type = Error.ERR;
                        else
                            type = 2;
                        break;
                    case 2:
                        objectAnimator = ObjectAnimator.ofFloat(view, "x", view.getX() - view.getWidth() * 2);
                        view.setTag(0);
                        type = Error.WARNING;
                        break;
                }
                objectAnimator.setDuration(500);
                objectAnimator.start();
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        endAnimation = true;
                        super.onAnimationEnd(animation);
                    }
                });
                res.setText("");
                for (int i = 0; i < errors.size(); i++) {
                    if (errors.get(i).getType() == type || type == 2) {
                        res.append(errors.get(i).getStringType() + errors.get(i).getError() + "\n");
                    }
                }
            }
        });
        view.setBackgroundColor(getResources().getColor(Setting.themes[Setting.getTheme(this)]));
        for (int i = 0; i < errors.size(); i++) {
            res.append(errors.get(i).getStringType() + errors.get(i).getError() + "\n");
        }
        final PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, Setting.dip2px(MainActivity.this, 200));
        popupWindow.setAnimationStyle(R.style.resultPop);
        view.findViewById(R.id.cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(findViewById(R.id.activity_main), Gravity.BOTTOM, 0, 0);
    }

    private void showTrueReuslt(String resul) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.complie_result, null);
        ((TextView) view.findViewById(result)).setText(resul);
        view.setBackgroundColor(getResources().getColor(Setting.themes[Setting.getTheme(this)]));
        final PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, Setting.dip2px(MainActivity.this, 200));
        popupWindow.setAnimationStyle(R.style.resultPop);
        view.findViewById(R.id.cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(findViewById(R.id.activity_main), Gravity.BOTTOM, 0, 0);
    }
}
