package dev147.com.vn.projectpsychological.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dev147.com.vn.projectpsychological.di.ViewModelFactory;
import dev147.com.vn.projectpsychological.ui.customer.CustomerViewModel;
import dev147.com.vn.projectpsychological.ui.home.HomeViewModel;
import dev147.com.vn.projectpsychological.ui.main.MainViewModel;
import dev147.com.vn.projectpsychological.ui.question.QuestionViewModel;
import dev147.com.vn.projectpsychological.ui.splash.SplashViewModel;
import dev147.com.vn.projectpsychological.ui.tutorial.TutorialViewModel;

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    abstract ViewModel bindSplashViewModel(SplashViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TutorialViewModel.class)
    abstract ViewModel bindTutorialViewModel(TutorialViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CustomerViewModel.class)
    abstract ViewModel bindCustomerViewModel(CustomerViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(QuestionViewModel.class)
    abstract ViewModel bindQuestionViewModel(QuestionViewModel viewModel);
}
