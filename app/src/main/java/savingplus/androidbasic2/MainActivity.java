package savingplus.androidbasic2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lấy ra các Button theo ID
        Button button1=(Button)this.findViewById(R.id.Go_Button1);

        //Đặt sự kiện click vào Button1
        button1.setOnClickListener(new Button.OnClickListener(){
            public void onClick ( View v){
                //Tạo ra một intent và mang nội dung gửi tới Example1
                Intent myIntent = new Intent(MainActivity.this,Example1Activity.class);
                myIntent.putExtra("Text1", "This is text 1");
                myIntent.putExtra("Text2", "This is long text 2");

                //Yêu cầu chạy Example1Activity
                MainActivity.this.startActivity(myIntent);
            }
        });

    }
}
