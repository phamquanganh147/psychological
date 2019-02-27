package dev147.com.vn.projectpsychological.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import dev147.com.vn.projectpsychological.ui.question.QuestionFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new QuestionFragment();
    }

    @Override
    public int getCount() {
        return 60;
    }
}
