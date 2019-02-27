package dev147.com.vn.projectpsychological.ui.base;

import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import dev147.com.vn.projectpsychological.di.ViewModelFactory;

import javax.inject.Inject;

public abstract class BaseActivity<T extends ViewModel, V extends ViewDataBinding> extends AppCompatActivity
        implements HasSupportFragmentInjector, View.OnClickListener {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    protected ViewModelFactory viewModelFactory;

    protected T viewModel;
    protected V binding;
    private static long lastClickTime = System.currentTimeMillis();
    protected Handler handler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setLifecycleOwner(this);
        handler = new Handler();
        initView();
        initData();
        initListenerOnClick();
    }

    protected abstract void initView();

    protected abstract void initListenerOnClick();

    protected abstract void initData();

    public abstract int getLayoutId();

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
