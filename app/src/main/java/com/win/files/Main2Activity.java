package com.win.files;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private Button obtian;
    private TextView one, two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        one = (TextView) findViewById(R.id.one);
        two = (TextView) findViewById(R.id.two);

        obtian = (Button) findViewById(R.id.obtain);
        obtian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream fis = null;
                byte[] buffer = null;
                try {
                    //获取文件输入流
                    fis = openFileInput("login");
                    //定义保存数据的数组
                    buffer = new byte[fis.available()];
                    //从输入流中读取数据
                    fis.read(buffer);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try{
                        if(fis!=null)
                            fis.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
                //获取数组中的数据
                String data = new String(buffer);
                String names = data.split(" ")[0];
                String pswds = data.split(" ")[1];
                one.setText("账号是：" + names);
                two.setText("密码是：" + pswds);
            }
        });

    }
}
