package com.example.blahblahblah; // Change to match name of app

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.lang.Math;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MainActivity extends Activity 
{
	RelativeLayout rl;
	
	// The input texts
	EditText VMag;
	EditText VAngle;
	EditText IMag;
	EditText IAngle;
	EditText ZMag;
	EditText ZAngle;
	
	Button Clear;
	Button Enter;
	Button Plot;
	Button Plot3;
	Button SinPlot;
	Button nextscreen;
	
	//For manipulating the numbers
	double vmag=0.0;
	double vangle=0.0;
	double imag=0.0;
	double iangle=0.0;
	double zmag=0.0;
	double zangle=0.0;

	//Three phase or one phase
	boolean threephase = false;
	
	String state = "A";
	//Needed for checking empty strings
	String check="";
	
	final Context context = this;
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    //To change the background color
    RelativeLayout r1 = (RelativeLayout)findViewById(R.id.ScreenTwoLayout);
    r1.setBackgroundColor(Color.WHITE);
    
    // Getting the variables and stuff
    VMag = (EditText)  findViewById(R.id.VMag);
    VMag.requestFocus();
    VAngle = (EditText) findViewById(R.id.VAngle);
    IMag = (EditText) findViewById(R.id.IMag);
    IAngle = (EditText) findViewById(R.id.IAngle);
    ZMag = (EditText) findViewById(R.id.ZMag);
    ZAngle = (EditText) findViewById(R.id.ZAngle);
    Clear = (Button) findViewById(R.id.Clear);
    Enter = (Button) findViewById(R.id.Enter);
    Plot = (Button) findViewById(R.id.Plot);
    Plot3 = (Button) findViewById(R.id.Plot3);
    SinPlot = (Button) findViewById(R.id.SinPlot);
    nextscreen = (Button) findViewById(R.id.nextscreen);
    
   
    // Clear button
    Clear.setOnClickListener(new OnClickListener() { // Creating a click
		// listener inline
    	@Override
    	public void onClick(View arg0) { // What we want it to do on a click
    		clear(); //Clear defined at the bottom
    		vmag = 0;
    		imag = 0;
    		zmag = 0;
    		
    		iangle = 0;
    		vangle = 0;
    		zangle = 0;
    	}			
    });	

    
    //Next series of text watchers manipulate the double variables after the text has been changed
    VMag.addTextChangedListener(new TextWatcher() {
    	 @Override
		public void afterTextChanged(Editable s) {
             check = VMag.getText().toString().trim();
             try {vmag = Double.parseDouble(check);
             		}
             
             catch (NumberFormatException e){vmag=0.0;}
         
    	 }
    	 @Override
		public void beforeTextChanged(CharSequence s, int start, int count,
    			 int after) {
    			                      //XXX do something
    			                         }
         @Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
    			                                 //XXX do something
    			                         }
    			        
    });
    
    VAngle.addTextChangedListener(new TextWatcher() {
   	 @Override
	public void afterTextChanged(Editable s) {
   		check = VAngle.getText().toString().trim();
   		try {vangle = Double.parseDouble(check);}
        
        catch (NumberFormatException e){vangle=0.0;}
    }
   	 @Override
	public void beforeTextChanged(CharSequence s, int start, int count,
   			 int after) {
   			                      //XXX do something
   			                         }
        @Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
   			                                 //XXX do something
   			                         }
   			        
   });
    
    IMag.addTextChangedListener(new TextWatcher() {
   	 @Override
	public void afterTextChanged(Editable s) {
   		check = IMag.getText().toString().trim();
   		try {imag = Double.parseDouble(check);}
        
        catch (NumberFormatException e){imag=0.0;}
    }
   	 @Override
	public void beforeTextChanged(CharSequence s, int start, int count,
   			 int after) {
   			                      //XXX do something
   			                         }
        @Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
   			                                 //XXX do something
   			                         }
   			        
   });
    
    IAngle.addTextChangedListener(new TextWatcher() {
   	 @Override
	public void afterTextChanged(Editable s) {
   		check = IAngle.getText().toString().trim();
   		try {iangle = Double.parseDouble(check);}
        
        catch (NumberFormatException e){iangle=0.0;}
    }
   	 @Override
	public void beforeTextChanged(CharSequence s, int start, int count,
   			 int after) {
   			                      //XXX do something
   			                         }
        @Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
   			                                 //XXX do something
   			                         }
   			        
   });
    
    ZMag.addTextChangedListener(new TextWatcher() {
   	 @Override
	public void afterTextChanged(Editable s) {
   		check = ZMag.getText().toString().trim();
   		try {zmag = Double.parseDouble(check);}
        
        catch (NumberFormatException e){zmag=0.0;}
        
   	 }
   	 @Override
	public void beforeTextChanged(CharSequence s, int start, int count,
   			 int after) {
   			                      //XXX do something
   			                         }
        @Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
   			                                 //XXX do something
   			                         }
   			        
   });
    
    ZAngle.addTextChangedListener(new TextWatcher() {
   	 @Override
	public void afterTextChanged(Editable s) {
   		check = ZAngle.getText().toString().trim();
        try {zangle = Double.parseDouble(check);}
        
        catch (NumberFormatException e){zangle=0.0;}

        }
    
   	 @Override
	public void beforeTextChanged(CharSequence s, int start, int count,
   			 int after) {
   			                      //XXX do something
   			                         }
        @Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
   			                                 //XXX do something
   			                         }
   			        
   });
    
    nextscreen.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent goToSecondActivity = new Intent(arg0.getContext(), SecondActivity.class);
			startActivity(goToSecondActivity);				
		}
    });
    
    Plot3.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent goToPlot = new Intent(arg0.getContext(), drawthreephasor.class);
			
			threephase = true;
			goToPlot.putExtra("vmag", vmag);
			goToPlot.putExtra("vangle", vangle);
			goToPlot.putExtra("imag", imag);
			goToPlot.putExtra("iangle", iangle);
			goToPlot.putExtra("threephase", threephase);
			
			startActivity(goToPlot);				
		}
    });
    
    Plot.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent goToPlot = new Intent(arg0.getContext(), drawthreephasor.class);
			
			threephase = false;
			goToPlot.putExtra("vmag", vmag);
			goToPlot.putExtra("vangle", vangle);
			goToPlot.putExtra("imag", imag);
			goToPlot.putExtra("iangle", iangle);
			goToPlot.putExtra("threephase",  threephase);
			
			startActivity(goToPlot);				
		}
    });
    
    SinPlot.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent goToSinPlot = new Intent(arg0.getContext(), SinGraph.class);
			
			goToSinPlot.putExtra("vmag", vmag);
			goToSinPlot.putExtra("vangle", vangle);
			goToSinPlot.putExtra("imag", imag);
			goToSinPlot.putExtra("iangle", iangle);
			
			startActivity(goToSinPlot);				
		}
    });
    
    //Enter button
   	Enter.setOnClickListener(new OnClickListener(){
    	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 // Turn the edittexts into Doubles
			
			//checkifdone defined at bottom, checks to make sure at least two variables are defined
			if (checkifDone())
			{
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);
		 
					// set title
					alertDialogBuilder.setTitle("Do It Right Fool");
		 
					// set dialog message
					alertDialogBuilder
						.setMessage("Please enter two variables to get the third.")
						.setCancelable(false)
						.setPositiveButton("OK",new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, close
								// current activity
								dialog.cancel();
							}
						  });
		 
						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();
		 
						// show it
						alertDialog.show();
				
				}
			//calculations
			else 
			{
				if ((vmag == 0.0 && vangle == 0.0))
				{
					//V=IZ
					vmag = imag * zmag;
					vangle = iangle + zangle;
				}
				else if ((imag == 0.0) && (iangle == 0.0))
				{
					imag = Math.abs(vmag) / Math.abs(zmag);
					iangle = vangle - zangle;
				}
				else if ((zmag == 0.0) && (zangle == 0.0))
				{
					zmag = Math.abs(vmag) / Math.abs(imag);
					zangle = vangle - iangle;
				}
				
				ZMag.setText(new BigDecimal(zmag).round(new MathContext(6, RoundingMode.HALF_UP)).toString());
				ZAngle.setText(new BigDecimal(zangle).round(new MathContext(6, RoundingMode.HALF_UP)).toString());
				IMag.setText(new BigDecimal(imag).round(new MathContext(6, RoundingMode.HALF_UP)).toString());
				IAngle.setText(new BigDecimal(iangle).round(new MathContext(6, RoundingMode.HALF_UP)).toString());
				VMag.setText(new BigDecimal(vmag).round(new MathContext(6, RoundingMode.HALF_UP)).toString());
				VAngle.setText(new BigDecimal(vangle).round(new MathContext(6, RoundingMode.HALF_UP)).toString());	
			
			
			}
			
		}
		
    	});
    
    
    }
    
   
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    //Clear function
    private void clear(){
    	VMag.setText("");
		VAngle.setText("");
		IMag.setText("");
		IAngle.setText("");
		ZMag.setText("");
		ZAngle.setText("");
	
    }
    
    //Check if done function, assuming that nobody would be stupid enough to need a calculator to multiply or divide with a zero phasor
    private boolean checkifDone()
    {
    	
    	boolean yes= (
    			((vmag == 0.0 && vangle == 0.0) && (imag == 0.0 && iangle == 0.0)) 
    											|| 
    			((vmag == 0.0 && vangle == 0.0) && (zmag == 0.0 && zangle == 0.0)) 
    											|| 
    			((imag == 0.0 && iangle == 0.0) && (zmag == 0.0 && zangle == 0.0))
    			);	
    	return yes;
    }
}


