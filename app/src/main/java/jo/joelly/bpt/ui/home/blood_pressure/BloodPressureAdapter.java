package jo.joelly.bpt.ui.home.blood_pressure;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import jo.joelly.bpt.R;
import jo.joelly.bpt.blood_pressure.BloodPressure;

public class BloodPressureAdapter extends RecyclerView.Adapter<BloodPressureAdapter.ViewHolder> {

    private static final String TAG = "BloodPressureAdapter";

    private final Context context;
    private final List<BloodPressure> _bloodPressureList;

    public BloodPressureAdapter(Context context, List<BloodPressure> bloodPressureList) {
        this.context = context;
        this._bloodPressureList = bloodPressureList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_Date, textView_Time, textView_SYS, textView_DIA, textView_Pulse;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView_Date = itemView.findViewById(R.id.textView_RecordDate);
            textView_Time = itemView.findViewById(R.id.textView_Time);

            textView_SYS = itemView.findViewById(R.id.textView_SYS);
            textView_DIA = itemView.findViewById(R.id.textView_DIA);
            textView_Pulse = itemView.findViewById(R.id.textView_Pulse);

            cardView = itemView.findViewById( R.id.cardView );
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
//        try
//        {
            View view = LayoutInflater.from( context ).inflate( R.layout.item_blood_pressure, parent, false );
            return new ViewHolder(view);
//        } catch ( Exception e )
//        {
//            Log.e( TAG, "onCreateView", e);
//            throw e;
//        }
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position) {

        BloodPressure record = _bloodPressureList.get( position );

        holder.textView_SYS.setText( String.valueOf( record.getSystolic() ) );
        holder.textView_DIA.setText( String.valueOf( record.getDiastolic() ) );
        holder.textView_Pulse.setText( String.valueOf( record.getPulse() ) );

        // Define the desired date pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "E, dd.MM.yyyy");

        // Format the LocalDate
        String formattedDate = record.getDateTime().format(formatter);

        // Define the desired date pattern
        DateTimeFormatter formatter_time = DateTimeFormatter.ofPattern( "HH:mm");

        // Format the LocalDate
        String formattedTime = record.getDateTime().format(formatter_time);

        holder.textView_Date.setText( String.valueOf( formattedDate ) );
        holder.textView_Time.setText( String.valueOf( formattedTime ) );

        holder.cardView.setOnClickListener( v ->
                                            {

                                            } );


//        List< LocalDate > dateList = new ArrayList<>( bloodPressureMap.keySet());
//        LocalDate currentDate = dateList.get(position);
//        List<BloodPressure> bloodPressureList = bloodPressureMap.get(currentDate);
//
//        // Первый элемент для отображения даты
//        if (position == 0) {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//            String formattedDate = dateFormat.format(currentDate);
//            holder.dateTextView.setVisibility(View.VISIBLE);
//            holder.dateTextView.setText(formattedDate);
//        } else {
//            holder.dateTextView.setVisibility(View.GONE);
//        }
//
//        // Здесь устанавливаем значения полей в элементы интерфейса
//        if (bloodPressureList != null) {
//            for (BloodPressure bloodPressure : bloodPressureList) {
//                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
//                String formattedTime = timeFormat.format(bloodPressure.getDateTime());
//
//                holder.timeTextView.setText(formattedTime);
//                holder.systolicTextView.setText("Systolic: " + bloodPressure.getSystolic());
//                holder.diastolicTextView.setText("Diastolic: " + bloodPressure.getDiastolic());
//                holder.pulseTextView.setText("Pulse: " + bloodPressure.getPulse());
//            }
//        }
    }

    @Override
    public int getItemCount() {
        return _bloodPressureList.size();
    }
}