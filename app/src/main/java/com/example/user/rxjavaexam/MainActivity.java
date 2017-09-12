package com.example.user.rxjavaexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.value_EditText)
    EditText value_ET;

    @BindView(R.id.opration_Button)
    Button oprationButton;

    @BindView(R.id.result_TextView)
    TextView result_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        oprationButton.setOnClickListener(v -> oprationButtonClick());
    }

    private void oprationButtonClick() {
        String value = value_ET.getText().toString();
//        String result = notApplyRxOpration(Integer.parseInt(value));
//        result_TV.setText(result);
//
        applyRxOpration(Integer.parseInt(value));
    }

    private String notApplyRxOpration(int value){
        String result ="";

        for(int i=1; i<=9; i++){
            result += value + "*"+ i + "=" + String.valueOf(value * i) + '\n';
        }

        return result;
    }

    private void applyRxOpration(int value){
        Observable.range(1, 9)
                .map(row -> value + "*" + row + "=" + (value * row))
                .map(row -> row + '\n')
                .subscribe(result_TV::append);
    }



}
