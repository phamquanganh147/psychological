package dev147.com.vn.projectpsychological.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.AndroidSupportInjection;
import dev147.com.vn.projectpsychological.di.ViewModelFactory;
import dev147.com.vn.projectpsychological.ui.main.MainViewModel;

import javax.inject.Inject;

public abstract class BaseFragment<T extends ViewModel, V extends ViewDataBinding> extends Fragment {
    @Inject
    ViewModelFactory viewModelFactory;

    protected T viewModel;

    protected V binding;

    protected MainViewModel mainViewModel;

    private static long lastClickTime = System.currentTimeMillis();

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        binding.setLifecycleOwner(this);
        initView();
        initData();
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getActivity() != null) {
//            if (getModelClass() != StatementDetailViewModel.class) {
//                viewModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(getModelClass());
//            } else {
//                viewModel = ViewModelProviders.of(this).get(getModelClass());
//            }
            viewModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(getModelClass());
            mainViewModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(MainViewModel.class);
        }
    }

    protected abstract void initView();

    protected abstract void initData();

    public abstract Class<T> getModelClass();

    public abstract int getLayoutId();
}
