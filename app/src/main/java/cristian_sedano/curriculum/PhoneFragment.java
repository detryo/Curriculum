package cristian_sedano.curriculum;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PhoneFragment extends Fragment {

    public PhoneFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.putExtra(Intent.EXTRA_PHONE_NUMBER, new String[]{"07548142387"});


        return inflater.inflate(R.layout.fragment_phone, container, false);
    }

}
