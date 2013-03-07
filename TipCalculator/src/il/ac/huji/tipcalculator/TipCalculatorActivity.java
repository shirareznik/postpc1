package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	Button   mButton;
	EditText mEdit;
	CheckBox mCheck;
	boolean isRound=false;
	TextView mRes;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        mButton = (Button)findViewById(R.id.btnCalculate);
        mEdit   = (EditText)findViewById(R.id.edtBillAmount);
        mCheck=(CheckBox)findViewById(R.id.chkRound);
        mRes=(TextView)findViewById(R.id.txtTipResult);
        mCheck.setOnClickListener(
        		new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						isRound=!isRound;
						mCheck.setChecked(isRound);
					}
				}
        		);
        mButton.setOnClickListener(
            new View.OnClickListener()
            {
                public void onClick(View view)
                {
                	String bill_t=mEdit.getText().toString();
                	double bill=Double.parseDouble(bill_t);
                	double tip=bill*0.12;
                	long roundedTip;
                	String restip="Tip: $",result;
                	if (isRound)
                	{
                		roundedTip=Math.round(tip);
                		result=restip.concat(String.valueOf(roundedTip));
                	}else{
                		result=restip.concat(String.format("%.2f",tip));
                	}
                	//"%.2f%n", 3.5
                	mRes.setText(result);
                }
            });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
}
