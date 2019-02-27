package dev147.com.vn.projectpsychological.ui.main;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import dev147.com.vn.projectpsychological.R;
import dev147.com.vn.projectpsychological.databinding.ActivityMainBinding;
import dev147.com.vn.projectpsychological.ui.base.BaseActivity;
import dev147.com.vn.projectpsychological.ui.customer.CustomerFragment;
import dev147.com.vn.projectpsychological.ui.home.HomeFragment;
import io.reactivex.annotations.NonNull;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    @Override
    protected void initData() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        addFragment(R.id.mContainer, new HomeFragment(), HomeFragment.class.getName());
    }

    @Override
    protected void initListenerOnClick() {
        binding.ivHome.setOnClickListener(this);
        binding.ivUser.setOnClickListener(this);
        binding.tvHome.setOnClickListener(this);
        binding.tvUser.setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivHome:
            case R.id.tvHome:
                binding.ivHome.setImageResource(R.drawable.icon_home_select);
                binding.tvHome.setTextColor(getResources().getColor(R.color.main_text_select));
                binding.ivUser.setImageResource(R.drawable.icon_user_main);
                binding.tvUser.setTextColor(getResources().getColor(R.color.main_text));
                addFragment(R.id.mContainer, new HomeFragment(), HomeFragment.class.getName());
                break;
            case R.id.ivUser:
            case R.id.tvUser:
                binding.ivUser.setImageResource(R.drawable.icon_user_main_select);
                binding.tvUser.setTextColor(getResources().getColor(R.color.main_text_select));
                binding.ivHome.setImageResource(R.drawable.icon_home);
                binding.tvHome.setTextColor(getResources().getColor(R.color.main_text));
                addFragment(R.id.mContainer, new CustomerFragment(), CustomerFragment.class.getName());
                break;
        }
    }

    protected void addFragment(@IdRes int containerViewId,
                               @NonNull Fragment fragment,
                               @NonNull String fragmentTag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in_fragment, R.anim.fade_out_fragment);

        ft.replace(containerViewId, fragment, fragmentTag)
                .commit();
    }
}
