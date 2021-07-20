package com.example.counter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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

public class MainActivity extends Activity implements OnClickListener{//实现接口OnClickListener

	private EditText ed;
	private Button btn_ac,btn_ce,btn_del,btn_eq;
	private Button btn_01,btn_02,btn_03,btn_04,btn_05;
	private Button btn_06,btn_07,btn_08,btn_09,btn_00,btn;
	private Button btn_add,btn_sub,btn_mul,btn_div,btn_per;
	private ImageButton btn_img;
	private Button explain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed=(EditText)findViewById(R.id.show);
        btn_ac=(Button)findViewById(R.id.clean);
        btn_ce=(Button)findViewById(R.id.delete);
        btn_del=(Button)findViewById(R.id.backspace);
        btn_eq=(Button)findViewById(R.id.result);
        btn_00=(Button)findViewById(R.id.btn_0);
        btn_01=(Button)findViewById(R.id.btn_1);
        btn_02=(Button)findViewById(R.id.btn_2);
        btn_03=(Button)findViewById(R.id.btn_3);
        btn_04=(Button)findViewById(R.id.btn_4);
        btn_05=(Button)findViewById(R.id.btn_5);
        btn_06=(Button)findViewById(R.id.btn_6);
        btn_07=(Button)findViewById(R.id.btn_7);
        btn_08=(Button)findViewById(R.id.btn_8);
        btn_09=(Button)findViewById(R.id.btn_9);
        btn=(Button)findViewById(R.id.btn);
        
        btn_add=(Button)findViewById(R.id.add);//加 +
        btn_sub=(Button)findViewById(R.id.sub);//减 -
        btn_mul=(Button)findViewById(R.id.mult);//乘*
        btn_div=(Button)findViewById(R.id.div);//除 /
        btn_per=(Button)findViewById(R.id.percent);//百分 %
        
        btn_img=(ImageButton)findViewById(R.id.change);
        btn_img.setOnClickListener(this);
        
        explain=(Button)findViewById(R.id.plain);
        explain.setOnClickListener(this);
       
        //设置点击事件
        btn_ac.setOnClickListener(this);
        btn_ce.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_eq.setOnClickListener(this);
        btn_00.setOnClickListener(this);
        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
        btn_04.setOnClickListener(this);
        btn_05.setOnClickListener(this);
        btn_06.setOnClickListener(this);
        btn_07.setOnClickListener(this);
        btn_08.setOnClickListener(this);
        btn_09.setOnClickListener(this);
        btn.setOnClickListener(this);
        
        btn_add.setOnClickListener(this);//加 +
        btn_sub.setOnClickListener(this);//减 -
        btn_mul.setOnClickListener(this);//乘*
        btn_div.setOnClickListener(this);//除 /
        btn_per.setOnClickListener(this);//百分 %
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    boolean last_flag;//设置清空标识
	private double firstNum;
	private double lastNum;
	private String lastoperator="";//定义一个变量存储一个运算符
	double result;
	int lastIndex;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String textShow = ed.getText().toString();//获取输入框内的内容
		String textBefore = "";
		
		if(textShow.equals("0")){//如果显示框只有“0”，设置为空
			ed.setText("");
		}
		if (last_flag) {
			textBefore="";
			textShow="";
			lastoperator="";
			firstNum=0D;
			lastNum=0D;
		}
		
		textBefore = ed.getText().toString();//获取运算符之前的内容
		
		if(!lastoperator.equals("")){
			lastIndex = textBefore.lastIndexOf(lastoperator);//记录最后一个运算符所在的位置
			textBefore = textBefore.substring(lastIndex+1);//获取最后一个运算符之后的子串字符
		}
		
