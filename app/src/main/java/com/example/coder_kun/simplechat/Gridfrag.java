package com.example.coder_kun.simplechat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Gridfrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Gridfrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Gridfrag extends Fragment {
    GridView gridview;

    public static String[] emoNameList = {
            "Happy", "Sad", "Angry", "Depressed", "Wanna play",
            "Snuggly", "Wanna smoke", "Sleepy", "Scared", "Neutral",
            "Anxious", "Lovey dovey", "Confused", "Stressed", "Excited"
    };

//    public static int[] emoImages = {
//            R.drawable.happy, R.drawable.sad, R.drawable.angry, R.drawable.depressed, R.drawable.play,
//            R.drawable.snuggly, R.drawable.smoke, R.drawable.sleepy, R.drawable.scared, R.drawable.neutral,
//            R.drawable.anxious, R.drawable.lovey, R.drawable.confused, R.drawable.stressed, R.drawable.excited,
//            R.drawable.powerful, R.drawable.weak, R.drawable.peacful, R.drawable.intimate, R.drawable.bored, R.drawable.lonley, R.drawable.disappointed,
//            R.drawable.distant, R.drawable.agressive, R.drawable.hurt, R.drawable.offended, R.drawable.rejected, R.drawable.submessive, R.drawable.insecure,
//            R.drawable.sexy
//    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Gridfrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Gridfrag.
     */
    // TODO: Rename and change types and number of parameters
    public static Gridfrag newInstance(String param1, String param2) {
        Gridfrag fragment = new Gridfrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_gridfrag, container, false);
        gridview = (GridView) v.findViewById(R.id.gridoneid);
        gridview.setAdapter(new MyAdapter(getContext(), emoNameList));
        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
