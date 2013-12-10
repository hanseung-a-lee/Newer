package com.example.blahblahblah;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
	
	//declaring strings(name) that will store the name for the key that is associated with the app
	private static final String RECTANGULAR_A = "RECTANGULAR_A";
	private static final String RECTANGULAR_B = "RECTANGULAR_B";
	private static final String PHASOR_MAGNITUDE = "PHASOR_MAGNITUDE";
	private static final String PHASOR_DEGREE = "PHASOR_DEGREE";

	//declaring double values to store values in the app
	private double rectangularA;
	private double rectangularB;
	private double phasorMagnitude;
	private double phasorDegree;
	
	//declaring editable text fields
	EditText rectangularAET;
	EditText rectangularBET;
	EditText phasorMagnitudeET;
	EditText phasorDegreeET;
	
	//declaring Buttons
	Button enterButton;
	Button clearButton;
	Button backButton;
	//with OnCreate, everything is initialized
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_screen);
		
		//if app is closed, and re-opened, entered values are saved
		if(savedInstanceState == null){
			rectangularA = 0.0;
			rectangularB = 0.0;
			phasorMagnitude = 0.0;
			phasorDegree = 0.0;
		}
		else{
			rectangularA = savedInstanceState.getDouble(RECTANGULAR_A);
			rectangularB = savedInstanceState.getDouble(RECTANGULAR_B);
			phasorMagnitude = savedInstanceState.getDouble(PHASOR_MAGNITUDE);
			phasorDegree = savedInstanceState.getDouble(PHASOR_DEGREE);	
		}
		
		//Initialize editable text fields
		rectangularAET = (EditText) findViewById(R.id.rectAEditText);
		rectangularBET = (EditText) findViewById(R.id.rectBEditText);
		phasorMagnitudeET = (EditText) findViewById(R.id.magnitudeEditText);
		phasorDegreeET = (EditText) findViewById(R.id.angleEditText);
	
		//initialize listeners for text changed within Rectangular fields
		rectangularAET.addTextChangedListener(rectangularAListener);
		rectangularBET.addTextChangedListener(rectangularBListener);
		
		//initialize listeners for text changed within phasor fields
		phasorMagnitudeET.addTextChangedListener(phasorMagnitudeListener);
		phasorDegreeET.addTextChangedListener(phasorDegreeListener);
		
		//initialize buttons
		enterButton = (Button) findViewById(R.id.enterButton);
		clearButton = (Button) findViewById(R.id.clearButton);
		backButton = (Button) findViewById(R.id.back);
		
		//create listeners for buttons
		setButtonOnPressListeners();
	}
	
	//called when rectangularA is changed
	private TextWatcher rectangularAListener = new TextWatcher(){

		@Override
		public void afterTextChanged(Editable arg0) {
			/*try{
				//changes rectangularA to what the user is inputing next
				rectangularA = Double.parseDouble(arg0.toString());
			}
			catch(NumberFormatException e){
				//catches invalid input for the value
				rectangularA = 0.0;
			}
			changeToPhasor();*/
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			try{
				//changes rectangularA to what the user is inputing next
				rectangularA = Double.parseDouble(arg0.toString());
			}
			catch(NumberFormatException e){
				//catches invalid input for the value
				rectangularA = 0.0;
			}
			
			//call a function that will update/convert the new value into phasor form
			//changeToPhasor();
			
			
		}
		
	};
	
	//called when rectangularB is changed
	private TextWatcher rectangularBListener = new TextWatcher(){

		@Override
		public void afterTextChanged(Editable s) {
			/*try{
				//changes rectangularA to what the user is inputing next
				rectangularB = Double.parseDouble(s.toString());
			}
			catch(NumberFormatException e){
				//catches invalid input for the value
				rectangularB = 0.0;
			}
			changeToPhasor();*/
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			try{
				//changes rectangularA to what the user is inputing next
				rectangularB = Double.parseDouble(s.toString());
			}
			catch(NumberFormatException e){
				//catches invalid input for the value
				rectangularB = 0.0;
			}
			
			//call a function that will update/convert the new value into phasor form
			//changeToPhasor();
			
		}
		
	};
	
	//called when phasorMagnitude is changed
	private TextWatcher phasorMagnitudeListener = new TextWatcher(){

		@Override
		public void afterTextChanged(Editable s) {
			/*try{
				//changes phasorMagnitude to what the user is inputing next
				phasorMagnitude = Double.parseDouble(s.toString());
			}
			catch(NumberFormatException e){
				//catches invalid input for the value
				phasorMagnitude = 0.0;
			}
			changeToRectangular();*/
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			try{
				//changes rectangularA to what the user is inputing next
				phasorMagnitude = Double.parseDouble(s.toString());
			}
			catch(NumberFormatException e){
				//catches invalid input for the value
				phasorMagnitude = 0.0;
			}
			
			//call a function that will update/convert to rectangular form
			//changeToRectangular();
			
		}
		
	};
	
	//called when phasorDegree is changed
	private TextWatcher phasorDegreeListener = new TextWatcher(){

		@Override
		public void afterTextChanged(Editable s) {
			/*try{
				//changes phasorMagnitude to what the user is inputing next
				phasorDegree = Double.parseDouble(s.toString());
			}
			catch(NumberFormatException e){
				//catches invalid input for the value
				phasorDegree = 0.0;
			}
			changeToRectangular();*/
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			try{
				//changes rectangularA to what the user is inputing next
				phasorDegree = Double.parseDouble(s.toString());
			}
			catch(NumberFormatException e){
				//catches invalid input for the value
				phasorDegree = 0.0;
			}
			
			//call a function that will update/convert to rectangular form
			//changeToRectangular();
			
		}
		
	};
	
	private void changeToPhasor(){
		
		//phasorMagnitude = sqrt(a^2 + b^2)
		//phasorDegree = arctan(b/a)
		
		//store value for phasorMagnitude
		double phasorMagnitude = Math.sqrt(Math.pow(rectangularA, 2) + Math.pow(rectangularB, 2));
		
		//set the phasorMagnitude
		phasorMagnitudeET.setText(String.format("%.02f", phasorMagnitude));
		
		//store value for phasorDegree
		if(rectangularA < 0)
		{
			double phasorDegree = 180+((Math.atan((rectangularB/rectangularA)))*57.295779);
			phasorDegreeET.setText(String.format("%.02f", phasorDegree));
		}
		else
		{
			double phasorDegree = ((Math.atan((rectangularB/rectangularA)))*57.295779);
			phasorDegreeET.setText(String.format("%.02f", phasorDegree));
		}
		
		//set the phasorDegree
		phasorDegreeET.setText(String.format("%.02f", phasorDegree));
	}
	
	private void changeToRectangular(){
		
		//rectangularA = phasorMagnitude*cos(phasorDegree)
		//rectangularB = phasorMagnitude*sin(phasorDegree)
		
		//store the a rectangular form
		double rectangularA = phasorMagnitude *(Math.cos(phasorDegree/57.295779));
		
		//set the rectangular a
		rectangularAET.setText(String.format("%.02f", rectangularA));
		
		//store the b rectangular form
		double rectangularB = phasorMagnitude * (Math.sin(phasorDegree/57.295779));
		
		//set the rectangular b
		rectangularBET.setText(String.format("%.02f", rectangularB));
	}
	
	private void clear(){
		rectangularAET.setText("");
		rectangularBET.setText("");
		phasorMagnitudeET.setText("");
		phasorDegreeET.setText("");
	}
	
	//incase something is changed with the phone, this saves the information
	@Override
	protected void onSaveInstanceState(Bundle saveState){
		super.onSaveInstanceState(saveState);
		saveState.putDouble(RECTANGULAR_A, rectangularA);
		saveState.putDouble(RECTANGULAR_B, rectangularB);
		saveState.putDouble(PHASOR_MAGNITUDE, phasorMagnitude);
		saveState.putDouble(PHASOR_DEGREE, phasorDegree);
	}
	
	private void setButtonOnPressListeners(){
		
		enterButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if((rectangularA == 0.0 && rectangularB == 0.0)){
					//change to rectangular
					changeToRectangular(); 
				}
				else if((phasorMagnitude == 0.0 && phasorDegree == 0.0)){
					//change to phasor form
					changeToPhasor();
				}
			}
			
		});
		
		clearButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				//clear editable text fields
				clear();
				
			}
			
		});
		backButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent goToFirstActivity = new Intent(arg0.getContext(), MainActivity.class);
				startActivity(goToFirstActivity);	
			}
			
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