		switch (v.getId()) {
		case R.id.change:
			layoutChange();
			break;
		case R.id.plain:
			explainShow();
			break;
		//点击数字和“.”直接显示内容
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn:
			ed.setText(textShow+((Button)v).getText());//获取Button的text值
			last_flag=false;
			break;
		//加、减、乘、除算法按键
		case R.id.add:
			if (textShow.equals("") && !lastoperator.equals("=")) {
				return;
			}
			operateFirstNum(textBefore, "+");
			ed.setText(ed.getText()+"+");
			last_flag=false;
			lastoperator="+";
			break;
		case R.id.sub:
			if(textShow.equals("") && !lastoperator.equals("="))
			{
				return ;
			}
			operateFirstNum(textBefore, "-");
			ed.setText(ed.getText()+"-");
			last_flag=false;
			lastoperator="-";
			break;
		case R.id.mult:
			if(textShow.equals("") && !lastoperator.equals("="))
			{
				return ;
			}
			operateFirstNum(textBefore, "*");
			ed.setText(ed.getText()+"*");
			last_flag=false;
			lastoperator="*";
			break;
		case R.id.div:
			if(textShow.equals("") && !lastoperator.equals("="))
			{
				return ;
			}
			operateFirstNum(textBefore, "/");
			ed.setText(ed.getText()+"/");
			last_flag=false;
			lastoperator="/";
			break;
		case R.id.percent:
			if(textShow.equals("") && !lastoperator.equals("="))
			{
				return ;
			}
			result=(Double.parseDouble(textBefore))/100;
			last_flag=true;
			ed.setText(textBefore+"%\n"+String.valueOf(result));
			lastNum=0D;
			break;
		//设置全清除键、清除输入键、结果
		case R.id.clean:
			ed.setText("");
			last_flag=false;
			textBefore="";
			firstNum=0D;
			lastNum=0D;
			textShow="";
			lastoperator="=";
			break;
		case R.id.delete:
			if(textShow !=null && !textShow.equals("")) {
				ed.setText(textShow.substring(0, lastIndex));
				last_flag=false;
			}
			if(textShow.length()<1)return;
			break;
		case R.id.backspace:
			if(textShow !=null && !textShow.equals("")) {
				ed.setText(textShow.substring(0, textShow.length()-1));
			}else if(last_flag) {
				last_flag=false;
				ed.setText("");
				textShow="";
			}
			break;
		case R.id.result:
			if(textShow.equals("")){
				return ;
			}
			operateResult(textBefore);
			lastoperator="=";
			last_flag=true;
			textBefore=ed.getText().toString();
			ed.setText(textBefore+"\n="+String.valueOf(result));
			break;

		default:
			break;
		}
	}
	
	private void layoutChange() {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, SeniorActivity.class);
		startActivity(intent);
	}
	
	private void explainShow() {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, ExplainActivity.class);
		startActivity(intent);
	}
	
	private void operate(String operators) {
		if (lastNum != 0D) {
			if(lastoperator.equals("/")){
				lastNum = lastNum / Double.parseDouble(operators);
				result = firstNum / lastNum;
			}
			else if (lastoperator.equals("*")) {
				lastNum = lastNum * Double.parseDouble(operators);
				result = firstNum * lastNum;
			}
			else if (lastoperator.equals("-")) {
				lastNum = lastNum - Double.parseDouble(operators);
				result = firstNum - lastNum;
			}
			else if (lastoperator.equals("+")) {
				lastNum = lastNum + Double.parseDouble(operators);
				result = firstNum + lastNum;
			}
		}else{
			if (lastoperator.equals("/")) {
				result =firstNum / Double.parseDouble(operators);
			}
			else if (lastoperator.equals("*")) {
				result =firstNum * Double.parseDouble(operators);
			}
			else if (lastoperator.equals("-")) {
				result =firstNum - Double.parseDouble(operators);
			}
			else if (lastoperator.equals("+")) {
				result =firstNum + Double.parseDouble(operators);
			}
			else if (lastoperator.equals("")) {
				result = Double.parseDouble(operators);
			}
		}
		
	}
	
	public void operateFirstNum(String operators,String operator) {
		if (lastoperator.equals(operator)==false) {
			firstNum = Double.parseDouble(operators);
			return;
		}
		if(lastoperator.equals(operator)) {
			if(lastoperator.equals("/")) {
				result = firstNum / Double.parseDouble(operators);
			}
			else if(lastoperator.equals("*")) {
				result = firstNum * Double.parseDouble(operators);
			}
			else if(lastoperator.equals("-")) {
				result = firstNum - Double.parseDouble(operators);
			}
			else if(lastoperator.equals("+")) {
				result = firstNum + Double.parseDouble(operators);
			}
			return;
		}
		operate(operators);
	}
	
	public void operateResult(String operators){
		operate(operators);
	}
}
