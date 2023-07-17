package com.example.calculatorediting;
import androidx.appcompat.app.AppCompatActivity;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    static double result;
    static char op;
    static String delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText e =(EditText)findViewById(R.id.et);
        final TextView t = (TextView)findViewById(R.id.textView);
        Button b1=(Button)findViewById(R.id.b1);
        Button b2=(Button)findViewById(R.id.b2);
        Button b3=(Button)findViewById(R.id.b3);
        Button b4=(Button)findViewById(R.id.b4);
        Button b5=(Button)findViewById(R.id.b5);
        Button b6=(Button)findViewById(R.id.b6);
        Button b7=(Button)findViewById(R.id.b7);
        Button b8=(Button)findViewById(R.id.b8);
        Button b9=(Button)findViewById(R.id.b9);
        Button b0=(Button)findViewById(R.id.b0);
        Button be=(Button)findViewById(R.id.be);
        Button bp=(Button)findViewById(R.id.bp);
        Button bs=(Button)findViewById(R.id.bs);
        Button bm=(Button)findViewById(R.id.bm);
        Button bd=(Button)findViewById(R.id.bd);
        Button bc=(Button)findViewById(R.id.bc);
        Button bdot = (Button)findViewById(R.id.bdot);
        Button bper = (Button) findViewById(R.id.bper);
        Button bdel = (Button) findViewById(R.id.del);
        Button bmode = (Button) findViewById(R.id.mode);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
            e.setShowSoftInputOnFocus(false);
        } else { // API 11-20
            e.setTextIsSelectable(true);
        }

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(!(e.getText().toString().equals(""))) {
                    e.setText(String.valueOf(e.getText().toString() + 0));
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(e.getText().toString()+1));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(e.getText().toString()+2));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(e.getText().toString()+3));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(e.getText().toString()+4));
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(e.getText().toString()+5));
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(e.getText().toString()+6));
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(e.getText().toString()+7));
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(e.getText().toString()+8));
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(e.getText().toString()+9));
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                e.setText(String.valueOf(""));
                t.setText(String.valueOf(""));
            }
        });
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                op='+';
                result=Double.parseDouble(e.getText().toString());
                e.setText(String.valueOf(""));
            }
        });
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                op='-';
                result=Double.parseDouble(e.getText().toString());
                e.setText(String.valueOf(""));
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                op='*';
                result=Double.parseDouble(e.getText().toString());
                e.setText(String.valueOf(""));

            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                op='/';
                result=Double.parseDouble(e.getText().toString());
                e.setText(String.valueOf(""));
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.setText(e.getText().toString() + ".");
            }
        });
        bper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op='%';
                result=Double.parseDouble(e.getText().toString());
                e.setText(String.valueOf(""));
            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op='D';
                if (e.getText().toString()== null){
                    e.setText(" ");
                }
                else  {
                    delete = e.getText().toString();
                    StringBuffer sb = new StringBuffer(delete);
                    sb.deleteCharAt(sb.length() - 1);
                    e.setText(sb);
                }

            }
        });
        bmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(op=='+')
                {
                    double n=Double.parseDouble(e.getText().toString());
                    t.setText(String.valueOf(result+n));
                }
                else if (op=='-')
                {
                    double n=Double.parseDouble(e.getText().toString());
                    t.setText(String.valueOf(result-n));
                }
                else if (op=='*')
                {
                    double n=Double.parseDouble(e.getText().toString());
                    t.setText(String.valueOf(result*n));
                }
                else if (op== '%'){
                    double n=Double.parseDouble(e.getText().toString());
                    t.setText(String.valueOf(result*n/100));
                }
                else
                {
                    double n=Double.parseDouble(e.getText().toString());
                    t.setText(String.valueOf(result/n));

                }

            }
        });


    }
}
