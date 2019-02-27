package dev147.com.vn.projectpsychological.ui.home;

import dev147.com.vn.projectpsychological.R;
import dev147.com.vn.projectpsychological.adapter.PagerAdapter;
import dev147.com.vn.projectpsychological.databinding.FramgmentHomeBinding;
import dev147.com.vn.projectpsychological.ui.base.BaseFragment;
import dev147.com.vn.projectpsychological.ui.custom.ViewPagerCustom;

public class HomeFragment extends BaseFragment<HomeViewModel, FramgmentHomeBinding> {

    @Override
    public Class<HomeViewModel> getModelClass() {
        return HomeViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.framgment_home;
    }

    @Override
    protected void initView() {
//        binding.mPager.setAdapter();
        PagerAdapter pagerAdapter = new PagerAdapter(getFragmentManager());
        binding.mPager.setAdapter(pagerAdapter);
        binding.mPager.setAnimationEnabled(true);
        binding.mPager.setFadeEnabled(true);
        binding.mPager.setFadeFactor(0.6f);
    }

    @Override
    protected void initData() {
    }
}
