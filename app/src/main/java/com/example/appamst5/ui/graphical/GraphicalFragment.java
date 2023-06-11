package com.example.appamst5.ui.graphical;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.appamst5.databinding.FragmentGraphicalBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class GraphicalFragment extends Fragment {

    private FragmentGraphicalBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GraphicalViewModel graphicalViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(GraphicalViewModel.class);

        binding = FragmentGraphicalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        drawLineChart();
        final TextView textView = binding.textGraphical;
        graphicalViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;
    }
    private void drawLineChart() {
        LineChart lineChart = binding.linegraph;
        List<Entry> lineEntries = getDataSet();
        LineDataSet lineDataSet = new LineDataSet(lineEntries, "Work");
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setLineWidth(2);
        lineDataSet.setDrawValues(false);
        lineDataSet.setColor(Color.CYAN);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setCircleHoleRadius(3);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawHighlightIndicators(true);
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setHighLightColor(Color.CYAN);
        lineDataSet.setValueTextSize(12);
        lineDataSet.setValueTextColor(Color.DKGRAY);
        lineDataSet.setMode(LineDataSet.Mode.STEPPED);

        LineData lineData = new LineData(lineDataSet);
        lineChart.getDescription().setTextSize(12);
        lineChart.getDescription().setEnabled(false);
        lineChart.animateY(1000);
        lineChart.setData(lineData);

        // Setup X Axis
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(1.0f);
        xAxis.setXOffset(1f);
        xAxis.setLabelCount(25);
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(24);

        // Setup Y Axis
        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum(3);
        yAxis.setGranularity(1f);

        ArrayList<String> yAxisLabel = new ArrayList<>();
        yAxisLabel.add(" ");
        yAxisLabel.add("Rest");
        yAxisLabel.add("Work");
        yAxisLabel.add("2-up");

        lineChart.getAxisLeft().setCenterAxisLabels(true);
        lineChart.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                if(value == -1 || value >= yAxisLabel.size()) return "";
                return yAxisLabel.get((int) value);
            }
        });

        lineChart.getAxisRight().setEnabled(false);
        lineChart.invalidate();
    }
    private List<Entry> getDataSet() {
        List<Entry> lineEntries = new ArrayList<>();
        lineEntries.add(new Entry(0, 1));
        lineEntries.add(new Entry(1, 1));
        lineEntries.add(new Entry(2, 1));
        lineEntries.add(new Entry(3, 1));
        lineEntries.add(new Entry(4, 1));
        lineEntries.add(new Entry(5, 1));

        lineEntries.add(new Entry(6, 2));
        lineEntries.add(new Entry(7, 2));
        lineEntries.add(new Entry(8, 2));
        lineEntries.add(new Entry(9, 2));
        lineEntries.add(new Entry(10, 2));

        lineEntries.add(new Entry(11, 1));
        lineEntries.add(new Entry(12, 1));

        lineEntries.add(new Entry(13, 2));
        lineEntries.add(new Entry(14, 2));
        lineEntries.add(new Entry(15, 2));

        lineEntries.add(new Entry(16, 1));
        lineEntries.add(new Entry(17, 1));

        lineEntries.add(new Entry(18, 2));
        lineEntries.add(new Entry(19, 2));
        lineEntries.add(new Entry(20, 2));
        lineEntries.add(new Entry(21, 2));

        lineEntries.add(new Entry(22, 1));
        lineEntries.add(new Entry(23, 1));
        lineEntries.add(new Entry(24, 1));
        return lineEntries;
    }
}