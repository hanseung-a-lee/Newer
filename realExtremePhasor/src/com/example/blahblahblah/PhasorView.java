package com.example.blahblahblah;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class PhasorView extends View{
	
	Bitmap Vredarrow, Vbluearrow, Vgreenarrow, Iredarrow, Ibluearrow, Igreenarrow, arrowlegend, arrowonelegend, graphframe;
	int Va, Ia, Vb, Ib, Vc, Ic;
	int Vxa, Vya, Vxb, Vyb, Vxc, Vyc, Ixa, Iya, Ixb, Iyb, Ixc, Iyc;
	double g1, g2, g3, g4, g5, g6;
	int Vatheta, Vbtheta, Vctheta, Iatheta, Ibtheta, Ictheta;
	int width, height;
	double scaling;
	Matrix Vmatrixa = new Matrix();
	Matrix Vmatrixb = new Matrix();
	Matrix Vmatrixc = new Matrix();
	Matrix Imatrixa = new Matrix();
	Matrix Imatrixb = new Matrix();
	Matrix Imatrixc = new Matrix();
	DisplayMetrics screenpixelsize = new DisplayMetrics();
	drawthreephasor drawphasor = new drawthreephasor();
	int vmag = drawphasor.vmag;
	int vangle = drawphasor.vangle;
	int imag = drawphasor.imag;
	int iangle = drawphasor.iangle;
	
	int px, py;
	

	boolean threephase;
	
	public PhasorView(Context context, int vmag, int vangle, int imag, int iangle, boolean threephaseinput) {
		super(context);
		// TODO Auto-generated constructor st
		if ((vmag < 100) && (imag < 100))
		{
			vmag +=150;
			imag += 150;
		}
		
		Va =vmag;
		Vb =vmag;
		Vc =vmag;
		
		Ia =imag;
		Ib =imag;
		Ic =imag;
		
		threephase = threephaseinput;
	
		Vatheta = vangle;
		Vbtheta = Vatheta + 120;
		Vctheta = Vbtheta + 120;
		
		Iatheta = iangle;
		Ibtheta = Iatheta + 120;
		Ictheta = Ibtheta + 120;
		
		Vgreenarrow = BitmapFactory.decodeResource(getResources(), R.drawable.green_arrow);
		Vredarrow = BitmapFactory.decodeResource(getResources(), R.drawable.red_arrow);
		Vbluearrow = BitmapFactory.decodeResource(getResources(), R.drawable.blue_arrow);
		Igreenarrow = BitmapFactory.decodeResource(getResources(), R.drawable.teal_arrow);
		Iredarrow = BitmapFactory.decodeResource(getResources(), R.drawable.orange_arrow);
		Ibluearrow = BitmapFactory.decodeResource(getResources(), R.drawable.purple_arrow);
		arrowlegend = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_legend);
		arrowonelegend = BitmapFactory.decodeResource(getResources(), R.drawable.arrowonelegend);
		graphframe = BitmapFactory.decodeResource(getResources(), R.drawable.graph);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		graphframe = Bitmap.createScaledBitmap(graphframe, canvas.getWidth(), canvas.getHeight(), true);
		canvas.drawBitmap(graphframe, 0, 0, null);
		if(threephase == true)
		{
			arrowlegend = Bitmap.createScaledBitmap(arrowlegend, 100, 150, true);
			canvas.drawBitmap(arrowlegend,5, 5, null);
		}else{
			arrowonelegend = Bitmap.createScaledBitmap(arrowonelegend, 100, 50, true);
			canvas.drawBitmap(arrowonelegend, 5, 5, null);
		}

		if(vmag >= imag){
			if(vmag >= (canvas.getWidth()/2)){
				scaling = .01*((.90*Math.pow(canvas.getWidth(), 2)) / (4*vmag));
				vmag = (int) (scaling*vmag);
				imag = (int) (scaling*imag);
				canvas.drawBitmap(Vredarrow, 200, 10, null);
			}
			if(vmag >= (canvas.getHeight()/2)){
				scaling = .01*((.90*Math.pow(canvas.getHeight(), 2)) / (4*vmag));
				vmag = (int) (scaling*vmag);
				imag = (int) (scaling*imag);
			}
			if(vmag < (canvas.getWidth()/4)){
				scaling = .01*((.90*Math.pow(canvas.getWidth(), 2)) / (4*vmag));
				vmag = (int) (scaling*vmag);
				imag = (int) (scaling*imag);
			}
			if(vmag < (canvas.getHeight()/4)){
				scaling = .01*((.90*Math.pow(canvas.getHeight(), 2)) / (4*vmag));
				vmag = (int) (scaling*vmag);
				imag = (int) (scaling*imag);
			}
		}else if(imag > vmag){		
			if(imag >= (canvas.getWidth()/2)){
				scaling = .01*((.90*Math.pow(canvas.getWidth(), 2)) / (4*imag));
				vmag = (int) (scaling*vmag);
				imag = (int) (scaling*imag);
			}
			if(imag >= (canvas.getHeight()/2)){
				scaling = .01*((.90*Math.pow(canvas.getHeight(), 2)) / (4*imag));
				vmag = (int) (scaling*vmag);
				imag = (int) (scaling*imag);
			}
			if(imag < (canvas.getWidth()/2)){
				scaling = .01*((.90*Math.pow(canvas.getWidth(), 2)) / (4*imag));
				vmag = (int) (scaling*vmag);
				imag = (int) (scaling*imag);
			}
			if(imag < (canvas.getHeight()/2)){
				scaling = .01*((.90*Math.pow(canvas.getHeight(), 2)) / (4*imag));
				vmag = (int) (scaling*vmag);
				imag = (int) (scaling*imag);
			}
		}
		
		Vmatrixa.reset();
		Vmatrixb.reset();
		Vmatrixc.reset();
		
		Vmatrixa.setRotate(-Vatheta,Vredarrow.getWidth()/2,Vredarrow.getHeight()/2);
		Vmatrixb.setRotate(-Vbtheta,Vbluearrow.getWidth()/2,Vbluearrow.getHeight()/2);
		Vmatrixc.setRotate(-Vctheta,Vgreenarrow.getWidth()/2,Vgreenarrow.getHeight()/2);

		Imatrixa.reset();
		Imatrixb.reset();
		Imatrixc.reset();
		
		Imatrixa.setRotate(-Iatheta,canvas.getWidth()/2,canvas.getHeight()/2);
		Imatrixb.setRotate(-Ibtheta,canvas.getWidth()/2,canvas.getHeight()/2);
		Imatrixc.setRotate(-Ictheta,canvas.getWidth()/2,canvas.getHeight()/2);
		
		
		Vxa = (int) ((Va)*Math.cos(Vatheta*Math.PI/180));
		Vya = (int) ((Va/2)*Math.sin(Vatheta*Math.PI/180));
		
		Vxb = (int) ((Vb)*Math.cos(Vbtheta*Math.PI/180));
		Vyb = (int) ((Vb/2)*Math.sin(Vbtheta*Math.PI/180));
		
		Vxc = (int) ((Vc)*Math.cos(Vctheta*Math.PI/180));
		Vyc = (int) ((Vc/2)*Math.sin(Vctheta*Math.PI/180));
		
		Ixa = (int) ((Ia)*Math.cos(Iatheta*Math.PI/180));
		Iya = (int) ((Ia/2)*Math.sin(Iatheta*Math.PI/180));
		
		Ixb = (int) ((Ib)*Math.cos(Ibtheta*Math.PI/180));
		Iyb = (int) ((Ib/2)*Math.sin(Ibtheta*Math.PI/180));
		
		Ixc = (int) ((Ic)*Math.cos(Ictheta*Math.PI/180));
		Iyc = (int) ((Ic/2)*Math.sin(Ictheta*Math.PI/180));
		
		Vredarrow = Bitmap.createScaledBitmap(Vredarrow, Va, 10, true);
		Vbluearrow = Bitmap.createScaledBitmap(Vbluearrow, Vb, 10, true);
		Vgreenarrow = Bitmap.createScaledBitmap(Vgreenarrow, Vc, 10, true);
		
		Vredarrow = Bitmap.createBitmap(Vredarrow, 0, 0, Va, 10, Vmatrixa, true);
		Vbluearrow = Bitmap.createBitmap(Vbluearrow, 0, 0, Vb, 10, Vmatrixb, true);
		Vgreenarrow = Bitmap.createBitmap(Vgreenarrow, 0, 0, Vc, 10, Vmatrixc, true);
		
		Iredarrow = Bitmap.createScaledBitmap(Iredarrow, Ia, 10, true);
		Ibluearrow = Bitmap.createScaledBitmap(Ibluearrow, Ib, 10, true);
		Igreenarrow = Bitmap.createScaledBitmap(Igreenarrow, Ic, 10, true);
		
		Iredarrow = Bitmap.createBitmap(Iredarrow, 0, 0, Ia, 10, Imatrixa, true);
		Ibluearrow = Bitmap.createBitmap(Ibluearrow, 0, 0, Ib, 10, Imatrixb, true);
		Igreenarrow = Bitmap.createBitmap(Igreenarrow, 0, 0, Ic, 10, Imatrixc, true);

		
		if((Vatheta >=0 && Vatheta <= 90) || (Vatheta >= -360 && Vatheta <= -270) )
			canvas.drawBitmap(Vredarrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Vredarrow.getHeight()/2 - Vya), null);
	
		if((Vatheta > 90 && Vatheta <= 180) || (Vatheta > -270 && Vatheta <= -180))
			canvas.drawBitmap(Vredarrow, (canvas.getWidth()/2 + Vxa), (canvas.getHeight()/2 - Vredarrow.getHeight()/2 - Vya), null);
	
		if((Vatheta > 180 && Vatheta <= 270) || (Vatheta > -180 && Vatheta <= -90))
			canvas.drawBitmap(Vredarrow, (canvas.getWidth()/2 + Vxa), (canvas.getHeight()/2 - Vredarrow.getHeight()/2 - Vya), null);

		if((Vatheta > 270 && Vatheta <= 360) || (Vatheta > -90 && Vatheta <= 0))
			canvas.drawBitmap(Vredarrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Vredarrow.getHeight()/2 - Vya), null);
		
		if(threephase == true){
			if((Vbtheta >=0 && Vbtheta <= 90) || (Vbtheta >= -360 && Vbtheta <= -270))
				canvas.drawBitmap(Vbluearrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Vbluearrow.getHeight()/2 - Vyb), null);
		
			if((Vbtheta > 90 && Vbtheta <= 180) || (Vbtheta > -270 && Vbtheta <= -180))
				canvas.drawBitmap(Vbluearrow, (canvas.getWidth()/2 + Vxb), (canvas.getHeight()/2 - Vbluearrow.getHeight()/2 - Vyb), null);
				
			if((Vbtheta > 180 && Vbtheta <= 270) || (Vbtheta > -180 && Vbtheta <= -90))
				canvas.drawBitmap(Vbluearrow, (canvas.getWidth()/2 + Vxb), (canvas.getHeight()/2 - Vbluearrow.getHeight()/2 - Vyb), null);
				
			if((Vbtheta > 270 && Vbtheta <= 360) || (Vbtheta > -90 && Vbtheta <= 0))
				canvas.drawBitmap(Vbluearrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Vbluearrow.getHeight()/2 - Vyb), null);
				
			if((Vctheta >=0 && Vctheta <= 90) || (Vctheta >= -360 && Vctheta <= -270))
				canvas.drawBitmap(Vgreenarrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Vgreenarrow.getHeight()/2 - Vyc), null);
				
			if((Vctheta > 90 && Vctheta <= 180) || (Vctheta > -270 && Vctheta <= -180))
				canvas.drawBitmap(Vgreenarrow, (canvas.getWidth()/2 + Vxc), (canvas.getHeight()/2 - Vgreenarrow.getHeight()/2 - Vyc), null);
				
			if((Vctheta > 180 && Vctheta <= 270) || (Vctheta > -180 && Vctheta <= -90))
				canvas.drawBitmap(Vgreenarrow, (canvas.getWidth()/2 + Vxc), (canvas.getHeight()/2 - Vgreenarrow.getHeight()/2 - Vyc), null);
				
			if((Vctheta > 270 && Vctheta <= 360) || (Vctheta > -90 && Vctheta <= 0))
				canvas.drawBitmap(Vgreenarrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Vgreenarrow.getHeight()/2 - Vyc), null);
		}
							
		if((Iatheta >=0 && Iatheta <= 90) || (Iatheta >= -360 && Iatheta <= -270))
			canvas.drawBitmap(Iredarrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Iredarrow.getHeight()/2 - Iya), null);
	
		if((Iatheta > 90 && Iatheta <= 180) || (Iatheta > -270 && Iatheta <= -180))
			canvas.drawBitmap(Iredarrow, (canvas.getWidth()/2 + Ixa), (canvas.getHeight()/2 - Iredarrow.getHeight()/2 - Iya), null);
	
		if((Iatheta > 180 && Iatheta <= 270) || (Iatheta > -180 && Iatheta <= -90))
			canvas.drawBitmap(Iredarrow, (canvas.getWidth()/2 + Ixa), (canvas.getHeight()/2 - Iredarrow.getHeight()/2 - Iya), null);

		if((Iatheta > 270 && Iatheta <= 360) || (Iatheta > -90 && Iatheta <= 0))
			canvas.drawBitmap(Iredarrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Iredarrow.getHeight()/2 - Iya), null);

		if(threephase == true){
			if((Ibtheta >=0 && Ibtheta <= 90) || (Ibtheta >= -360 && Ibtheta <= -270))
				canvas.drawBitmap(Ibluearrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Ibluearrow.getHeight()/2 - Iyb), null);
		
			if((Ibtheta > 90 && Ibtheta <= 180) || (Ibtheta > -270 && Ibtheta <= -180))
				canvas.drawBitmap(Ibluearrow, (canvas.getWidth()/2 + Ixb), (canvas.getHeight()/2 - Ibluearrow.getHeight()/2 - Iyb), null);
		
			if((Ibtheta > 180 && Ibtheta <= 270) || (Ibtheta > -180 && Ibtheta <= -90))
				canvas.drawBitmap(Ibluearrow, (canvas.getWidth()/2 + Ixb), (canvas.getHeight()/2 - Ibluearrow.getHeight()/2 - Iyb), null);
	
			if((Ibtheta > 270 && Ibtheta <= 360) || (Ibtheta > -90 && Ibtheta <= 0))
				canvas.drawBitmap(Ibluearrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Ibluearrow.getHeight()/2 - Iyb), null);
	
			if((Ictheta >=0 && Ictheta <= 90) || (Ictheta >= -360 && Ictheta <= -270))
				canvas.drawBitmap(Igreenarrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Igreenarrow.getHeight()/2 - Iyc), null);
		
			if((Ictheta > 90 && Ictheta <= 180) || (Ictheta > -270 && Ictheta <= -180))
				canvas.drawBitmap(Igreenarrow, (canvas.getWidth()/2 + Ixc), (canvas.getHeight()/2 - Igreenarrow.getHeight()/2 - Iyc), null);
		
			if((Ictheta > 180 && Ictheta <= 270) || (Ictheta > -180 && Ictheta <= -90))
				canvas.drawBitmap(Igreenarrow, (canvas.getWidth()/2 + Ixc), (canvas.getHeight()/2 - Igreenarrow.getHeight()/2 - Iyc), null);
			
			if((Ictheta > 270 && Ictheta <= 360) || (Ictheta > -90 && Ictheta <= 0))
				canvas.drawBitmap(Igreenarrow, (canvas.getWidth()/2), (canvas.getHeight()/2 - Igreenarrow.getHeight()/2 - Iyc), null);
		}
	}
	

}
