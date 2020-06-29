package com.example.jekuo.sampleapp;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view
            .findViewById(R.id.button_first)
            .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment
                        .findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
            });
        TextView textView = view.findViewById(R.id.textview_first);
        String url =
            "#thisIsAReallyLongHashTagThatSpansTheEntireWidthOfScreenAndGetsCutOffThisIsAReallyLongHashTagThatSpansTheEntireWidthOfScreenAndGetsCutOff";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(url);
        HashtagSpan hashtagSpan = new HashtagSpan(url, getContext().getResources().getColor(R.color.linkColor));
        spannableStringBuilder.setSpan(hashtagSpan, 0, url.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableStringBuilder);
    }
}
