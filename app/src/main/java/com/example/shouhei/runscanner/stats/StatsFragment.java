package com.example.shouhei.runscanner.stats;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.shouhei.runscanner.R;
import com.example.shouhei.runscanner.data.database.RunDbSchema;
import com.example.shouhei.runscanner.runs.Runs;
import com.example.shouhei.runscanner.util.DateHelper;
import com.example.shouhei.runscanner.util.DistanceHelper;
import com.example.shouhei.runscanner.util.TimeHelper;

import static com.example.shouhei.runscanner.data.database.RunDbSchema.*;

public class StatsFragment extends Fragment {

    private static final String TAG = "StatsFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.stats_frag, container, false);

        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.stats, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_this_week:
                Log.d(TAG, "settings is selected");
                updateUIThisWeek();
                return true;
            case R.id.menu_item_this_month:
                Log.d(TAG, "settings2 is selected");
                updateUIThisMonth();
                return true;
            case R.id.menu_item_this_year:
                Log.d(TAG, "settings3 is selected");
                updateUIThisYear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUIThisWeek() {
        Runs runs = Runs.get(getActivity());

        long firstDayTheWeek = DateHelper.getFirstDayOfTheWeek();
        long firstDayTheNextWeek = DateHelper.getFirstDayOfTheNextWeek();

        DateHelper.testDate2(firstDayTheWeek);
        DateHelper.testDate2(firstDayTheNextWeek);

        // counts of run
        long runCounts = runs.getRowCount(firstDayTheWeek, firstDayTheNextWeek);
        Log.d(TAG, "counts : " + String.valueOf(runCounts));

        // distance
        double distance =
                runs.getTotalDouble(RunTable.Cols.DISTANCE, firstDayTheWeek, firstDayTheNextWeek);
        Log.d(TAG, "distance : " + String.valueOf(distance));

        // calorie
        int calorie = runs.getTotalInt(RunTable.Cols.CALORIE, firstDayTheWeek, firstDayTheNextWeek);
        Log.d(TAG, "calorie : " + String.valueOf(calorie));

        // duration
        int duration =
                runs.getTotalInt(RunTable.Cols.DURATION, firstDayTheWeek, firstDayTheNextWeek);
        Log.d(TAG, "duration : " + String.valueOf(duration));

        // avg pace
        int avgPace =
                runs.getTotalInt(RunTable.Cols.AVERAGE_PACE, firstDayTheWeek, firstDayTheNextWeek);
        Log.d(TAG, "avg pace : " + String.valueOf(avgPace));

        // avg heart rate
        int avgHeartRate =
                runs.getTotalInt(
                        RunTable.Cols.AVERAGE_HEART_RATE, firstDayTheWeek, firstDayTheNextWeek);
        Log.d(TAG, "avg heart rate : " + String.valueOf(avgHeartRate));
    }

    private void updateUIThisMonth() {
        Runs runs = Runs.get(getActivity());

        long firstDayTheMonth = DateHelper.getFirstDayOfTheMonth();
        long firstDayTheNextMonth = DateHelper.getFirstDayOfTheNextMonth();

        DateHelper.testDate2(firstDayTheMonth);
        DateHelper.testDate2(firstDayTheNextMonth);

        // counts of run
        long runCounts = runs.getRowCount(firstDayTheMonth, firstDayTheNextMonth);
        Log.d(TAG, "counts : " + String.valueOf(runCounts));

        // distance
        double distance =
                runs.getTotalDouble(RunTable.Cols.DISTANCE, firstDayTheMonth, firstDayTheNextMonth);
        Log.d(TAG, "distance : " + String.valueOf(distance));

        // calorie
        int calorie =
                runs.getTotalInt(RunTable.Cols.CALORIE, firstDayTheMonth, firstDayTheNextMonth);
        Log.d(TAG, "calorie : " + String.valueOf(calorie));

        // duration
        int duration =
                runs.getTotalInt(RunTable.Cols.DURATION, firstDayTheMonth, firstDayTheNextMonth);
        Log.d(TAG, "duration : " + String.valueOf(duration));

        // avg pace
        int avgPace =
                runs.getTotalInt(
                        RunTable.Cols.AVERAGE_PACE, firstDayTheMonth, firstDayTheNextMonth);
        Log.d(TAG, "avg pace : " + String.valueOf(avgPace));

        // avg heart rate
        int avgHeartRate =
                runs.getTotalInt(
                        RunTable.Cols.AVERAGE_HEART_RATE, firstDayTheMonth, firstDayTheNextMonth);
        Log.d(TAG, "avg heart rate : " + String.valueOf(avgHeartRate));
    }

    private void updateUIThisYear() {
        Runs runs = Runs.get(getActivity());

        long firstDayTheYear = DateHelper.getFirstDayOfTheYear();
        long firstDayTheNextYear = DateHelper.getFirstDayOfTheNextYear();

        DateHelper.testDate2(firstDayTheYear);
        DateHelper.testDate2(firstDayTheNextYear);

        // counts of run
        long runCounts = runs.getRowCount(firstDayTheYear, firstDayTheNextYear);
        Log.d(TAG, "counts : " + String.valueOf(runCounts));

        // distance
        double distance =
                runs.getTotalDouble(RunTable.Cols.DISTANCE, firstDayTheYear, firstDayTheNextYear);
        Log.d(TAG, "distance : " + String.valueOf(distance));
        Log.d(TAG, "distance : " + DistanceHelper.convertMeterToMile(distance));

        // calorie
        int calorie = runs.getTotalInt(RunTable.Cols.CALORIE, firstDayTheYear, firstDayTheNextYear);
        Log.d(TAG, "calorie : " + String.valueOf(calorie));

        // duration
        int duration =
                runs.getTotalInt(RunTable.Cols.DURATION, firstDayTheYear, firstDayTheNextYear);
        Log.d(TAG, "duration : " + String.valueOf(duration));
        Log.d(TAG, "duration : " + TimeHelper.convertSecondToIso8601(duration));

        // avg pace
        int avgPace =
                runs.getTotalInt(RunTable.Cols.AVERAGE_PACE, firstDayTheYear, firstDayTheNextYear);
        Log.d(TAG, "avg pace : " + String.valueOf(avgPace));
        Log.d(TAG, "avg pace : " + getAvgPacePerRun(runCounts, avgPace));

        // avg heart rate
        int avgHeartRate =
                runs.getTotalInt(
                        RunTable.Cols.AVERAGE_HEART_RATE, firstDayTheYear, firstDayTheNextYear);
        Log.d(TAG, "avg heart rate : " + String.valueOf(avgHeartRate));
        Log.d(TAG, "avg heart rate : " + getAvgHeartRate(runCounts, avgHeartRate));
    }

    private String getAvgPacePerRun(long runCounts, int avgPace) {
        return TimeHelper.convertSecondToIso8601(avgPace / (int) runCounts);
    }

    private String getAvgHeartRate(long runCounts, int avgHeartRate) {
        return String.valueOf(avgHeartRate / (int) runCounts);
    }
}
