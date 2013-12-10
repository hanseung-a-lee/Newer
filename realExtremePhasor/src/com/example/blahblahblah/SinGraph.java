package com.example.blahblahblah;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;

public class SinGraph extends Activity {
	/** Called when the activity is first created. */
	
	double vmag, imag, vangle, iangle;
	Button backButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sin_graph);
		//Receive data from Main Activity Screen
		Bundle extras = getIntent().getExtras();
		vmag = extras.getDouble("vmag", 0.00);
		vangle = extras.getDouble("vangle", 0.00);
		imag = extras.getDouble("imag", 0.00);
		iangle = extras.getDouble("iangle", 0.00);
		
		//back button
		backButton = (Button) findViewById(R.id.back);
		
		//create listeners for buttons
		setButtonOnPressListeners();
		
		// 1 Phase Voltage Sin Curve
		int xmax = 1080;
		GraphViewData[] data = new GraphViewData[xmax];
		double startangle=vangle;
		for (int i=0; i<xmax; i++) {
			data[i] = new GraphViewData(i, Math.sqrt(2) * vmag * Math.sin(startangle*(Math.PI)/180));
			startangle += 30;
		}
		GraphViewSeries voltageSin1 = new GraphViewSeries("Voltage a", new GraphViewSeriesStyle(Color.rgb(200, 50, 00), 3), data);

		// 1 Phase Current Sin curve
		xmax = 1080;
		data = new GraphViewData[xmax];
		startangle=iangle;
		for (int i=0; i<xmax; i++) {
			data[i] = new GraphViewData(i, Math.sqrt(2) * imag * Math.sin(startangle*(Math.PI)/180));
			startangle += 30;
		}
		GraphViewSeries currentSin1 = new GraphViewSeries("Current a", new GraphViewSeriesStyle(Color.rgb(90, 250, 00), 3), data);

		// 2 Phase Voltage Sin Curve
		xmax = 1080;
		data = new GraphViewData[xmax];
		startangle=vangle-120;
		for (int i=0; i<xmax; i++) {
			data[i] = new GraphViewData(i, Math.sqrt(2) * vmag * Math.sin(startangle*(Math.PI)/180));
			startangle += 30;
		}
		GraphViewSeries voltageSin2 = new GraphViewSeries("Voltage b", new GraphViewSeriesStyle(Color.rgb(150, 40, 00), 3), data);
		
		// 2 Phase Voltage Sin Curve
		xmax = 1080;
		data = new GraphViewData[xmax];
		startangle=iangle-120;
		for (int i=0; i<xmax; i++) {
			data[i] = new GraphViewData(i, Math.sqrt(2) * imag * Math.sin(startangle*(Math.PI)/180));
			startangle += 30;
		}
		GraphViewSeries currentSin2 = new GraphViewSeries("Current b", new GraphViewSeriesStyle(Color.rgb(50, 50, 00), 3), data);
		
		// 3 Phase Voltage Sin Curve
		xmax = 1080;
		data = new GraphViewData[xmax];
		startangle=vangle-240;
		for (int i=0; i<xmax; i++) {
			data[i] = new GraphViewData(i, Math.sqrt(2) * vmag * Math.sin(startangle*(Math.PI)/180));
			startangle += 30;
		}
		GraphViewSeries voltageSin3 = new GraphViewSeries("Voltage c", new GraphViewSeriesStyle(Color.rgb(100, 80, 00), 3), data);

		// 3 Phase Current Sin curve
		xmax = 1080;
		data = new GraphViewData[xmax];
		startangle=iangle-240;
		for (int i=0; i<xmax; i++) {
			data[i] = new GraphViewData(i, Math.sqrt(2) * imag * Math.sin(startangle*(Math.PI)/180));
			startangle += 30;
		}
		GraphViewSeries currentSin3 = new GraphViewSeries("Current c", new GraphViewSeriesStyle(Color.rgb(30, 150, 00), 3), data);
		
		// graph with dynamically generated horizontal and vertical labels
		LineGraphView graphView;
		graphView = new LineGraphView(
				this
				, "Single Phase Graph"
		);
		// add data
		graphView.addSeries(voltageSin1);
		graphView.addSeries(currentSin1);
		// set legend
		graphView.setShowLegend(true);
		graphView.setLegendAlign(LegendAlign.BOTTOM);
		graphView.getGraphViewStyle().setLegendBorder(5);
		graphView.getGraphViewStyle().setLegendSpacing(5);
		graphView.getGraphViewStyle().setLegendWidth(210);
		
		// set view port, start=0, size=100
		graphView.setViewPort(0, 100);
		graphView.setScrollable(true);
		graphView.setScalable(true);
		LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		layout.addView(graphView);

		// graph with dynamically generated horizontal and vertical labels
		graphView = new LineGraphView(
				this
				, "Three Phase Graph"
		);
		// add data
		graphView.addSeries(voltageSin1);
		graphView.addSeries(currentSin1);
		graphView.addSeries(voltageSin2);
		graphView.addSeries(currentSin2);
		graphView.addSeries(voltageSin3);
		graphView.addSeries(currentSin3);

		// set legend
		graphView.setShowLegend(true);
		graphView.setLegendAlign(LegendAlign.BOTTOM);
		graphView.getGraphViewStyle().setLegendBorder(5);
		graphView.getGraphViewStyle().setLegendSpacing(5);
		graphView.getGraphViewStyle().setLegendWidth(210);

		// set view port, start=2, size=10
		graphView.setViewPort(0, 100);
		graphView.setScrollable(true);
		graphView.setScalable(true);
		layout = (LinearLayout) findViewById(R.id.graph2);
		layout.addView(graphView);
	}

	private void setButtonOnPressListeners(){
		backButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent goToFirstActivity = new Intent(arg0.getContext(), MainActivity.class);
				startActivity(goToFirstActivity);	
			}
			
		});
	}
}