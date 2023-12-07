package jo.joelly.bpt.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jo.joelly.bpt.MainActivity;
import jo.joelly.bpt.blood_pressure.BloodPressure;
import jo.joelly.bpt.blood_pressure.BloodPressureManager;
import jo.joelly.bpt.databinding.FragmentHomeBinding;
import jo.joelly.bpt.ui.home.blood_pressure.BloodPressureAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private RecyclerView _recyclerView;
    private BloodPressureAdapter _bloodPressureAdapter;

//    private Map< LocalDate, List<BloodPressure> > bloodPressureMap;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        bloodPressureMap = new HashMap<>();
//
//        addBloodPressure(new BloodPressure( 120, 80, 70, LocalDateTime.of( 2023, 1, 1, 8, 0)));
//        addBloodPressure(new BloodPressure(130, 85, 72, LocalDateTime.of(2023, 1, 1, 12, 30)));
//        addBloodPressure(new BloodPressure(115, 75, 68, LocalDateTime.of(2023, 1, 1, 18, 45)));
//
//        addBloodPressure(new BloodPressure(125, 82, 75, LocalDateTime.of(2023, 1, 2, 9, 15)));
//        addBloodPressure(new BloodPressure(135, 88, 78, LocalDateTime.of(2023, 1, 2, 14, 0)));
//        addBloodPressure(new BloodPressure(118, 78, 72, LocalDateTime.of(2023, 1, 2, 19, 30)));

        BloodPressureManager.getInstance( requireContext() ).addPressureRecord( new BloodPressure( 120, 80, 70, LocalDateTime.of( 2023, 1, 1, 8, 0)) );
        BloodPressureManager.getInstance( requireContext() ).addPressureRecord( new BloodPressure(130, 85, 72, LocalDateTime.of(2023, 1, 1, 12, 30)) );
        BloodPressureManager.getInstance( requireContext() ).addPressureRecord( new BloodPressure(115, 75, 68, LocalDateTime.of(2023, 1, 1, 18, 45)) );

        BloodPressureManager.getInstance( requireContext() ).addPressureRecord( new BloodPressure(125, 82, 75, LocalDateTime.of(2023, 1, 2, 9, 15)) );
        BloodPressureManager.getInstance( requireContext() ).addPressureRecord( new BloodPressure(135, 88, 78, LocalDateTime.of(2023, 1, 2, 14, 0)) );
        BloodPressureManager.getInstance( requireContext() ).addPressureRecord( new BloodPressure(118, 78, 72, LocalDateTime.of(2023, 1, 2, 19, 30)) );

        _recyclerView = binding.recyclerViewBloodPressureList;
        _recyclerView.setLayoutManager( new LinearLayoutManager( requireContext() ) );

        List<BloodPressure> bloodPressureList = BloodPressureManager.getInstance( requireContext() ).getPressureList();

        _bloodPressureAdapter = new BloodPressureAdapter( requireContext(), bloodPressureList );
        _recyclerView.setAdapter( _bloodPressureAdapter );

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final TextView textView_noRecordsYet = binding.textViewNoRecordsYet;

        if ( BloodPressureManager.getInstance( requireContext() ).getPressureList().size() > 0 )
            textView_noRecordsYet.setVisibility( View.INVISIBLE );



        return root;
    }

//    public void addBloodPressure(BloodPressure bloodPressure) {
//        LocalDate date = bloodPressure.getDateTime().toLocalDate();
//        bloodPressureMap.computeIfAbsent(date, k -> new ArrayList<>()).add( bloodPressure);
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}