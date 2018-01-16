package cristian_sedano.curriculum;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class EmailFragment extends Fragment {


    public EmailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ufholl@gmail.com"});
        intent.setType("text/plain");
        if (intent.resolveActivity(getActivity().getPackageManager()) !=null){
            getActivity().startActivity(Intent.createChooser(intent, "Send Email using"));
        }else {
            Toast.makeText(getActivity(), "You don't have any email app to contanct my", Toast.LENGTH_SHORT).show();
        }

        return inflater.inflate(R.layout.fragment_email, container, false);
    }

}
