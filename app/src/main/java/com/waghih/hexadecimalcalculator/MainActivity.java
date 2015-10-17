//AHMAD FAROOQ BIN EZHAR
//1226461
//CSC 4506

package com.waghih.hexadecimalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> hex = new ArrayList<String>();
    protected TextView resultView;
    protected TextView inputView;
    protected String inputValue = "";
    protected double square;
    protected double logX;
    protected int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputView = (TextView) findViewById(R.id.tv_input);
        resultView = (TextView) findViewById(R.id.tv_results);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void storeValue(View v){
        switch(v.getId()){
            case R.id.button_del:
                delete();
                break;
            case R.id.button_clear:
                hex.clear();
                result=0;
                resultView.setText("0");
                showInput();
                break;
            case R.id.button_a:
                hex.add("A");
                showInput();
                break;
            case R.id.button_b:
                hex.add("B");
                showInput();
                break;
            case R.id.button_c:
                hex.add("C");
                showInput();
                break;
            case R.id.button_d:
                hex.add("D");
                showInput();
                break;
            case R.id.button_e:
                hex.add("E");
                showInput();
                break;
            case R.id.button_f:
                hex.add("F");
                showInput();
                break;
            case R.id.button_0:
                hex.add("0");
                showInput();
                break;
            case R.id.button_1:
                hex.add("1");
                showInput();
                break;
            case R.id.button_2:
                hex.add("2");
                showInput();
                break;
            case R.id.button_3:
                hex.add("3");
                showInput();
                break;
            case R.id.button_4:
                hex.add("4");
                showInput();
                break;
            case R.id.button_5:
                hex.add("5");
                showInput();
                break;
            case R.id.button_6:
                hex.add("6");
                showInput();
                break;
            case R.id.button_7:
                hex.add("7");
                showInput();
                break;
            case R.id.button_8:
                hex.add("8");
                showInput();
                break;
            case R.id.button_9:
                hex.add("9");
                showInput();
                break;
        }
    }
    public void function(View view){
        switch (view.getId()){
            case R.id.button_plus:
                check("+");
                break;
            case R.id.button_minus:
                check("-");
                break;
            case R.id.button_mul:
                check("*");
                break;
            case R.id.button_div:
                check("/");
                break;
            case R.id.button_equal:
                evaluate();
                break;
            case R.id.button_dec:
                showToast();
                break;
            case R.id.button_power:
                calcPower();
                break;
            case R.id.button_log:
                calcLog();
                break;
        }
    }
    public void check(String s){
        if(!hex.isEmpty()){
            if(hex.get(hex.size()-1)== "+" ||hex.get(hex.size()-1)== "-"||hex.get(hex.size()-1)== "*" ||hex.get(hex.size()-1)== "/" ){
                hex.remove(hex.size()-1);
                hex.add(s);
            }
            else {
                evaluate();
                hex.add(s);
            }
        }
        else {
            showInput();
        }

        showInput();
    }
    public void calculate(String s){
        String leftOperand="";
        String rightOperand="";
        int value_1;
        int value_2;
        for(int i=0; i<hex.indexOf(s);i++){
            leftOperand += hex.get(i);
        }
        for (int i=hex.indexOf(s)+1;i<hex.size() ;i++ ) {
            rightOperand += hex.get(i);
        }
        System.out.println(leftOperand);
        System.out.println(rightOperand);
        if(rightOperand.equals("")){
            try{
                value_1 = Integer.parseInt(leftOperand,16);
                result = value_1;
            }
            catch (Exception e){
                String message = "TOO BIG";
                System.out.println(message);
                resultView.setText(message);
                hex.clear();
                showInput();
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
        else {
            try{
                value_1 = Integer.parseInt(leftOperand,16);
                value_2 = Integer.parseInt(rightOperand,16);
                if(s.equals("+")){
                    result = value_1 + value_2;
                    System.out.println(result);
                }
                if(s.equals("-")){
                    result = value_1 - value_2;
                    System.out.println(result);
                }
                if(s.equals("*")){
                    result = value_1 * value_2;
                }
                if(s.equals("/")){
                    divideOperation(value_1,value_2);
                }
            }
            catch (Exception e){
                String message = "TOO BIG";
                hex.clear();
                result = 0;
                showInput();
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }


    }
    public void evaluate(){
        if(hex.contains("+")){
            calculate("+");
            resultView.setText(Integer.toHexString(result).toUpperCase());
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
        }
        else if(hex.contains("-")){
            calculate("-");
            resultView.setText(Integer.toHexString(result).toUpperCase());
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
        }
        else if(hex.contains("*")){
            calculate("*");
            resultView.setText(Integer.toHexString(result).toUpperCase());
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
        }
        else if(hex.contains("/")){
            calculate("/");
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
        }
        else{
            resultView.setText(inputValue);
        }
        showInput();
    }
    public void calcLog(){
        if(hex.contains("+")){
            calculate("+");
            double temp = (double) result;
            System.out.println(result);
            logX = Math.log(temp);
            System.out.println(logX);
            result = (int)logX;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else if(hex.contains("-")){
            calculate("-");
            double temp = (double) result;
            System.out.println(result);
            logX = Math.log(temp);
            System.out.println(logX);
            result = (int)logX;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else if(hex.contains("*")){
            calculate("*");
            double temp = (double) result;
            System.out.println(result);
            logX = Math.log(temp);
            System.out.println(logX);
            result = (int)logX;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else if(hex.contains("/")){
            calculate("/");
            double temp = (double) result;
            System.out.println(result);
            logX = Math.log(temp);
            System.out.println(logX);
            result = (int)logX;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else if(!hex.isEmpty()){
            result = Integer.parseInt(inputValue,16);
            double temp = (double) result;
            System.out.println(result);
            logX = Math.log(temp);
            System.out.println(logX);
            result = (int)logX;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else {
            showInput();
        }
    }
    public void calcPower(){
        if(hex.contains("+")){
            calculate("+");
            double temp = (double) result;
            System.out.println(result);
            square = Math.pow(temp, 2);
            System.out.println(square);
            result = (int)square;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else if(hex.contains("-")){
            calculate("-");
            double temp = (double) result;
            System.out.println(result);
            square = Math.pow(temp, 2);
            System.out.println(square);
            result = (int)square;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else if(hex.contains("*")){
            calculate("*");
            double temp = (double) result;
            System.out.println(result);
            square = Math.pow(temp, 2);
            System.out.println(square);
            result = (int)square;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else if(hex.contains("/")){
            calculate("/");
            double temp = (double) result;
            System.out.println(result);
            square = Math.pow(temp, 2);
            System.out.println(square);
            result = (int)square;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else if(!hex.isEmpty()){
            result = Integer.parseInt(inputValue,16);
            double temp = (double) result;
            System.out.println(result);
            square = Math.pow(temp, 2);
            System.out.println(square);
            result = (int)square;
            hex.clear();
            hex.add(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
            showInput();
        }
        else {
            showInput();
        }
    }
    public void divideOperation(int v1, int v2){
        try{
            result = v1 / v2;
            System.out.println(Integer.toHexString(result).toUpperCase());
            resultView.setText(Integer.toHexString(result).toUpperCase());
        }catch (Exception e) {
            error();
        }
    }
    public void error(){
        resultView.setText("Error");
        hex.clear();
        result = 0;
        showInput();
    }
    public void delete(){
        if(!hex.isEmpty()){
            hex.remove(hex.size() - 1);
            showInput();
        }
        else{
            inputView.setText("0");
        }
    }
    public void showInput(){
        inputValue = "";
        if(!hex.isEmpty()){
            for(int i=0;i<hex.size();i++){
                inputValue += hex.get(i);
            }
            inputView.setText(inputValue);
        }
        else{
            inputView.setText("0");
        }
    }
    public void showToast(){
        if(!hex.isEmpty()){
            evaluate();
            result = Integer.parseInt(inputValue,16);
            System.out.println(result);
            String tos = Integer.toString(result);
            Toast.makeText(this, tos, Toast.LENGTH_LONG).show();
        }
        else{
            resultView.setText("0");
        }
    }
}
