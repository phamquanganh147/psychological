package dev147.com.vn.projectpsychological.ui.splash;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.github.ybq.android.spinkit.style.FadingCircle;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dev147.com.vn.projectpsychological.R;
import dev147.com.vn.projectpsychological.data.base.ObjectResponse;
import dev147.com.vn.projectpsychological.databinding.ActivitySplashBinding;
import dev147.com.vn.projectpsychological.di.ViewModelFactory;
import dev147.com.vn.projectpsychological.ui.base.BaseActivity;
import dev147.com.vn.projectpsychological.ui.tutorial.TutorialActivity;
import dev147.com.vn.projectpsychological.utils.Define;
import dev147.com.vn.projectpsychological.utils.Fields;
import dev147.com.vn.projectpsychological.utils.SharedPrefs;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<SplashViewModel, ActivitySplashBinding> {
    @Override
    protected void initView() {

    }
    @Override
    protected void initData() {
        FadingCircle stylePro = new FadingCircle();
        binding.progressBar.setIndeterminateDrawable(stylePro);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel.class);
        viewModel.getCount();

        if (!SharedPrefs.getInstance().getBoolean(Define.SharedPref.KEY_IS_FIRST, false)) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, TutorialActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            },2000);
        }
    }

    @Override
    protected void initListenerOnClick() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        initObserve();
    }

    private void initObserve() {
        viewModel.getCountCustomer().observe(this, this::observeCountCustomerSaveDb);
    }

    private void observeCountCustomerSaveDb(ObjectResponse<Long> integerObjectResponse) {
        switch (integerObjectResponse.getStatus()) {
            case Define.ResponseStatus.LOADING:
                break;
            case Define.ResponseStatus.SUCCESS:
                int count = integerObjectResponse.getData().intValue();
                if (count == Fields.NO_DATA) {
                    // no data

                    return;
                }
                break;
            case Define.ResponseStatus.ERROR:
                break;
            default:
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onClick(View v) {

    }
}
