package harish.hibare.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView display;
Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonplus,buttonminus,buttondiv,buttonmul,buttonequ,buttondot,buttoncle;
String inp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        button0 = findViewById(R.id.zero);
        button1 = findViewById(R.id.one);
        button2 = findViewById(R.id.two);
        button3 = findViewById(R.id.three);
        button4 = findViewById(R.id.four);
        button5 = findViewById(R.id.five);
        button6 = findViewById(R.id.six);
        button7 = findViewById(R.id.seven);
        button8 = findViewById(R.id.eight);
        button9 = findViewById(R.id.nine);
        buttondiv = findViewById(R.id.div);
        buttondot = findViewById(R.id.dot);
        buttonplus = findViewById(R.id.add);
        buttonminus = findViewById(R.id.minus);
        buttonmul = findViewById(R.id.mult);
        buttoncle = findViewById(R.id.C);
        buttonequ = findViewById(R.id.equal);
    }
    public void ButtonClick(View view){
        Button button =(Button) view;
        String s=button.getText().toString();
        switch (s){
            case "C":
                inp="";
                break;

            case "=":
                solve();
                break;
            default:
                if(inp==null){
                    inp="";
                }
                if(s.equals("+")||s.equals("-")||s.equals("/")||s.equals("*")){
                    solve();
                }
                inp+=s;
        }
        display.setText(inp);
    }

    private void solve() {
        if(inp.split("\\*").length==2){
            String num[]=inp.split("\\*");
            try {
                double mul = Double.parseDouble(num[0]) * Double.parseDouble(num[1]);
                inp = mul+"";
            }
            catch (Exception e){
                System.out.println("\nError\n");
            }
        }
       else if(inp.split("/").length==2){
            String num[]=inp.split("/");
            try {
                double div = Double.parseDouble(num[0]) / Double.parseDouble(num[1]);
                inp =div+"";
            }
            catch (Exception e){
                System.out.println("\nError\n");
            }
        }
        else if(inp.split("-").length>1){
            String num[]=inp.split("-");
            if(num[0]=="" && num.length==2){
                num[0]=0+"";
            }
            try {
                double min=0;
                if(num.length==2) {
                     min = Double.parseDouble(num[0]) - Double.parseDouble(num[1]);
                }
                else if (num.length==3){
                    min = Double.parseDouble(num[1]) - Double.parseDouble(num[2]);
                }
                inp = min+"";
            }
            catch (Exception e){
                System.out.println("\nError\n");
            }
        }
        else if(inp.split("\\+").length==2){
            String num[]=inp.split("\\+");
            try {
                double add = Double.parseDouble(num[0]) + Double.parseDouble(num[1]);
                inp = add+"";
            }
            catch (Exception e){
                System.out.println("\nError\n");
            }
        }
        String n[]=inp.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                inp=n[0];
            }
        }
        display.setText(inp);
    }
}