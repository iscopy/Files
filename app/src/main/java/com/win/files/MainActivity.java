package com.win.files;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText name, pswd;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        pswd = (EditText) findViewById(R.id.pswd);

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入的用户名密码
                String names = name.getText().toString();
                String pswds = pswd.getText().toString();

                FileOutputStream fos = null;
                try {
                    //获取文件输出流
                    //MODE_APPEND 检查文件是否存在，存在就往里面追加，不存在就创建一个文件
                    fos = openFileOutput("login",MODE_APPEND);
                    //保存用户名和密码
                    fos.write((names + " " + pswds).getBytes());
                    //清除缓存
                    fos.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //关闭文件输入流
                    try{
                        if(fos!=null)
                            fos.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });


    }
}
