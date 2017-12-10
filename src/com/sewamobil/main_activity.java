package com.sewamobil;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class main_activity extends Activity {
    /** Called when the activity is first created. */

	EditText jml_hari;
	RadioButton r1,r2,r3;
	Spinner spin;
	String [] items={"DP","Tidak Ada DP"};
	Button btn;
	TextView txt_hasil;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        spin=(Spinner)findViewById(R.id.spin);
        ArrayAdapter<String>
        aa= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,items);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        
        jml_hari=(EditText)findViewById(R.id.jumlah_hari);
        r1=(RadioButton)findViewById(R.id.avanza);
        r2=(RadioButton)findViewById(R.id.AVP);
        r3=(RadioButton)findViewById(R.id.xenia);
        btn=(Button)findViewById(R.id.hitung);
        txt_hasil=(TextView)findViewById(R.id.hasil);
    }
	
	public void hitung (View v){
		int a=Integer.parseInt(jml_hari.getText().toString());
		int total=0;
		int i=spin.getSelectedItemPosition();
		
		if (r1.isChecked()==true){
			total=a*200000;
		}
		if (r2.isChecked()==true){
			total=a*300000;
		}
		if (r3.isChecked()==true){
			total=a*400000;
		}
		
		if (i==0){
			total=total-100000;
		}
		if (i==1){
			total=total;
		}
		
		txt_hasil.setText("Hasilnya : "+total);
	}
}