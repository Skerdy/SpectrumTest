package com.squareup.timessquare;

import android.view.ContextThemeWrapper;
import android.widget.TextView;

public class DefaultDayViewAdapter implements DayViewAdapter {
  @Override
  public void makeCellView(CalendarCellView parent, boolean highlighted) {
      TextView textView = new TextView(
              new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_CalendarDate));
      textView.setDuplicateParentStateEnabled(true);
      parent.addView(textView);
      parent.setDayOfMonthTextView(textView);

      if(highlighted) {
          TextView textView1 = new TextView(new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_Calendartrip));
          textView.setDuplicateParentStateEnabled(true);
          textView1.setText("Trip");
          parent.addView(textView1);
          parent.setTripText(textView1);
      }
  }
}
