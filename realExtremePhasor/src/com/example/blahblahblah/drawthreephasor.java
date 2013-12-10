package com.example.blahblahblah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class drawthreephasor extends Activity{
	
	PhasorView ourView;
	
	public int vmag, vangle, imag, iangle;
	public boolean threephase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Bundle extras = getIntent().getExtras();
		vmag = (int) extras.getDouble("vmag", 0.00);
		vangle = (int) extras.getDouble("vangle", 0.00);
		imag = (int) extras.getDouble("imag", 0.00);
		iangle = (int) extras.getDouble("iangle", 0.00);
		threephase = (boolean) extras.getBoolean("threephase");
		
		ourView = new PhasorView(this,vmag,vangle,imag,iangle,threephase);
		
		
		setContentView(ourView);
	}

}
