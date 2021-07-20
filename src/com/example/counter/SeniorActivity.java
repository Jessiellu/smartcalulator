package com.example.counter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SeniorActivity extends Activity {

	private EditText in;
	private ImageButton exchange;
	private TextView t1,t2,t3,t4;
	private Spinner sp;
	private Button explain;
	private Button btn_a,btn_b,btn_c,btn_d,btn_e,btn_f;
	private LinearLayout v;
	private Button btn_01,btn_02,btn_03,btn_04,btn_05;
	private Button btn_06,btn_07,btn_08,btn_09,btn_00,btn_de,btn_enter;
	String code[] = {"十进制","二进制","八进制","十六进制"};
	String str;
	String two,eight,sixteen;
	int ten;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_senior);
		
		sp=(Spinner)findViewById(R.id.list);
		in=(EditText)findViewById(R.id.input);
		t1=(TextView)findViewById(R.id.ra_1);
		t2=(TextView)findViewById(R.id.ra_2);
		t3=(TextView)findViewById(R.id.ra_3);
		t4=(TextView)findViewById(R.id.ra_4);
		
		v=(LinearLayout)findViewById(R.id.alpha);//字母按钮布局
		
		btn_a=(Button)findViewById(R.id.btn_A);
        btn_b=(Button)findViewById(R.id.btn_B);
        btn_c=(Button)findViewById(R.id.btn_C);
        btn_d=(Button)findViewById(R.id.btn_D);
        btn_e=(Button)findViewById(R.id.btn_E);
        btn_f=(Button)findViewById(R.id.btn_F);

		btn_00=(Button)findViewById(R.id.btn_00);
        btn_01=(Button)findViewById(R.id.btn_01);
        btn_02=(Button)findViewById(R.id.btn_02);
        btn_03=(Button)findViewById(R.id.btn_03);
        btn_04=(Button)findViewById(R.id.btn_04);
        btn_05=(Button)findViewById(R.id.btn_05);
        btn_06=(Button)findViewById(R.id.btn_06);
        btn_07=(Button)findViewById(R.id.btn_07);
        btn_08=(Button)findViewById(R.id.btn_08);
        btn_09=(Button)findViewById(R.id.btn_09);
        btn_de=(Button)findViewById(R.id.btn_del);
        btn_enter=(Button)findViewById(R.id.btn_ok);
		
		exchange=(ImageButton)findViewById(R.id.change);
		explain=(Button)findViewById(R.id.plain);
		
		/*用泛型创建数组适配器*/
		ArrayAdapter<String> Code = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,code);
		Code.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(Code);
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {//监听下拉列表

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				str="";
				str=parent.getSelectedItem().toString();
				/*设置不同进制里部分按键不可见*/
				if(str==code[3]) {v.setVisibility(View.VISIBLE);}//在十六进制中，字母按钮设置可见
				else if(str!=code[3]) {v.setVisibility(View.INVISIBLE);}
				if(str==code[2] || str==code[1]) {//在八进制里，8和9键不能按
					btn_08.setClickable(false);
					btn_08.setBackgroundResource(R.drawable.inputbg);
					btn_09.setClickable(false);
					btn_09.setBackgroundResource(R.drawable.inputbg);
				}else if(str!=code[2] || str!=code[1]) {
					btn_08.setClickable(true);
					btn_08.setBackgroundResource(R.drawable.click);
					btn_09.setClickable(true);
					btn_09.setBackgroundResource(R.drawable.click);
				}
				if(str==code[1]) {//在二进制里，除了1和0，其他键不能按
					btn_02.setClickable(false);
					btn_03.setClickable(false);
					btn_04.setClickable(false);
					btn_05.setClickable(false);
					btn_06.setClickable(false);
					btn_07.setClickable(false);
//					btn_08.setClickable(false);
//					btn_09.setClickable(false);
					btn_02.setBackgroundResource(R.drawable.inputbg);
					btn_03.setBackgroundResource(R.drawable.inputbg);
					btn_04.setBackgroundResource(R.drawable.inputbg);
					btn_05.setBackgroundResource(R.drawable.inputbg);
					btn_06.setBackgroundResource(R.drawable.inputbg);
					btn_07.setBackgroundResource(R.drawable.inputbg);
//					btn_08.setBackgroundResource(R.drawable.inputbg);
//					btn_09.setBackgroundResource(R.drawable.inputbg);
				}else if(str!=code[1]) {
					btn_02.setClickable(true);
					btn_03.setClickable(true);
					btn_04.setClickable(true);
					btn_05.setClickable(true);
					btn_06.setClickable(true);
					btn_07.setClickable(true);
//					btn_08.setClickable(true);
//					btn_09.setClickable(true);
					btn_02.setBackgroundResource(R.drawable.click);
					btn_03.setBackgroundResource(R.drawable.click);
					btn_04.setBackgroundResource(R.drawable.click);
					btn_05.setBackgroundResource(R.drawable.click);
					btn_06.setBackgroundResource(R.drawable.click);
					btn_07.setBackgroundResource(R.drawable.click);
//					btn_08.setBackgroundResource(R.drawable.click);
//					btn_09.setBackgroundResource(R.drawable.click);
				}
				
				in.setText("");
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btn_a.setOnClickListener(click);
        btn_b.setOnClickListener(click);
        btn_c.setOnClickListener(click);
        btn_d.setOnClickListener(click);
        btn_e.setOnClickListener(click);
        btn_f.setOnClickListener(click);
		btn_00.setOnClickListener(click);
        btn_01.setOnClickListener(click);
        btn_02.setOnClickListener(click);
        btn_03.setOnClickListener(click);
        btn_04.setOnClickListener(click);
        btn_05.setOnClickListener(click);
        btn_06.setOnClickListener(click);
        btn_07.setOnClickListener(click);
        btn_08.setOnClickListener(click);
        btn_09.setOnClickListener(click);
		
        btn_enter.setOnClickListener(click);
        btn_de.setOnClickListener(click);
		exchange.setOnClickListener(click);
		explain.setOnClickListener(click);
	}
	
	OnClickListener click = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String textShow = in.getText().toString();//获取输入框内的内容
			//按键监听
			switch (v.getId()) {
			case R.id.change:
				Intent intent1 = new Intent();
				intent1.setClass(SeniorActivity.this, MainActivity.class);
				startActivity(intent1);
				//finish();
				break;
			case R.id.plain:
				Intent intent2 = new Intent();
				intent2.setClass(SeniorActivity.this, ExplainActivity.class);
				startActivity(intent2);
				break;
			case R.id.btn_A:
			case R.id.btn_B:
			case R.id.btn_C:
			case R.id.btn_D:
			case R.id.btn_E:
			case R.id.btn_F:
				if(str==code[3]) {
					in.setText(textShow+((Button)v).getText());
				}else return;
				break;
			case R.id.btn_00:
			case R.id.btn_01:
				in.setText(textShow+((Button)v).getText());
				break;
			case R.id.btn_02:
			case R.id.btn_03:
			case R.id.btn_04:
			case R.id.btn_05:
			case R.id.btn_06:
			case R.id.btn_07:
				if(str!=code[1]) {
					in.setText(textShow+((Button)v).getText());
				}else return;
				break;
			case R.id.btn_08:
			case R.id.btn_09:
				if(str!=code[2]) {
					in.setText(textShow+((Button)v).getText());
				}else return;
				break;
			case R.id.btn_ok:
				if(textShow.equals("")){
					return ;
				}
				codeSwitch(str,in.getText().toString());
				t1.setText("BIN(二进制)："+two);//二进制
				t2.setText("OTC(八进制)："+eight);//八进制
				t3.setText("DEC(十进制)："+String.valueOf(ten));//十进制
				t4.setText("HEX(十六进制)："+sixteen);//十六进制
				break;
			case R.id.btn_del:
				if(textShow !=null && !textShow.equals("")) {
					in.setText(textShow.substring(0, textShow.length()-1));
				}
				break;
			default:
				break;
			}
		}
	};
	
	/*进制转换函数*/
	public void codeSwitch(String str,String num) {
		
		if(in.getText().toString().equals(""))
		{
			Toast in = Toast.makeText(SeniorActivity.this, "请输入数据！", Toast.LENGTH_LONG);
		}
		//下拉列表是否被选中，对所对应的进制转换
		if(str==code[0]) {//十进制
			ten=Integer.parseInt(num);
			two=Integer.toBinaryString(ten);
			eight=Integer.toOctalString(ten);
			sixteen=Integer.toHexString(ten);
				
		}
		else if(str==code[1]) {//二进制
			ten=Integer.valueOf(num,2);
			two=String.valueOf(num);
			eight=Integer.toOctalString(ten);
			sixteen=Integer.toHexString(ten);
				
		}
		else if(str==code[2]) {//八进制
			ten=Integer.valueOf(num,8);
			two=Integer.toBinaryString(ten);
			eight=String.valueOf(num);
			sixteen=Integer.toHexString(ten);
			
		}
		else if(str==code[3]) {//十六进制
			ten=Integer.valueOf(num,16);
			two=Integer.toBinaryString(ten);
			eight=Integer.toOctalString(ten);
			sixteen=String.valueOf(num);
				
		}else {
			ten=Integer.parseInt(num);
			two=String.valueOf(num);
			eight=String.valueOf(num);
			sixteen=String.valueOf(num);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

}
